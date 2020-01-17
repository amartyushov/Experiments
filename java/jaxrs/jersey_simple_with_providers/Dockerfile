FROM tomcat:8

COPY build/libs/jersey_simple.war /usr/local/tomcat/webapps/

ENV JPDA_ADDRESS="8000"
ENV JPDA_TRANSPORT="dt_socket"

EXPOSE 8080 8000
ENTRYPOINT ["catalina.sh", "jpda", "run"]