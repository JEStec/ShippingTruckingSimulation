// @author Jessika Stec

package ItemManager;

import java.util.ArrayList;

import Facilities.Item;

public class ItemMgrImpl implements ItemMgr{

	private ArrayList<Item> itemList; 
	
	/**
	 * 
	 */
	public ItemMgrImpl() { 
		itemList = new ArrayList<Item>();
	}
	/* (non-Javadoc)
	 * @see ItemManager.ItemMgr#addItem(Facilities.Item)
	 */
	@Override
	public void addItem(Item item) {
		itemList.add(item);
	}

	/* (non-Javadoc)
	 * @see ItemManager.ItemMgr#getSize()
	 */
	@Override
	public int getSize() {
		return itemList.size();
	}

	/* (non-Javadoc)
	 * @see ItemManager.ItemMgr#getItem(int)
	 */
	@Override
	public Item getItem(int index) {
		return itemList.get(index);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() { 
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < itemList.size(); i++) { 
			s.append("Item #" + (i + 1));
			s.append(": " + itemList.get(i));
			s.append("\n\n");
		}
		return s.toString();
	}

}
