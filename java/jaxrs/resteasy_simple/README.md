## How to run
```
gradle war
docker image build -t jersey_test .
docker run -it --publish 8081:8080 jersey_test
```