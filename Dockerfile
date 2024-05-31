FROM openjdk:21
COPY "./target/ProyectoATOS-1.jar" "app.jar"
EXPOSE 8060
ENTRYPOINT ["java", "-jar", "app.jar"]