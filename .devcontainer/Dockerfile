FROM nginx:latest

# Instalar Maven, Docker y Node.js
RUN apt-get update && apt-get install -y \
    maven \
    docker.io \
    curl && \
    # Instalar Node.js y npm
    curl -sL https://deb.nodesource.com/setup_16.x | bash - && \
    apt-get install -y nodejs && \
    # Limpiar caché de apt
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Exponer el puerto 80
EXPOSE 80
