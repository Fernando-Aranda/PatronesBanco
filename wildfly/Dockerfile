FROM quay.io/wildfly/wildfly
RUN /opt/jboss/wildfly/bin/add-user.sh admin 123 --silent

# Download PostgreSQL JDBC Driver
RUN cd /opt/jboss/wildfly && \
    mkdir -p /opt/jboss/wildfly/modules/org/postgresql/main && \
    curl -O https://jdbc.postgresql.org/download/postgresql-42.7.4.jar && \
    mv postgresql-42.7.4.jar /opt/jboss/wildfly/modules/org/postgresql/main/

# Create module.xml for PostgreSQL
RUN echo '<?xml version="1.0" encoding="UTF-8"?> \
<module xmlns="urn:jboss:module:1.1" name="org.postgresql"> \
    <resources> \
        <resource-root path="postgresql-42.7.4.jar"/> \
    </resources> \
    <dependencies> \
        <module name="javax.api"/> \
        <module name="javax.transaction.api"/> \
    </dependencies> \
</module>' > /opt/jboss/wildfly/modules/org/postgresql/main/module.xml

# Copy the configuration script to the image
COPY configure-wildfly.sh /opt/jboss/wildfly/bin/

# Switch to root to change permissions and copy the JDBC driver
USER root
# Make the script executable
RUN chmod +x /opt/jboss/wildfly/bin/configure-wildfly.sh
# Switch back to WildFly user
USER jboss

ADD bancoapp.war /opt/jboss/wildfly/standalone/deployments/

# Expose management and application ports
EXPOSE 8080 9990

# Run the configuration script after starting WildFly
CMD ["/opt/jboss/wildfly/bin/configure-wildfly.sh"]
