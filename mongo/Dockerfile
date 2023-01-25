FROM openjdk:17-alpine
VOLUME ./build/tmp
EXPOSE 21238
ARG JAR_FILE=./build/libs/mongo_user-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} mongo_user-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/mongo_user-0.0.1-SNAPSHOT.jar"]