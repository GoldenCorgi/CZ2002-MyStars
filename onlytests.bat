@echo off
:Begin

cd docs

ECHO [2/2] RUNNING TEST CASES

cd ../text-ui-test
call runtest.bat

pause
