FROM maven AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

FROM openjdk
COPY --from=build /target/backend-0.0.1-snapshot.jar backend-0.0.1-snapshot.jar
EXPOSE 3880
ENTRYPOINT ["java", "-jar", "backend-0.0.1-snapshot.jar"]