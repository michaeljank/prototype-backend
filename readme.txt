Setup:

1) unzip jboss located in the server directory and startup via JBOSS_HOME/bin/standalone.bat

admin user for management console (localhost:9990/console):
user: admin
pwd: 1qayXDR%

2) build backend project via "mvn package"

3) deploy target/PrototypeBackend-1.0-SNAPSHOT.war into JBOSS_HOME/standalone/deployments (or use management console: Runtime > Server> Manage Deployments)


Runtime:

The backend project provides local and remote EJBs and a REST API.

Sample calls for the REST API:
get: curl localhost:8080/prototype/user/list
add: curl -i "localhost:8080/prototype/user" -XPOST -d "{\"id\":1, \"name\":\"Martin\"}" -H "Content-Type:application/json"
change: curl -i "localhost:8080/prototype/user" -XPUT -d "{\"id\":1, \"name\":\"Michael\"}" -H "Content-Type:application/json"
delete: curl -i "localhost:8080/prototype/user/1" -XDELETE
