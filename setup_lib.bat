@echo off
setlocal

:: Set the target directory for the lib folder
set "LIB_DIR=lib"
mkdir "%LIB_DIR%"

:: Download JAR files using curl (make sure curl is installed)
echo Downloading TestNG...
curl -L -o "%LIB_DIR%\testng-7.8.0.jar" https://repo1.maven.org/maven2/org/testng/testng/7.8.0/testng-7.8.0.jar

echo Downloading JCommander...
curl -L -o "%LIB_DIR%\jcommander-1.82.jar" https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar

echo Downloading SLF4J API...
curl -L -o "%LIB_DIR%\slf4j-api-1.7.36.jar" https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.36/slf4j-api-1.7.36.jar

echo Downloading SLF4J Simple Binding...
curl -L -o "%LIB_DIR%\slf4j-simple-1.7.36.jar" https://repo1.maven.org/maven2/org/slf4j/slf4j-simple/1.7.36/slf4j-simple-1.7.36.jar

echo All required libraries have been downloaded into the "%LIB_DIR%" folder.

endlocal
