FROM tomcat:8.0.20-jre8

ENV LOCAL_RESOURCES src/main/resources
ENV LOCAL_CONF $LOCAL_RESOURCES/config

ENV CATALINA_HOME /usr/local/tomcat

RUN apt-get update && apt-get install -y nano
COPY $LOCAL_CONF/tomcat/conf/tomcat-users.xml $CATALINA_HOME/conf
COPY target/rest-spring-jdbc.war $CATALINA_HOME/webapps/rest-spring-jdbc.war

CMD ["catalina.sh", "run"]
