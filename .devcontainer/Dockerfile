FROM ubuntu:20.04

# Instalar Nginx, Maven, Docker, Node.js y MySQL
RUN apt-get update && apt-get install -y \
    nginx \
    maven \
    docker.io \
    curl \
    gnupg2 \
    lsb-release && \
    # Instalar Node.js y npm
    curl -sL https://deb.nodesource.com/setup_16.x | bash - && \
    apt-get install -y nodejs && \
    # Configurar el repositorio de MySQL
    wget -qO - https://dev.mysql.com/get/mysql-apt-config_0.8.22-1_all.deb | dpkg -i - && \
    # Configurar la zona horaria automáticamente
    echo "mysql-community-server mysql-community-server/data-dir select '2' | debconf-set-selections && \
    echo "mysql-community-server mysql-community-server/zone select UTC | debconf-set-selections && \
    # Instalar MySQL
    apt-get update && apt-get install -y mysql-server && \
    # Limpiar caché de apt
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Iniciar el servicio MySQL y crear la base de datos
RUN service mysql start && \
    mysql -e "CREATE DATABASE mibase1;" && \
    mysql -e "CREATE USER 'root'@'localhost' IDENTIFIED BY 'Canada';" && \
    mysql -e "GRANT ALL PRIVILEGES ON mibase1.* TO 'root'@'localhost';" && \
    mysql -e "FLUSH PRIVILEGES;"

# Exponer los puertos
EXPOSE 80 3306

# Comando por defecto
CMD ["nginx", "-g", "daemon off;"]
