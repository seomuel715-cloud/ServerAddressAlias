
package kr.mcv.alias.mixin;

import kr.mcv.alias.ServerAddressAliasMod;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerAddress.class)
public abstract class ServerAddressParseMixin {
    @Inject(method = "parseString", at = @At("HEAD"), cancellable = true)
    private static void alias$parseString(String input, CallbackInfoReturnable<ServerAddress> cir) {
        try {
            String resolved = kr.mcv.alias.ServerAddressAliasMod.CONFIG.resolve(input);
            if (!resolved.equals(input)) {
                cir.setReturnValue(ServerAddress.parseString(resolved));
                cir.cancel();
            }
        } catch (Throwable t) {
            // fail-safe
        }
    }
}
