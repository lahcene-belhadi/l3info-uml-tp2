#!/bin/bash
make all
echo -e "\nRunning ...\n"
java -cp src/bin/ src/main/Main.java
