@echo off
echo Starting the build process...

:: Example build step: compiling a Java program
javac -d bin src\test\java\IndustryStandard\MyFirstTest.java
if %errorlevel% neq 0 (
    echo Build failed!
    exit /b 1
) else (
    echo Build successful!
)

:: Running the compiled Java program
echo Running the program...
java -d bin src\test\java\IndustryStandard\MyFirstTest.java

echo Build process completed!
