# Before starting all apps edit /etc/hosts file to contain
127.0.0.1 peer-1-server.com  
127.0.0.1 peer-2-server.com  
127.0.0.1 peer-3-server.com  

# How to start a server
./gradlew build

java -jar -Dspring.profiles.active=peer-1 eureka-server-0.0.1-SNAPSHOT.jar  
java -jar -Dspring.profiles.active=peer-2 eureka-server-0.0.1-SNAPSHOT.jar  
java -jar -Dspring.profiles.active=peer-3 eureka-server-0.0.1-SNAPSHOT.jar

## Validation servers
http://peer-1-server.com:9001/  
http://peer-2-server.com:9002/  
http://peer-3-server.com:9003/  


