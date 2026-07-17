# Copilot review instructions for this repository

This repository is a Java/Maven test automation project that combines Selenium, REST Assured, JUnit 5, and TestNG.

## Review focus
- Prefer maintainable test code and page-object patterns.
- Keep browser tests deterministic and CI-safe.
- Avoid hardcoded waits or brittle selectors where possible.
- Do not expose secrets in code, logs, or workflow files.
- Ensure Maven and Java 17 compatibility for CI runs.

## Quality expectations
- Changes in `src/test/java/com/example/automation/web/**` should preserve headless CI coverage.
- Changes in `src/test/java/com/example/automation/api/**` should keep API tests isolated and deterministic.
- Changes in `.github/workflows/**` should remain minimal, idempotent, and secure.
- `pom.xml` changes should preserve plugin compatibility and test execution behavior.
