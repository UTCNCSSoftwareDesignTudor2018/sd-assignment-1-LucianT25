@echo off
SET JAR_NAME=UTCNStudentPlatform.jar
SET MAIN_CLASS=com.utcn.app.App

echo JAVA_HOME: %JAVA_HOME%
echo JAR_NAME: %JAR_NAME%
echo MAIN_CLASS: %MAIN_CLASS%

java -jar out/artifacts/UTCN_Student_Platform_jar/%JAR_NAME% 
pause