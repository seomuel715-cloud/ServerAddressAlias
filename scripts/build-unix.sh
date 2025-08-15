
#!/usr/bin/env bash
set -euo pipefail
echo "Building with Gradle wrapper (will download Gradle on first run)"
./gradlew build
echo "Done. Check build/libs for the JAR."
