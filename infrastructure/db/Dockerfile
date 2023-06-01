# cat Dockerfile
FROM mysql:latest

RUN chown -R mysql:root /var/lib/mysql/

ENV MYSQL_DATABASE=gamedataservice
ENV MYSQL_USER=admin
ENV MYSQL_PASSWORD=password
ENV MYSQL_ROOT_PASSWORD=root_password

EXPOSE 3307
# docker run --name gamedataservice-db -p 3307:3306 gamedataservice-db-image
