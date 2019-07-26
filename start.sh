#!/usr/bin/env bash

sh build.sh
docker-compose build
docker-compose up

echo "============ The program is running, please wait. "
sleep 45;