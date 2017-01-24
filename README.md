# Minimalist

**Minimalist** is a repository with a personal collection of minimal, straightforward and easy to use samples in different technologies.

To make it the deployment faster and easier to use, the samples are used with [docker](https://www.docker.com/what-docker) .

# REST app with database

This application is a simple REST service with an underlying database (in this case it's MySQL, but you can use whatever you want, by having the proper SQL driver and updating the `datasource.properties` file).

# Dependencies
- a working Java environment (JDK 8)
- Maven for dependency and build management
- GIT
- For the dockerized version of the app: docker and/or docker-compose
- **If docker is not used**, an application server like Tomcat and an SQL server like MySQL

# How to run the application
The current application is using a Tomcat and a MySQL server. Before starting up the application, make sure you run a `mvn clean install`. You can startup in one of the following ways:

0. **Via docker-compose**
    - Make sure [docker-compose](https://docs.docker.com/compose/install/) is installed
    - open a terminal
    - `cd` to the project location
    - run the command `docker-compose up` or `docker-compose up -d` for detached mode (you can use `docker logs container_name` to check the logs)

0. **Via docker**
    - Make sure [docker](https://docs.docker.com/engine/installation/) is installed
    - open a terminal
    - `cd` to the project location
    - Build the docker image with: `docker build . -t minimalist/restspring_web`
    - Run the MySQL container with: `docker run --detach --name=mysql_db -p 3306:3306 -e "MY_SQL_DATABASE=movies_db" -e "MYSQL_ROOT_PASSWORD=root" -v $(pwd)/src/main/resources/config/mysql/conf:/etc/mysql/conf.d:ro -v $(pwd)/src/main/resources/config/mysql/init:/docker-entrypoint-initdb.d:ro mysql:8`
    - You can make sure everything is ok by checking the MySQL logs with: `docker logs mysql_db`
    - Runt the application container with: `docker run --detach --name=minimalistrestspring_web -p 8080:8080 -e "APP_ENV=container" -v ~/jde/docker/tomcat/logs:/usr/local/tomcat/logs --link mysql_db minimalist/restspring_web`
    - You can make sure everything is ok by checking the Application logs with `docker logs -f minimalistrestspring_web`

0. **Manually**
    - Setup a MySQL server on your development environment
    - Setup a Tomcat server on your development environment
    - Make sure you run the db-init script against the SQL server
    - Deploy the generated .WAR file to the tomcat container

    The last two steps can be achieve via maven plugins too.


# Voila
Open a browser and checkout the result on the following URL: http://localhost:8080/rest-spring-jdbc/rest/movies/ for the full list of movies or http://localhost:8080/rest-spring-jdbc/rest/movies/{id} for a given movie with the id
