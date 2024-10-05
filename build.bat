@echo off
setlocal enabledelayedexpansion

:: Ensure that Maven and Java are set in the environment
set MAVEN_HOME=C:\Program Files\Apache\Maven
set JAVA_HOME=C:\Program Files\Java\jdk-21

:: Add Maven and Java to the system PATH
set PATH=%MAVEN_HOME%\bin;%JAVA_HOME%\bin;%PATH%

:: Set the paths
set PROJECT_ROOT=%~dp0

:: Change to the project root directory
cd /d %PROJECT_ROOT%

:: Run Maven build
echo Running Maven build...
mvn clean install

if errorlevel 1 (
    echo Maven build failed!
    exit /b 1
)

:: Run the TestNG tests
echo Running TestNG tests...
mvn test

if errorlevel 1 (
    echo Test execution failed!
    exit /b 1
)

echo Build and test execution completed successfully.
endlocal
