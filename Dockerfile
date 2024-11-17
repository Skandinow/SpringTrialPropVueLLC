FROM gradle:jdk17-alpine as build
WORKDIR /src
COPY --chown=gradle:gradle . /src
RUN gradle build --no-daemon --stacktrace


FROM eclipse-temurin:17-jre-jammy
WORKDIR opt/app
EXPOSE 8080
COPY --from=build /src/build/libs/*.jar /opt/app/app.jar
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]