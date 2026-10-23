# spring-boot-jib-sample

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-jib-sample/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-jib-sample/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen)
![Jib](https://img.shields.io/badge/Jib-3.5.2-blue)

## Containerize Spring Boot app with JIB - Demo.

Build an OCI container image for a Spring Boot app with [Jib](https://github.com/GoogleContainerTools/jib), without a
`Dockerfile`.

### Tech Stack

| Component        | Version             |
|------------------|---------------------|
| Java (JDK)       | 25                  |
| Spring Boot      | 4.1.1               |
| Jib Maven Plugin | 3.5.2               |
| Base image       | `amazoncorretto:25` |
| Build tool       | Maven (wrapper)     |

### Prerequisites

* JDK 25
* Docker (only needed for `jib:dockerBuild`)

### Steps :

1. Add jib-maven-plugin to build part in "pom.xml" :

````xml
...
<plugins>
    <plugin>
        <groupId>com.google.cloud.tools</groupId>
        <artifactId>jib-maven-plugin</artifactId>
        <version>3.5.2</version>
        <configuration>
            <from>
                <image>amazoncorretto:25</image>
            </from>
            <container>
                <ports>
                    <port>8080</port>
                </ports>
                <format>OCI</format>
            </container>
        </configuration>
    </plugin>
</plugins>
````

2. Configure profiles to push image (locally or to registry)

* `push-image-locally` — builds `hendisantika/springboot-jib:<tag>` and `:latest` into the local Docker daemon
* `push-image-to-dockerhub` — pushes `docker.io/hendisantika/springboot-jib:<tag>` and `:latest` to Docker Hub

```shell
./mvnw clean package -Ppush-image-locally -Dapp.image.tag=v1
```

3. Run maven build

* Maven command to push image locally

```shell
./mvnw -Dcontainer.mainClass=id.my.hendisantika.jibsample.SpringBootJibSampleApplication clean install jib:dockerBuild -Djib.to.image=springboot-jib:v1
```

* Maven command to push image to the registry

```shell
./mvnw clean install jib:build -Djib.to.image=hendisantika/springboot-jib:v1 -Djib.to.auth.username=your_username -Djib.to.auth.password=your_password
```

4. Start the container

```shell
docker run --name springboot-jib -p 8080:8080 springboot-jib:v1
```

5. APIs for testing :

> 1st: http://localhost:8080/api/v1/customers

<br/>

> 2nd: http://localhost:8080/api/v1/customers/maleCustomers

### Continuous Integration

GitHub Actions ([`.github/workflows/maven.yml`](.github/workflows/maven.yml)) builds and tests the project on JDK 25
(Temurin) for every push and pull request to `main`. On pushes to `main` it also submits the Maven dependency graph so
Dependabot alerts are accurate.

### Dependency Updates

Dependabot ([`.github/dependabot.yml`](.github/dependabot.yml)) checks Maven and GitHub Actions dependencies daily at
05:00 (Asia/Jakarta):

* Spring, Maven plugin and minor/patch updates are grouped to reduce PR noise
* All GitHub Actions updates are grouped into a single PR
* PRs are labelled and use `build(deps)` / `ci(deps)` conventional commit prefixes
* Spring Boot major upgrades are skipped and done manually
