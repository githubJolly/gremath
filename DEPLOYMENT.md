# Production Deployment (VPS)

This project includes:

- `Dockerfile` for building and running the Spring Boot app
- `docker-compose.yml` with `app`, `nginx`, and `certbot`
- Nginx reverse proxy config templates in `deploy/nginx/`
- SSL auto-renew via `systemd` timer + `deploy/scripts/renew-cert.sh`
- `systemd` startup unit for persistent boot startup
- One-command VPS deploy script: `deploy/scripts/deploy-vps.sh`

## 1) DNS and firewall prerequisites

- Point your domain A record to your VPS IP.
- Open ports `80` and `443` on your VPS firewall/security group.

## 2) One-command deployment

Run as root on Ubuntu VPS:

```bash
curl -fsSL https://raw.githubusercontent.com/<your-org>/<your-repo>/<your-branch>/deploy/scripts/deploy-vps.sh -o /tmp/deploy-vps.sh
chmod +x /tmp/deploy-vps.sh
/tmp/deploy-vps.sh app.example.com admin@example.com https://github.com/<your-org>/<your-repo>.git
```

If your project is already present at `/opt/gremath`, you can skip `repo_url`:

```bash
/opt/gremath/deploy/scripts/deploy-vps.sh app.example.com admin@example.com
```

## 3) What the script sets up

- Installs Docker Engine + Docker Compose plugin (if missing)
- Creates Nginx bootstrap HTTP config
- Starts app + Nginx
- Issues Let's Encrypt certificate with Certbot (webroot)
- Switches Nginx to TLS config and reloads
- Installs and enables:
  - `gremath-stack.service` (startup)
  - `gremath-cert-renew.timer` (auto-renew, twice daily)

## 4) Useful operations

```bash
systemctl status gremath-stack
systemctl status gremath-cert-renew.timer
systemctl list-timers | grep gremath-cert-renew
cd /opt/gremath && docker compose logs -f nginx app
```
