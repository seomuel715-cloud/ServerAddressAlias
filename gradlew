
#!/usr/bin/env sh
set -e
# Minimal pass-through; GitHub Actions step 'setup-gradle' handles Gradle
./gradlew "$@"
