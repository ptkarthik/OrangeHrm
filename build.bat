@echo off
echo Starting the build process...

:: Set classpath to include TestNG and other dependencies
set CLASSPATH=bin;path\to\testng.jar;path\to\other\dependencies\*.jar

:: Creating the output directory if it doesn't exist
if not exist bin (
    mkdir bin
)

:: Compiling the Java programs
echo Compiling main classes...
javac -d bin -cp %CLASSPATH% main\driver\DriverCreator.java main\listeners\BasicListeners.java
if %errorlevel% neq 0 (
    echo Build failed for main classes!
    exit /b 1
)

echo Compiling test classes...
javac -d bin -cp "%CLASSPATH%;bin" test\java\IndustryStandard\MyFirstTest.java
if %errorlevel% neq 0 (
    echo Build failed for test classes!
    exit /b 1
) else (
    echo Build successful!
)

:: Running the compiled Java test program
echo Running the test program...
cd bin
java -cp "%CLASSPATH%;" IndustryStandard.MyFirstTest

echo Build process completed!
