# Establecer la imagen base para compilar la aplicación
FROM eclipse-temurin:21-jdk as build

# Copiar el código fuente de la aplicación al contenedor
COPY . /app
WORKDIR /app

# Cambiar permisos y compilar la aplicación
RUN chmod +x mvnw  
RUN ./mvnw package -DskipTests
RUN mv -f target/*.jar app.jar

# Establecer la imagen base para ejecutar la aplicación
FROM eclipse-temurin:21-jre

# Definir el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Copiar el archivo JAR de la aplicación compilada
COPY --from=build /app/app.jar .

# Crear un usuario no privilegiado para ejecutar la aplicación
RUN useradd runtime
USER runtime

# Establecer el comando de inicio de la aplicación
ENTRYPOINT [ "java", "-jar", "app.jar" ]
