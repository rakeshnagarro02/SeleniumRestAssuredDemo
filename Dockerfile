FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /workspace
COPY pom.xml ./
COPY src ./src

RUN apt-get update \
    && apt-get install -y --no-install-recommends chromium chromium-chromedriver \
    && rm -rf /var/lib/apt/lists/*

RUN mvn -q -DskipTests dependency:go-offline

CMD ["mvn", "test"]
