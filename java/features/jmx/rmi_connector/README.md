https://mogwailabs.de/blog/2019/04/attacking-rmi-based-jmx-services/  

By default, Java provides a remote JMX connector that is based on Java RMI (Remote Method Invocation). You can enable JMX by adding the following arguments to the java call.  

-Dcom.sun.management.jmxremote.port=2222   
-Dcom.sun.management.jmxremote.authenticate=false  
-Dcom.sun.management.jmxremote.ssl=false  

JConsole: connect to localhost:2222 

`nmap localhost -p 2222 -sVC`
