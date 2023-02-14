FROM openjdk:17
ARG JAR_FILE=out/artifacts/chave_pix_jar/*.jar
COPY ${JAR_FILE} pix.jar
ENTRYPOINT ["java", "-jar", "/pix.jar"]