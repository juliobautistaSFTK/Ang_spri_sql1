FROM ubuntu:20.04

# Establecer el frontend de debconf a "noninteractive"
ENV DEBIAN_FRONTEND=noninteractive

# Instalar Nginx, Maven, Docker, Node.js y MySQL
RUN apt-get update && apt-get install -y \
    nginx \
    maven \
    docker.io \
    curl \
    gnupg2 && \
    # Instalar Node.js y npm
    curl -sL https://deb.nodesource.com/setup_16.x | bash - && \
    apt-get install -y nodejs && \
    # Preconfigurar la zona horaria y MySQL para evitar preguntas interactivas
    echo "mysql-server mysql-server/root_password password Canada" | debconf-set-selections && \
    echo "mysql-server mysql-server/root_password_again password Canada" | debconf-set-selections && \
    echo "mysql-server mysql-server/skip-preseed boolean true" | debconf-set-selections && \
    # Configurar la zona horaria
    ln -sf /usr/share/zoneinfo/America/Mexico_City /etc/localtime && \
    echo "America/Mexico_City" > /etc/timezone && \
    # Instalar MySQL
    apt-get install -y mysql-server && \
    # Limpiar caché de apt
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Copiar el código fuente de la aplicación Spring Boot
COPY . /app
WORKDIR /app

# Construir la aplicación Spring Boot
RUN mvn clean package -DskipTests

# Exponer los puertos necesarios (80 para Nginx, 8080 para Spring Boot, 3306 para MySQL)
EXPOSE 80 8080 3306

# Iniciar el servicio MySQL y crear la base de datos
RUN service mysql start && \
    mysql -u root -pCanada -e "CREATE DATABASE mibase1;" && \
    mysql -u root -pCanada -e "GRANT ALL PRIVILEGES ON mibase1.* TO 'root'@'localhost';" && \
    mysql -u root -pCanada -e "FLUSH PRIVILEGES;"

# Comando por defecto: iniciar Nginx y la aplicación Spring Boot
CMD service nginx start && java -jar target/tu-aplicacion-spring-boot.jar
