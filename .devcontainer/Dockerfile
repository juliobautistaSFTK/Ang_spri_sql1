FROM nginx:latest

# Instalar Maven y Docker
RUN apt-get update && apt-get install -y maven docker.io nodejs npm && ln -s /usr/bin/nodejs /usr/bin/node

RUN npm install -g @angular/cli

# Exponer el puerto 80
EXPOSE 80
