#!/usr/bin/env bash

dos2unix docker/java/start.sh
cd exam1/
mvn clean;
mvn package;
cd ..
cp exam1/target/JavaTest4.jar  docker/java/app.jar
