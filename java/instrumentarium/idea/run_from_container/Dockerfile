FROM openjdk:8
COPY ./build/classes/java/main /tmp
WORKDIR /tmp
ENTRYPOINT ["java","io.mart.Main"]

# keep an eye on package of the class + what to copy to container
# to correlate package and filesystem path