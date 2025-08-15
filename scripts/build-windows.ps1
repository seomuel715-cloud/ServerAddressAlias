
# Requires: Java 17 installed and available in PATH.
# Run in PowerShell from project root:
#   scripts\build-windows.ps1
Write-Host "Building with Gradle wrapper (will download Gradle on first run)"
./gradlew.bat build
Write-Host "Done. Check build\libs for the JAR."
