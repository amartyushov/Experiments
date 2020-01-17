## How to run
```
gradle war; \
docker image build -t jersey_test . ; \
docker run -it -p 8081:8080 -p 8000:8000 jersey_test
```