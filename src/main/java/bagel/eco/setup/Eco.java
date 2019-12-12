package bagel.eco.setup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import net.minecraftforge.common.MinecraftForge;import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("eco")
public class Eco 
{
	public static Eco instance;
	public static final String modid = "eco";
	public static final Logger logger = LogManager.getLogger(modid);

	public Eco() 
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		registerStrippable(ModBlocks.mangrove_log, ModBlocks.stripped_mangrove_log);
        registerStrippable(ModBlocks.mangrove_wood, ModBlocks.stripped_mangrove_wood);
		logger.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("ClientRegistries method registered.");
	}
	
	public static void registerStrippable(Block log, Block stripped_log) {
        AxeItem.BLOCK_STRIPPING_MAP = Maps.newHashMap(AxeItem.BLOCK_STRIPPING_MAP);
        AxeItem.BLOCK_STRIPPING_MAP.put(log, stripped_log);
    }
}