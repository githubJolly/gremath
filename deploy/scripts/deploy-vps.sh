#!/usr/bin/env bash
set -euo pipefail

if [[ $EUID -ne 0 ]]; then
  echo "Run as root (sudo -i)."
  exit 1
fi

if [[ $# -lt 2 ]]; then
  echo "Usage: $0 <domain> <email> [repo_url]"
  echo "Example: $0 app.example.com admin@example.com https://github.com/you/GRE-Math.git"
  exit 1
fi

DOMAIN="$1"
EMAIL="$2"
REPO_URL="${3:-}"
APP_DIR="/opt/gremath"

install_prereqs() {
  apt-get update
  apt-get install -y ca-certificates curl git gnupg lsb-release

  if ! command -v docker >/dev/null 2>&1; then
    install -m 0755 -d /etc/apt/keyrings
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
    chmod a+r /etc/apt/keyrings/docker.asc
    echo \
      "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
      $(. /etc/os-release && echo "$VERSION_CODENAME") stable" >/etc/apt/sources.list.d/docker.list
    apt-get update
    apt-get install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
  fi

  if ! docker compose version >/dev/null 2>&1; then
    apt-get install -y docker-compose-plugin
  fi

  systemctl enable docker
  systemctl start docker
}

prepare_project() {
  if [[ -n "$REPO_URL" ]]; then
    rm -rf "$APP_DIR"
    git clone "$REPO_URL" "$APP_DIR"
  fi

  if [[ ! -d "$APP_DIR" ]]; then
    echo "Project not found at $APP_DIR and no repo_url provided."
    exit 1
  fi

  cd "$APP_DIR"

  sed "s/__DOMAIN__/$DOMAIN/g" deploy/nginx/app.http.conf.template > deploy/nginx/app.conf
  chmod +x deploy/scripts/renew-cert.sh
}

issue_initial_certificate() {
  cd "$APP_DIR"

  docker compose up -d app nginx
  docker compose run --rm certbot certonly \
    --webroot \
    -w /var/www/certbot \
    -d "$DOMAIN" \
    --email "$EMAIL" \
    --agree-tos \
    --no-eff-email

  sed "s/__DOMAIN__/$DOMAIN/g" deploy/nginx/app.conf.template > deploy/nginx/app.conf
  docker compose restart nginx
}

install_systemd_units() {
  cp "$APP_DIR/deploy/systemd/gremath-stack.service" /etc/systemd/system/gremath-stack.service
  cp "$APP_DIR/deploy/systemd/gremath-cert-renew.service" /etc/systemd/system/gremath-cert-renew.service
  cp "$APP_DIR/deploy/systemd/gremath-cert-renew.timer" /etc/systemd/system/gremath-cert-renew.timer

  systemctl daemon-reload
  systemctl enable gremath-stack.service
  systemctl start gremath-stack.service
  systemctl enable --now gremath-cert-renew.timer
}

install_prereqs
prepare_project
issue_initial_certificate
install_systemd_units

echo
echo "Deployment complete."
echo "URL: https://$DOMAIN"
echo "Stack service: systemctl status gremath-stack"
echo "Renew timer:  systemctl status gremath-cert-renew.timer"
