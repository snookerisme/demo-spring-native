#!/usr/bin/env bash

TAG="dev"
APP_NAME="demo-spring-native"
REGISTRY_PATH="phatcahcrin/$APP_NAME:$TAG"

./gradlew --build-file "build.gradle.kts" clean build -x test

docker rmi "$(docker images | grep $APP_NAME)"

docker build . -t $REGISTRY_PATH

docker build . -t "phatcahcrin/demo-hello-world:dev"

docker build . -t "ktbirp81.ktb:5000/paotang/demo-hello-world:perf"

docker push $REGISTRY_PATH

echo "> Copy successful..."