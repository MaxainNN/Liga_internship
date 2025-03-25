@echo off
cls
echo =========================================
echo Run autotests...
echo =========================================
echo.

:: Run tests using Maven and capture the exit code
call mvn clean test
set TEST_EXIT_CODE=%ERRORLEVEL%

echo.
echo =========================================
echo Test execution completed!
echo =========================================

:: Check tests results
IF %TEST_EXIT_CODE% NEQ 0 (
    echo Error in tests!
    echo Check logs and report.
) ELSE (
    echo Tests successfully completed!
)

echo -----------------------------------------
echo Reports in folder:
echo - target\TestsReport.html
echo - target\surefire-reports\index.html
echo -----------------------------------------

:: Wait for files
timeout /t 2 >nul

:: Open report and exit
IF EXIST target\TestsReport.html (
    start "" "target\TestsReport.html"
    exit /b 0
) ELSE IF EXIST target\surefire-reports\index.html (
    start "" "target\surefire-reports\index.html"
    exit /b 0
) ELSE (
    echo No report files found!
    exit /b 1
)