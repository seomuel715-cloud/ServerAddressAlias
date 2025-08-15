
package kr.mcv.alias;

import net.fabricmc.api.ClientModInitializer;

public class ServerAddressAliasMod implements ClientModInitializer {
    public static AliasConfig CONFIG;

    @Override
    public void onInitializeClient() {
        CONFIG = AliasConfig.load();
    }
}
