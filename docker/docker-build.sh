#!/bin/bash
cp ../target/boot.war .
docker build -t wildfly-springboot-app .
read -rsp $'Press enter to continue...\n'
