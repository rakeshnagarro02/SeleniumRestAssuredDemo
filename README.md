# Selenium REST Assured Demo

This Maven project is a QA automation framework example that combines:
- Selenium WebDriver web UI automation
- REST Assured API automation
- JUnit 5 and TestNG execution support
- CI/CD-ready Maven profiles and Docker execution

## Key capabilities
- Browser tests use a thread-safe `WebDriverFactory` and `BaseTest` setup
- Page Object Model support via `src/test/java/com/example/automation/web/pages`
- Local and CI profiles for headless/headed execution
- Parallel test execution configured with JUnit 5 and Surefire
- Dedicated TestNG suite via `testng.xml`
- Docker support for containerized test runs

## Project structure
- `src/test/java/com/example/automation/web` - Selenium test classes and shared test setup
- `src/test/java/com/example/automation/web/pages` - Page Object Model pages
- `src/test/java/com/example/automation/api` - REST Assured API tests
- `src/test/java/com/example/automation/testng` - TestNG suite classes
- `Dockerfile` - containerized Maven image with Chrome/ChromeDriver install
- `.github/workflows/ci.yml` - GitHub Actions CI configuration
- `testng.xml` - dedicated TestNG suite definition

## Prerequisites
- Java 17+
- Maven 3.9+
- Optional locally installed Chrome for headed browser execution

## Execution commands
### JUnit tests
```bash
mvn clean test
```

### Local headed browser mode
```bash
mvn clean test -Plocal
```

### CI / headless browser mode
```bash
mvn clean test -Pci
```

### Dedicated TestNG suite
```bash
mvn clean test -Ptestng
```

### Run inside Docker
```bash
docker build -t selenium-restassured-demo .
docker run --rm selenium-restassured-demo
```

## Maven profiles
- `local` - disables headless browser mode for local debugging
- `ci` - enables headless Chrome for CI environments
- `testng` - runs the `testng.xml` suite through Surefire

## How it works
- `WebDriverFactory` creates one WebDriver instance per thread using `ThreadLocal`
- `BaseTest` initializes and tears down browser sessions per test
- `ExampleHomePage` demonstrates a simple Page Object Model for `example.com`
- Surefire is configured to execute tests in parallel using multiple threads
- JaCoCo is configured in the POM, with exclusions for JDK and HtmlUnit classes to avoid instrumentation issues

## CI/CD
The GitHub Actions workflow runs on `main` branch pushes and pull requests:
- checks out the repository
- installs JDK 17
- executes `mvn clean test -Pci`

## Explanation for others
If someone asks about this setup, explain that it is a reusable Maven-based automation framework with:
- separate UI and API test layers
- modern Java test tooling (JUnit 5 + TestNG)
- profile-driven browser configuration for local and CI use
- Docker support for consistent environment execution
- a lightweight Page Object Model for maintainable UI tests

## Suggested next improvements
- Add Allure or HTML reporting
- Add data-driven test support and test data management
- Add more page objects and application-specific flows
- Add browser compatibility profiles (Chrome, Firefox, Edge)
