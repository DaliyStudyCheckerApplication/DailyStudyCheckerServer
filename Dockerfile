FROM openjdk:11
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
#COPY . /daily_study_check
#WORKDIR /daily_study_check
#CMD ["./gradlew", "bootRun"]
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/app.jar"]