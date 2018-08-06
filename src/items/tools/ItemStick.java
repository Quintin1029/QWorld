package items.tools;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;
import resources.Resource;

/**
 * Represents the stick item. Can destroy wood.
 * @author Quintin Harter
 *
 */
public class ItemStick extends ItemTool {
	
	public ItemStick(PlayerStatManager player) {
		super(player);
	}

	private Resource [] toolTypes = {
			Resource.WOOD
	};
	
	@Override
	public Resource[] getToolTypes() {
		return toolTypes;
	}

	@Override
	public Icon getIcon() {
		return Library.ITEM_TOOL_ICONS[0];
	}

	@Override
	public String getName() {
		return "Stick";
	}

}
