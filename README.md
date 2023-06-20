# simple-kotlin-web
start with kotlin for spring web service

backend: springboot
frontend: vue.js

# database settings
### docker run
docker run -d -p 3306:3306 --name mykotlin-db -e MYSQL_ROOT_PASSWORD=prettier mysql

### docker execution
docker exec -it mykotlin-db bash

### enter mysql
mysql -uroot -p
// password = prettier

### create db
create database kotlin



