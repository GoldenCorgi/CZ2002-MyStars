@echo off
:Begin

ECHO [1/2] GENERATING DOCUMENTATION USING JAVADOC

cd docs
javadoc -classpath ../src/main/java mystars

ECHO [2/2] RUNNING TEST CASES

cd ../text-ui-test
call runtest.bat

pause
