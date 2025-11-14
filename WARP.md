# WARP.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

## Build, test, and packaging commands

This is a simple Maven-based Java 17 WAR project.

- **Run all tests** (JUnit 5 via Surefire):
  - `mvn test`
- **Run a single test class**:
  - `mvn -Dtest=MyTestClass test`
- **Run a single test method** in a test class:
  - `mvn -Dtest=MyTestClass#myTestMethod test`
- **Compile and package the application as a WAR**:
  - `mvn clean package`

Notes:
- The project POM (`pom.xml`) declares `jakarta.servlet:jakarta.servlet-api` with `scope=provided`, so the built WAR is intended to run in an external Servlet container (e.g., Tomcat/Jetty) rather than via an embedded server.
- There are currently no explicit linting or static-analysis plugins configured in `pom.xml`; build and test are handled by standard Maven lifecycle goals.

## High-level architecture and structure

### Maven layout

- Standard Maven layout is used:
  - `src/main/webapp` — JSP views and web resources.
  - `src/main/webapp/WEB-INF/web.xml` — Jakarta EE web deployment descriptor.
  - (No Java source files are present yet under `src/main/java`; future servlets/controllers would live there.)

### Web layer

- `src/main/webapp/index.jsp`
  - Simple JSP landing page acting as the welcome file.
  - Renders a basic "Puzzle Game" home screen with a link to `game` (which will need to be handled by future routing/servlet logic).
- `src/main/webapp/WEB-INF/web.xml`
  - Declares a Jakarta EE 10 (`web-app` version `6.0`) configuration.
  - Sets `index.jsp` as the welcome file.
  - No servlets, filters, or listeners are currently defined; request handling beyond the welcome page will need to be added here (or via annotations in future Java classes).

### Dependencies and testing

- **Runtime/web container**:
  - `jakarta.servlet:jakarta.servlet-api:6.0.0` (scope `provided`) — Servlet API supplied by the container at runtime.
- **Testing**:
  - `org.junit.jupiter:junit-jupiter:5.10.2` — JUnit 5 (Jupiter) for unit tests, wired via `maven-surefire-plugin`.
  - Tests should be placed under `src/test/java` and use JUnit 5 annotations (e.g., `@Test` from `org.junit.jupiter.api`).

### Build plugins

- `maven-compiler-plugin`
  - Configured with `release` 17 and `maven.compiler.source/target` 17, so Java 17 language features are available.
- `maven-surefire-plugin`
  - Version `3.2.5`, with `useModulePath=false`, ensuring JUnit 5 tests run correctly in the default classpath-based setup.
- `maven-war-plugin`
  - Produces the `puzzle-game-webapp` WAR artifact and does not require a `web.xml` for deployment (`failOnMissingWebXml=false`).