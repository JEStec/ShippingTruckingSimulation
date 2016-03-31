// @author Jessika Stec

package Facilities;

import java.util.ArrayList;
import ItemManager.ItemMgr;

public interface Facility {
	/** Returns facility name.
	 * @return		return String of facility name.
	 */
	public String getFacName();
	
	/** Returns node value of facility in network.
	 * @return		return int of node value.
	 */
	public int getNodeVal();
	
	/** Returns cost to use facility shipping per day.
	 * @return		return int of facility cost.
	 */
	public int getCost();
	
	/**	Returns rate of facility per day (items facility can process per day).
	 * @return		return int of facility rate.
	 */
	public int getRate();
	
	/**	Returns network links of facility (which facilities a particular facility has a direct link to).
	 * @return		return LinksImpl of facility links.
	 */
	public LinksImpl getLinks();
	
	/** Returns schedule of facility.
	 * @return		return ScheduleImpl of facility.
	 */
	public ScheduleImpl getSchedule();
	
	/**	Returns inventory of facility.
	 * @return		return InventoryImpl of facility.
	 */
	public InventoryImpl getInventory();
	
	/**	Adds a link for a particular facility.
	 * @param name		String name of link.
	 * @param dist		int distance of link.
	 */
	public void addToLinks(String name, int dist);
	
	/** Adds an inventory item for a facility.
	 * @param item		Item to be added.
	 * @param quantity 	int quantity of item to be added.
	 */
	public void addToInventory(Item item, int quantity);
	
	/**	Adds a day to the facility's schedule.
	 * @param day		int day to add.
	 * @param rate		int rate of orders that can be processed on that day.
	 */
	public void addOneDayToSchedule(int day, int rate);
	
	/**	Adds multiple days to schedule.
	 * @param days		int number of days to add.
	 */
	public void addManyDaysToSchedule(int days);
	
	/** Set up which items have quantity of zero at a facility.
	 * @param itemMgr	
	 */
	public void setUpDepletedItems(ItemMgr itemMgr);
	
	/** Checks if particular facility has particular item.
	 * @param item	String of item name/ID.
	 * @return		return true/false if item at facility.
	 */
	public boolean itemInInventory(String item);
	
	/** Returns quantity of item that a facility contains.
	 * @param item		String of item name/ID.
	 * @return			return int value of quantity of item.
	 */
	public int getItemQuantity(String item);
	
	/**	Reduces the quantity of an item in a facility.
	 * @param item		String of item name/ID.
	 * @param reduceBy	int of how much to reduce the quantity by.
	 */
	public void reduceItemQuantity(String item, int reduceBy);
	
	/** Returns facility as string.
	 * @return String of facility description.
	 */
	public String toString();
}
