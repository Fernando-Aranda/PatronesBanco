#!/bin/bash

# Start WildFly in the background
/opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 &

# Wait for WildFly to fully start
echo "Waiting for WildFly to start..."
until `curl --silent --fail http://localhost:9990`; do
    sleep 5
done
echo "WildFly started."

# Register the driver explicitly
/opt/jboss/wildfly/bin/jboss-cli.sh --connect --command="/subsystem=datasources/jdbc-driver=postgresql:add(driver-name=postgresql, driver-module-name=org.postgresql, driver-class-name=org.postgresql.Driver)"

# Configure PostgreSQL datasource
/opt/jboss/wildfly/bin/jboss-cli.sh --connect --command="data-source add \
    --name=PostgresDS \
    --driver-name=postgresql \
    --jndi-name=java:/PostgresDS \
    --connection-url=jdbc:postgresql://172.18.0.2:5432/banco \
    --user-name=sa \
    --password=sa \
    --driver-class=org.postgresql.Driver"

# Keep WildFly running
tail -f /dev/null