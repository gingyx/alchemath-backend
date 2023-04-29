FROM openjdk
EXPOSE 3880
COPY --from=build /target/backend-0.0.1-snapshot.jar backend-0.0.1-snapshot.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-docker.jar"]