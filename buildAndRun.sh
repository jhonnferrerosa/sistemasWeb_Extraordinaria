#!/bin/sh
mvn clean package && docker build -t Javi/DemoMVC .
docker rm -f DemoMVC || true && docker run -d -p 9080:9080 -p 9443:9443 --name DemoMVC Javi/DemoMVC