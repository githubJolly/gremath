# Production Deployment (VPS)

> This guide is for shared-IP VPS providers (like Database Mart shared networking) where domain routing and SSL are managed in the provider control panel.

This project includes:

- `Dockerfile` for building and running the Spring Boot app
- `docker-compose.yml` with `app` and `nginx`
- Nginx reverse proxy config templates in `deploy/nginx/`
- `systemd` startup unit for persistent boot startup
- One-command VPS deploy script: `deploy/scripts/deploy-vps.sh`

## 1) DNS and firewall prerequisites

- In your provider control panel, you must be able to map domain traffic to your VPS internal port.
- Have your provider panel public IP ready (the one your domain should point to).

## 2) One-command deployment

Run as root on Ubuntu VPS:

```bash
curl -fsSL https://raw.githubusercontent.com/<your-org>/<your-repo>/<your-branch>/deploy/scripts/deploy-vps.sh -o /tmp/deploy-vps.sh
chmod +x /tmp/deploy-vps.sh
/tmp/deploy-vps.sh app.example.com 203.0.113.10 https://github.com/<your-org>/<your-repo>.git
```

If your project is already present at `/opt/gremath`, you can skip `repo_url`:

```bash
/opt/gremath/deploy/scripts/deploy-vps.sh app.example.com 203.0.113.10
```

## 3) What the script sets up

- Installs Docker Engine + Docker Compose plugin (if missing)
- Writes HTTP app proxy config for your domain
- Starts app + Nginx via `gremath-stack.service`

## 4) Provider control-panel steps (required on shared-IP VPS)

1. Add a domain mapping:
   - `app.example.com` -> `<your VPS internal IP>:80`
2. Add DNS A record:
   - `app.example.com` -> `<provider panel public IP>`
3. Enable SSL in provider panel (Free SSL or upload custom cert)

## 5) Useful operations

```bash
systemctl status gremath-stack
cd /opt/gremath && docker compose logs -f nginx app
```
