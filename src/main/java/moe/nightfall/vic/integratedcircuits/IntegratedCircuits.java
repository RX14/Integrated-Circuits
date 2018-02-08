package moe.nightfall.vic.integratedcircuits;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import moe.nightfall.vic.integratedcircuits.proxy.CommonProxy;
import org.apache.logging.log4j.Logger;

@Mod(modid = "integratedcircuits")
public class IntegratedCircuits {

    public static boolean isAWLoaded = false;
    public static Logger logger;

    @Instance(Constants.MOD_ID)
    public static IntegratedCircuits instance;

    @SidedProxy(clientSide = "moe.nightfall.vic.integratedcircuits.proxy.ClientProxy", serverSide = "moe.nightfall.vic.integratedcircuits.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) throws Exception {
        logger = event.getModLog();
        logger.info("Loading Integrated Circuits " + Constants.MOD_VERSION);

        

        // Compatibility
        logger.info("Searching for compatible mods");
        logger.info("armourersWorkshop: " + (isAWLoaded = Loader.isModLoaded("armourersWorkshop")));
    }

    @EventHandler
    public void init(FMLInitializationEvent event) throws Exception {
        proxy.initialize();
    }
}
