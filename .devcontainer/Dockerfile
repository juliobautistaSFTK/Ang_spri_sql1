FROM nginx:latest

# Instalar Maven, Docker, Node.js y MySQL
RUN apt-get update && apt-get install -y \
    maven \
    docker.io \
    curl \
    mysql-server && \
    # Instalar Node.js y npm
    curl -sL https://deb.nodesource.com/setup_16.x | bash - && \
    apt-get install -y nodejs && \
    # Limpiar caché de apt
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Iniciar el servicio MySQL y crear la base de datos
RUN service mysql start && \
    mysql -e "CREATE DATABASE mibase1;" && \
    mysql -e "CREATE USER 'root'@'localhost' IDENTIFIED BY 'Canada';" && \
    mysql -e "GRANT ALL PRIVILEGES ON mibase1.* TO 'root'@'localhost';" && \
    mysql -e "FLUSH PRIVILEGES;"

# Exponer el puerto 80 y el puerto de MySQL
EXPOSE 80 3306
