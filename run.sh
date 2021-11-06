#!/bin/bash
make all
clear
echo -e "\nRunning ...\n"
java -cp src/bin/ src/main/Main.java
