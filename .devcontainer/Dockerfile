FROM ubuntu:20.04

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
    echo "tzdata tzdata/Areas select America" | debconf-set-selections && \
    echo "tzdata tzdata/Zones/America select Toronto" | debconf-set-selections && \
    # Instalar MySQL
    apt-get install -y mysql-server && \
    # Limpiar caché de apt
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Iniciar el servicio MySQL y crear la base de datos
RUN service mysql start && \
    mysql -u root -pCanada -e "CREATE DATABASE mibase1;" && \
    mysql -u root -pCanada -e "GRANT ALL PRIVILEGES ON mibase1.* TO 'root'@'localhost';" && \
    mysql -u root -pCanada -e "FLUSH PRIVILEGES;"

# Exponer los puertos
EXPOSE 80 3306

# Comando por defecto
CMD ["nginx", "-g", "daemon off;"]
