# GRE & CAT Math Tutor

Spring Boot (Java 17, Maven) server-rendered web app that teaches GRE/CAT/NZ-curriculum
quantitative math with auto-graded practice sheets and per-student progress tracking. The UI is
branded "letuslearn.it.com" and the primary active track is the NZ curriculum.

See `README.md` for the feature overview and standard build/run commands, and `DEPLOYMENT.md` for
the Docker/VPS production setup.

## Cursor Cloud specific instructions

Single service only — a Spring Boot web app on port `8080`. There is no external database, cache, or
broker; H2 runs in-process. Stripe billing and SMTP mail are optional and the app starts fine
without them.

- Toolchain: JDK 21 and Maven 3.8.7 are pre-installed. The project targets Java 17
  (`<java.version>17</java.version>`) but compiles and runs cleanly on JDK 21 — no JDK switch needed.
  There is no Maven wrapper (`mvnw`); use the system `mvn`.
- Run (dev): `mvn spring-boot:run`, then open http://localhost:8080 . Build a jar with
  `mvn clean package` → `java -jar target/gre-cat-math-1.0.0.jar`.
- Tests/lint: `src/test` has no test sources, so `mvn test` passes trivially. No lint/formatter
  plugin is configured.
- Database: file-based H2 at `./data/gremathdb.*` (gitignored). Delete the `./data/` folder to reset
  all accounts/history; topics, lessons and questions are re-seeded automatically on next startup.
  H2 web console is at http://localhost:8080/h2-console (JDBC `jdbc:h2:file:./data/gremathdb`, user
  `sa`, empty password).
- Email verification gotcha: accounts start disabled and cannot log in until the email is verified.
  With no SMTP configured (the default here), the verification link is NOT emailed — it is written to
  the app log instead. After registering, grab it from the running server's stdout, e.g.
  `grep -o 'http://localhost:8080/verify-email?token=[a-f0-9-]*' <run-log>`, then open that URL to
  enable login.
- Registering auto-starts a 2-day NZ-curriculum free trial, which grants access to the topics and
  practice sheets, so a freshly verified account can immediately practice end to end.
