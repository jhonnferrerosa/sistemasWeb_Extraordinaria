@echo off
call mvn clean package
call docker build -t Javi/DemoMVC .
call docker rm -f DemoMVC
call docker run -d -p 9080:9080 -p 9443:9443 --name DemoMVC Javi/DemoMVC