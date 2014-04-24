package clashsoft.mods.moreinvspace;

import clashsoft.cslib.math.Point2i;
import clashsoft.playerinventoryapi.api.IInventoryHandler;
import clashsoft.playerinventoryapi.api.ISlotList;
import clashsoft.playerinventoryapi.client.gui.GuiCreativeInventory;
import clashsoft.playerinventoryapi.client.gui.GuiSurvivalInventory;
import clashsoft.playerinventoryapi.inventory.InventorySlots;
import clashsoft.playerinventoryapi.lib.ExtendedInventory;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class MISSlotHandler implements IInventoryHandler
{
	@Override
	public void pre(EntityPlayer player, boolean creative)
	{	
		if (creative)
		{
			GuiCreativeInventory.windowHeight = 154;
			GuiCreativeInventory.binSlotY = 130;
			for (int i = 0; i < 9; i++)
			{
				Point2i p = InventorySlots.creativeSlots[i + 36];
				p.y = 130;
			}
		}
		else
		{
			GuiSurvivalInventory.windowHeight = 184;
			for (int i = 0; i < 9; i++)
			{
				Point2i p = InventorySlots.survivalSlots[i + 36];
				p.y = 160;
			}
		}
	}
	
	@Override
	public void addSlots(ISlotList container, EntityPlayer player, boolean creative)
	{
		ExtendedInventory ei = ExtendedInventory.get(player);
		int x = creative ? 9 : 8;
		int y = creative ? 108 : 138;
		for (int i = 0; i < 9; i++)
		{
			container.addSlot(new Slot(ei, i, x + (i * 18), y));
		}
	}
	
	@Override
	public void buttonPressed(GuiButton button, EntityPlayer player, boolean creative)
	{
	}
}
