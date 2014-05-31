package clashsoft.mods.moreinvspace;

import clashsoft.cslib.math.Point2i;
import clashsoft.playerinventoryapi.CreativeInventory;
import clashsoft.playerinventoryapi.SurvivalInventory;
import clashsoft.playerinventoryapi.api.IInventoryHandler;
import clashsoft.playerinventoryapi.api.ISlotList;
import clashsoft.playerinventoryapi.lib.ExtendedInventory;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class MISSlotHandler implements IInventoryHandler
{
	@Override
	public void pre(Point2i[] slots, EntityPlayer player, boolean creative)
	{	
		if (creative)
		{
			CreativeInventory.windowHeight = 154;
			CreativeInventory.binSlotY = 130;
			for (int i = 0; i < 9; i++)
			{
				Point2i p = slots[i + 36];
				p.y = 130;
			}
		}
		else
		{
			SurvivalInventory.windowHeight = 184;
			for (int i = 0; i < 9; i++)
			{
				Point2i p = slots[i + 36];
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
