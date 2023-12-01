![Build](https://github.com/dattack/time-server/actions/workflows/maven-deploy.yml/badge.svg?branch=dev)
[![license](https://img.shields.io/:license-Apache-blue.svg?style=plastic-square)](LICENSE.md)
[![Maven Central](https://img.shields.io/maven-central/v/com.dattack/time-server.svg?label=Maven%20Central)](https://search.maven.org/artifact/com.dattack/time-server)

# Time server

This project provides a simple time-server that returns the current UTC time when a client connects to it. It allows to
convert the time to a different time zone (using the Olsen format) if one is specified. It is useful for testing
purposes only and should not be used in production environments.

The server is implemented using Spring-Boot and provides a REST API to retrieve the current time:

- `/api/time` returns the current UTC time.

- `/api/time?timeZone={zone}` returns the current time in the specified time zone. The time zone must be specified
  using the [Olsen](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones) format.

The most relevant features tested are:

- It is configured to execute the CI/CD pipeline using GitHub Actions.
- It contains a Dockerfile to build a Docker image and deploy it to a Docker registry.
- Maven is used to build the project, generate the JAR file and the Docker image, and deploy the JAR file to Maven
  Central and the Docker image to a Docker registry.

## Build

The project can be built using **Maven 3.6.3** or higher and **Java 17** or higher. Executing the following command will 
generate a self-contained JAR file in the `target` directory:

```shell
mvn clean package
```

The project also provides a Dockerfile to build a Docker image. The image can be built using Maven and
deployed to a Docker registry. Currently only `docker.io` is supported, but you can easily change it by modifying the
`docker.url` property in the `pom.xml` file. You also need to provide the credentials to access the registry. You can
do it by setting the `DOCKER_HUB_USERNAME` and `DOCKER_HUB_TOKEN` properties in the `settings.xml` file or by setting
environment variables with the same name.

The following command will build the JAR file and the Docker image, and deploy them to Maven Central and the Docker 
registry:

```shell
mvn clean package source:jar javadoc:jar install deploy
```

## Run

Using the self-contained  JAR file is the simplest way to run the server. You only need to execute the following
command:

```shell
java -jar time-server-<version>.jar
```

If you prefer to use Docker, you can run the server using the following command:

```shell
docker pull dattack/time-server:<version>
docker run -p 8080:8080 dattack/time-server:<version>
```

## License

Code is under the [Apache Licence v2](https://www.apache.org/licenses/LICENSE-2.0.txt).
