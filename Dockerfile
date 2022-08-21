FROM adoptopenjdk/openjdk11-openj9:alpine-jre

RUN apk update && apk add tzdata \
    && cp /usr/share/zoneinfo/Asia/Bangkok /etc/localtime \
    && echo "Asia/Bangkok" >  /etc/timezone \
    && apk del tzdata

VOLUME /tmp

RUN mkdir /app

ADD build/libs/demo-spring-native-0.0.1-SNAPSHOT.jar /app.jar

COPY .k8s/perf/Bangkok /etc/localtime

RUN echo Asia/Bangkok > /etc/timezone

ENTRYPOINT exec java $JAVA_OPTS $TIME_ZONE -jar /app.jar