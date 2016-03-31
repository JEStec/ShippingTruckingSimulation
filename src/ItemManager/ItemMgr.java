// @author Jessika Stec

package ItemManager;

import Facilities.Item;

public interface ItemMgr {
	/**
	 * @param item
	 */
	public void addItem(Item item);
	/**
	 * @return
	 */
	public int getSize();
	/**
	 * @param index
	 * @return
	 */
	public Item getItem(int index);
	/**
	 * @return
	 */
	public String toString();
}
