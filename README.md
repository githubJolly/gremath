# GRE & CAT Math Tutor

A Spring Boot web application that **teaches** GRE and CAT quantitative topics, lets students
**practice** with auto-graded sheets, and **evaluates** their answers with instant feedback and
explanations. Every student has their own login, and their practice history and scores are saved.

## Features

- **Per-student accounts** – register and log in (passwords hashed with BCrypt via Spring Security).
- **Learn** – each topic has lessons with concepts, formulas and worked rules.
- **Practice** – topic-wise multiple-choice practice sheets.
- **Evaluate** – automatic scoring, right/wrong highlighting, full explanations, pass/fail banner.
- **Progress tracking** – dashboard shows attempts, best score and a history table.
- **10 quantitative topics** covering the GRE/CAT overlap:
  1. Number Properties & Divisibility
  2. Percentages
  3. Ratios & Proportions
  4. Averages, Mixtures & Alligation
  5. Algebra: Linear & Quadratic Equations
  6. Geometry & Mensuration
  7. Time, Speed & Distance
  8. Permutations & Combinations
  9. Probability
  10. Profit, Loss & Interest

## Tech stack

- Java 17, Spring Boot 3.2
- Spring MVC + Thymeleaf (server-rendered UI)
- Spring Security (form login)
- Spring Data JPA + H2 (file-based database, data persists in `./data/`)

## Prerequisites

You need a **JDK 17+** and **Maven**.

On Windows, the JDK is available via `winget`; Maven is not, so download it directly:

```powershell
# JDK 17
winget install --id EclipseAdoptium.Temurin.17.JDK -e

# Maven (download + unzip into your user profile)
Invoke-WebRequest -Uri "https://archive.apache.org/dist/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.zip" -OutFile "$env:TEMP\maven.zip"
Expand-Archive "$env:TEMP\maven.zip" -DestinationPath "$env:USERPROFILE\apache-maven" -Force
```

Add `%USERPROFILE%\apache-maven\apache-maven-3.9.9\bin` to your PATH, then reopen the terminal so
`java` and `mvn` are available.

## How to run

From the project root (`c:\Projects\GRE-Math`):

```powershell
mvn spring-boot:run
```

Then open <http://localhost:8080> in your browser.

To build a runnable jar instead:

```powershell
mvn clean package
java -jar target/gre-cat-math-1.0.0.jar
```

## Using the app

1. Open <http://localhost:8080> and click **Get started free** to register a student account.
2. Log in. You land on your **dashboard** showing all topics and your progress.
3. Click a topic to **read the lessons**, then click **Start practice**.
4. Answer the multiple-choice questions and **Submit & evaluate**.
5. The **results page** shows your score, marks each answer correct/incorrect, and explains every question.
6. Every attempt is saved under your account and shown in the dashboard history.

## Project structure

```
src/main/java/com/gremath
├── GreMathApplication.java        # entry point
├── config/
│   ├── SecurityConfig.java        # Spring Security (login, BCrypt)
│   └── DataInitializer.java       # seeds topics, lessons, questions
├── controller/                    # Auth, Dashboard, Topic, Practice controllers
├── dto/RegistrationForm.java
├── model/                         # Student, Topic, Lesson, Question, attempts
├── repository/                    # Spring Data JPA repositories
└── service/                       # StudentService, TopicService, PracticeService
src/main/resources
├── application.properties
├── static/css/style.css
└── templates/                     # Thymeleaf views
```

## Notes

- The H2 database file lives in `./data/gremathdb.*`. Delete that folder to reset all data
  (students + history); topics are re-seeded automatically on the next start.
- The H2 web console is available at <http://localhost:8080/h2-console>
  (JDBC URL `jdbc:h2:file:./data/gremathdb`, user `sa`, no password).
- To add or edit questions and lessons, modify `config/DataInitializer.java` and start with a fresh
  `./data/` folder.
