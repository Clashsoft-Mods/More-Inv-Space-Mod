package clashsoft.mods.moreinvspace;

import clashsoft.cslib.minecraft.ClashsoftMod;
import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.playerinventoryapi.PlayerInventoryAPI;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = MoreInvSpaceMod.MODID, name = MoreInvSpaceMod.NAME, version = MoreInvSpaceMod.VERSION)
public class MoreInvSpaceMod extends ClashsoftMod
{
	public static final String		MODID	= "moreinvspace";
	public static final String		NAME	= "More Inventory Space Mod";
	public static final String		ACRONYM	= "mism";
	public static final String		VERSION	= CSUpdate.CURRENT_VERSION + "-1.0.0";
	
	@Instance(MODID)
	public static MoreInvSpaceMod	instance;
	
	public MoreInvSpaceMod()
	{
		super(null, MODID, NAME, ACRONYM, VERSION);
	}
	
	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
	}
	
	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		
		if (event.getSide() == Side.CLIENT)
		{
			PlayerInventoryAPI.addInventoryHandler(new MISSlotHandler());
		}
	}
	
	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
}
