FROM openjdk:11
RUN mkdir /app
ADD ./build/libs/daily_study_check-0.0.1-SNAPSHOT.jar /app
#WORKDIR /daily_study_check
#CMD ["./gradlew", "bootRun"]
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/app/daily_study_check-0.0.1-SNAPSHOT.jar"]