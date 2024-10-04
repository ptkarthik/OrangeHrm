@echo off
echo Starting the build process...

:: Set classpath to include TestNG and other dependencies
set CLASSPATH=bin;path\to\testng.jar;path\to\other\dependencies\*.jar

:: Creating the output directory if it doesn't exist
if not exist bin (
    mkdir bin
)

:: Compiling the Java program
javac -d bin -cp %CLASSPATH% main\IndustryStandard\MyFirstTest.java main\driver\DriverCreator.java main\listeners\BasicListeners.java
if %errorlevel% neq 0 (
    echo Build failed!
    exit /b 1
) else (
    echo Build successful!
)

:: Running the compiled Java program
echo Running the program...
cd bin
java -cp "%CLASSPATH%;" IndustryStandard.MyFirstTest

echo Build process completed!
