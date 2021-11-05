# Stores the class files into the bin directory
CLASS_PATH=src/bin

# Packages
PKG_MAIN=src/main/

all: pkgmain
	@echo "Build done !"

pkgmain: $(PKG_MAIN)*.java
	@echo "Building main package ..."
	javac -cp $(CLASS_PATH) -d $(CLASS_PATH) $(PKG_MAIN)*.java
