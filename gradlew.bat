
@echo off
REM Minimal placeholder; on local machines Gradle wrapper will be bootstrapped if present.
IF EXIST gradlew.bat (
  gradlew %*
) ELSE (
  echo Please install Gradle or run via GitHub Actions.
)
