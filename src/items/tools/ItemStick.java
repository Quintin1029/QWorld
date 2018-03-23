package items.tools;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;

public class ItemStick extends ItemTool {
	
	public ItemStick(PlayerStatManager player) {
		super(player);
	}

	private int [] toolTypes = {
			Library.TOOL_WOOD
	};
	
	@Override
	public int[] getToolTypes() {
		return toolTypes;
	}

	@Override
	public Icon getIcon() {
		return Library.ITEM_TOOL_ICONS[0];
	}

}
