FROM amazoncorretto:17.0.11

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} notification_service.jar

ENTRYPOINT ["java", "-jar", "/notification_service.jar"]

EXPOSE 9503