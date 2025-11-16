# -------- Final Tomcat Image --------
FROM tomcat:10.1.10-jdk17

# Remove default ROOT application
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the built WAR file and rename it as ROOT.war
# GitHub Actions produces: target/puzzle-game-webapp-1.0.war
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
