@echo off
echo Starting the build process...

:: Compiling the Java program
javac -d bin src\test\java\IndustryStandard\MyFirstTest.java
if %errorlevel% neq 0 (
    echo Build failed!
    exit /b 1
) else (
    echo Build successful!
)

:: Running the compiled Java program
echo Running the program...
cd bin
java -cp "bin;path\to\testng.jar" IndustryStandard.MyFirstTest

echo Build process completed!
