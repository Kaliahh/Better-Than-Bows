package kaliah.betterthanbows;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.RenderGlobal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class BetterThanBows implements ModInitializer {
    public static final String MOD_ID = "betterthanbows";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("BetterThanBows initialized :)");
    }
}
