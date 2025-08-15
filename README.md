
# Server Address Alias (Fabric, 1.21.4)

Client-side aliasing so Xaero's Minimap/World Map treat fake addresses as separate worlds,
while the client connects to the real server.

## Build
- Java 17, Fabric Loom
- `gradlew build` → `build/libs/server-address-alias-1.0.1.jar`

## Configure
On first run, creates `~/.minecraft/config/serveralias.json` with a template for `penguin.mcv.kr` channels 1–20.
Edit or extend as needed.

## Notes
- Fabric API is **not required**.
- If yarn build number differs in your environment, edit `gradle.properties` → `yarn_mappings` to a valid one.
 
