@echo off
echo Starting the build process...

:: Example build step: compiling a Java program
javac MyFirstTest.java
if %errorlevel% neq 0 (
    echo Build failed!
    exit /b 1
) else (
    echo Build successful!
)

:: Running the compiled Java program
echo Running the program...
java MyFirstTest

echo Build process completed!
