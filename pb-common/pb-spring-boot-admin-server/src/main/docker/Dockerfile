FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD app.jar app.jar
RUN sh -c 'touch /app.jar'
#ENV JAVA_OPTS="-Duser.timezone=Asia/Shanghai -Djava.security.egd=file:/dev/./urandom"
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
ENTRYPOINT [ "java", "-Duser.timezone=Asia/Shanghai", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]