# spring-boot-jib-sample

## Containerize Spring Boot app with JIB - Demo.

### Steps :

1. Add jib-maven-plugin to build part in "pom.xml" :

````xml
...
<plugins>
    <plugin>
        <groupId>com.google.cloud.tools</groupId>
        <artifactId>jib-maven-plugin</artifactId>
        <version>3.4.4</version>
    </plugin>
</plugins>
````

2. Configure profiles to push image (locally or to registry)

3. Run maven build

* Maven command to push image locally

```shell
mvn -Dcontainer.mainClass=id.my.hendisantika.jibsample.SpringBootJibSampleApplication clean install jib:dockerBuild -Djib.to.image=springboot-jib:v1

```

* Maven command to push image to the registry

```shell
mvn clean install jib:build -Djib.to.image=hendisantika/springboot-jib:v1 -Djib.to.auth.username=your_username -Djib.to.auth.password=your_password
```

4. Start the container

```shell
docker run --name springboot-jib -p 8080:8080 springboot-jib:v1
```

5. APIs for testing :

> 1st: https://localhost:8080/api/v1/customers

<br/>

> 2nd: https://localhost:8080/api/v1/customers/maleCustomers
