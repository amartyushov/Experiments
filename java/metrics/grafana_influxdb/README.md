## Influxdb
Create user  
`curl -XPOST 'http://localhost:8086/query' --data-urlencode "q=CREATE USER admin WITH PASSWORD 'admin' WITH ALL PRIVILEGES"`

Create database  
`curl -XPOST 'http://localhost:8086/query' --data-urlencode 'q=CREATE DATABASE "signavio_app"'`

Show all databases  
`curl -G http://localhost:8086/query\?pretty\=true --data-urlencode "db=glances" --data-urlencode "q=SHOW DATABASES"`

Show all users  
`curl -G http://localhost:8086/query\?pretty\=true --data-urlencode "db=glances" --data-urlencode "q=SHOW USERS"`

Remove database  
`curl -XPOST 'http://localhost:8086/query' --data-urlencode 'q=DROP DATABASE "signavio_app"'`


## Configuration steps
1. [INFLUXDB] Create db (my-db)
2. [INFLUXDB] Create user (admin)
3. [GRAFANA] Create datasource:  
URL: http://influxdb:8086  
Database: my-db  
User: admin  
Password: admin 
4. [GRAFANA] Create dashboard:  

