#!/bin/bash
cd ..
mvn clean install
cd docker
cp ../target/boot.war .
docker build -t wildfly-springboot-app .
docker run -p 9990:8080 wildfly-springboot-app
#read -rsp $'Press enter to continue...\n'
