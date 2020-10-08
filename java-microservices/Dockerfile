# Alpine Linux with OpenJDK JRE
FROM java:8
EXPOSE 8761
# copy WAR into image
ADD /target/vino-0.0.1-SNAPSHOT.war vino.war 
# run application with this command line 
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/vino.war"]