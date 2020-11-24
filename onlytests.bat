@echo off
:Begin

cd docs

ECHO [1/1] RUNNING TEST CASES

cd ../text-ui-test
call runtest.bat

pause
