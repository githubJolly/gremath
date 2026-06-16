#!/usr/bin/env bash
set -euo pipefail

if [[ $EUID -ne 0 ]]; then
  echo "Run as root (sudo -i)."
  exit 1
fi

if [[ $# -lt 2 ]]; then
  echo "Usage: $0 <domain> <panel_public_ip> [repo_url]"
  echo "Example: $0 app.example.com 203.0.113.10 https://github.com/you/GRE-Math.git"
  exit 1
fi

DOMAIN="$1"
PANEL_PUBLIC_IP="$2"
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
}

install_systemd_units() {
  cp "$APP_DIR/deploy/systemd/gremath-stack.service" /etc/systemd/system/gremath-stack.service

  systemctl daemon-reload
  systemctl enable gremath-stack.service
  systemctl start gremath-stack.service
}

install_prereqs
prepare_project
install_systemd_units

echo
echo "Deployment complete."
echo "HTTP URL (after panel mapping): http://$DOMAIN"
echo
echo "Next steps in your provider control panel:"
echo "1) Add domain mapping: $DOMAIN -> <your VPS internal IP>:80"
echo "2) Set DNS A record: $DOMAIN -> $PANEL_PUBLIC_IP"
echo "3) Enable SSL in provider panel for $DOMAIN (Free SSL or custom cert)"
echo "Stack service: systemctl status gremath-stack"
