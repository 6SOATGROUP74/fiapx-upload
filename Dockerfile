FROM openjdk:17-alpine


COPY ./target/fiapx-upload-v1.jar app.jar

#ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 8080