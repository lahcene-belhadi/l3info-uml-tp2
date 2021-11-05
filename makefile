# Stores the class files into the bin directory
CLASS_PATH=src/bin

# Packages
PKG_MAIN=src/main/
PKG_DIGICODE=src/digicode/
PKG_DIGICODE_INTERFACES=$(PKG_DIGICODE)/interfaces/
PKG_UTILS=src/utils/
PKG_ENUMS=src/utils/enums/

all: pkgenums pkgdigicode_interfaces pkgdigicode pkgmain
	@echo "Build done !"

pkgmain: $(PKG_MAIN)*.java
	@echo "Building main package ..."
	javac -cp $(CLASS_PATH) -d $(CLASS_PATH) $(PKG_MAIN)*.java

pkgdigicode: $(PKG_DIGICODE)*.java
	@echo "Building digicode package ..."
	javac -cp $(CLASS_PATH) -d $(CLASS_PATH) $(PKG_DIGICODE)*.java

pkgdigicode_interfaces: $(PKG_DIGICODE_INTERFACES)*.java
	@echo "Building digicode interaces package ..."
	javac -cp $(CLASS_PATH) -d $(CLASS_PATH) $(PKG_DIGICODE_INTERFACES)*.java

pkgenums: $(PKG_ENUMS)*.java
	@echo "Building enums package ..."
	javac -cp $(CLASS_PATH) -d $(CLASS_PATH) $(PKG_ENUMS)*.java
