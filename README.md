# LetusLearn — New Zealand Curriculum tutor

A Spring Boot web application that **teaches** the New Zealand Curriculum for **Years 1–10**,
lets students **practice** with auto-graded sheets, and shows families **where to focus next**.
Every student has their own login. Practice history and scores are saved.

Lessons are original LetusLearn teaching, organised to the year-by-year sequences on
[Tāhūrangi](https://newzealandcurriculum.tahurangi.education.govt.nz/)
(English and Mathematics & Statistics Years 0–10, 2025; other learning areas taught
year-appropriately until their refresh). Official curriculum statements stay with the Ministry.

## Features

- **Years 1–10 × 8 learning areas** — Mathematics & Statistics, English, Science,
  Social Sciences, Technology, The Arts, Health & PE, and Learning Languages (te reo Māori).
- **Detailed lessons** — phase badge, learning goals, explanation, Aotearoa examples,
  worked solutions, tables, common mistakes, vocabulary and recap.
- **Year-specific question banks** — concept and word sheets matched to the lesson strand
  (not a single generic template for every year).
- **Family progress** — overall scores, averages by subject, strong skills, and areas under 70% to practise again.
- **Parent emails** — after every practice sheet the parent inbox receives the latest score and a subject-by-subject summary.
- **Per-student accounts** — register and log in (passwords hashed with BCrypt).

## Tech stack

- Java 17, Spring Boot 3.2
- Spring MVC + Thymeleaf (server-rendered UI)
- Spring Security (form login)
- Spring Data JPA + H2 (file-based database, data persists in `./data/`)

## How to run

```bash
mvn spring-boot:run
```

Then open <http://localhost:8080>. New accounts get a 2-day trial for the NZ curriculum track.

To reset seeded lessons after a content update, delete `./data/` and restart (accounts are also cleared).
`DataInitializer` also updates existing topics when lesson titles, keys or HTML change.

## Go live

Run with the production profile and real environment variables:

```bash
export SPRING_PROFILES_ACTIVE=prod
export APP_BASE_URL=https://letuslearn.it.com
export MAIL_FROM=noreply@letuslearn.it.com
export SPRING_MAIL_HOST=smtp.example.com
export SPRING_MAIL_PORT=587
export SPRING_MAIL_USERNAME=...
export SPRING_MAIL_PASSWORD=...
export STRIPE_SECRET_KEY=...
export STRIPE_PUBLISHABLE_KEY=...
export STRIPE_WEBHOOK_SECRET=...
mvn spring-boot:run
```

Without SMTP, verification and parent-progress emails are written to the application log so you can still test the flow locally.

If you deploy with Docker, a container restart is not enough after `git pull`. Rebuild the image:

```bash
git pull
docker compose build app
docker compose up -d app
```

Confirm the new build by viewing page source on `/login` and checking `ll-build` is `20260823e`.

## Tests

```bash
mvn test
```
