#!/usr/bin/env bash
# Delete all student accounts (and their practice/sheet attempts) from the H2 DB.
# Keeps curriculum content (topics / lessons / questions).
#
# VPS (Docker):
#   cd /opt/gremath
#   sudo bash deploy/scripts/clear-accounts.sh
#
# Local file DB:
#   bash deploy/scripts/clear-accounts.sh --local
#
# Skip prompt:
#   sudo bash deploy/scripts/clear-accounts.sh --yes

set -euo pipefail

MODE="docker"
CONFIRM=""

for arg in "$@"; do
  case "$arg" in
    --local) MODE="local" ;;
    --yes|-y) CONFIRM="DELETE" ;;
    -h|--help)
      sed -n '2,14p' "$0"
      exit 0
      ;;
    *)
      echo "Unknown option: $arg" >&2
      exit 1
      ;;
  esac
done

echo "This permanently deletes ALL student accounts and their attempt history."
echo "Curriculum content (topics/lessons/questions) is kept."
if [[ -z "$CONFIRM" ]]; then
  read -r -p "Type DELETE to continue: " CONFIRM
fi
if [[ "$CONFIRM" != "DELETE" ]]; then
  echo "Aborted."
  exit 1
fi

SQL_FILE="$(mktemp)"
trap 'rm -f "$SQL_FILE"' EXIT

cat >"$SQL_FILE" <<'EOF'
SET REFERENTIAL_INTEGRITY FALSE;
DELETE FROM ATTEMPT_ANSWERS;
DELETE FROM PRACTICE_ATTEMPTS;
DELETE FROM SHEET_ANSWER_OPTIONS;
DELETE FROM SHEET_ANSWERS;
DELETE FROM SHEET_ATTEMPTS;
DELETE FROM STUDENTS;
SET REFERENTIAL_INTEGRITY TRUE;
SELECT COUNT(*) AS REMAINING_STUDENTS FROM STUDENTS;
EOF

H2_VERSION="${H2_VERSION:-2.2.224}"

run_against_mount() {
  local mount_spec="$1" # e.g. gremath_app_data:/data  OR  /host/data:/data

  docker run --rm \
    -v "$mount_spec" \
    -v "$SQL_FILE:/tmp/clear-accounts.sql:ro" \
    maven:3.9.8-eclipse-temurin-17 \
    bash -c "
      set -euo pipefail
      curl -fsSL -o /tmp/h2.jar \
        https://repo1.maven.org/maven2/com/h2database/h2/${H2_VERSION}/h2-${H2_VERSION}.jar
      SQL=\$(tr '\\n' ' ' </tmp/clear-accounts.sql)
      java -cp /tmp/h2.jar org.h2.tools.Shell \
        -url 'jdbc:h2:file:/data/gremathdb;IFEXISTS=TRUE' \
        -user sa \
        -password '' \
        -sql \"\$SQL\"
    "
}

if [[ "$MODE" == "local" ]]; then
  ROOT="$(cd "$(dirname "$0")/../.." && pwd)"
  DB_DIR="$ROOT/data"
  if [[ ! -f "$DB_DIR/gremathdb.mv.db" && ! -f "$DB_DIR/gremathdb.db" ]]; then
    echo "No local H2 database found at $DB_DIR/gremathdb*" >&2
    exit 1
  fi
  echo "Make sure the Spring Boot app is stopped so H2 is unlocked."
  run_against_mount "$DB_DIR:/data"
  echo "Done. REMAINING_STUDENTS above should be 0."
  exit 0
fi

if [[ ! -f docker-compose.yml ]]; then
  echo "Run from the app directory that contains docker-compose.yml (e.g. /opt/gremath)" >&2
  exit 1
fi

PROJECT_NAME="$(docker compose config --format json 2>/dev/null \
  | sed -n 's/.*"name"[[:space:]]*:[[:space:]]*"\([^"]*\)".*/\1/p' \
  | head -1)"
if [[ -z "${PROJECT_NAME:-}" ]]; then
  PROJECT_NAME="$(basename "$(pwd)" | tr '[:upper:]' '[:lower:]')"
fi
FULL_VOLUME="${PROJECT_NAME}_app_data"

if ! docker volume inspect "$FULL_VOLUME" >/dev/null 2>&1; then
  echo "Docker volume not found: $FULL_VOLUME" >&2
  docker volume ls
  exit 1
fi

echo "Using volume: $FULL_VOLUME"
echo "Stopping app so H2 unlocks the database file..."
docker compose stop app

run_against_mount "$FULL_VOLUME:/data"

echo "Starting app..."
docker compose start app

echo "Done. REMAINING_STUDENTS above should be 0."
echo "You can register fresh accounts now."
