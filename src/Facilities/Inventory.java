// @author Jessika Stec

package Facilities;

public interface Inventory {
	/** Checks if inventory contains an item by Item object.
	 * @param item	Item item to check.
	 * @return		return true/false depending on if Item is present.
	 */
	public boolean hasItem(Item item);
	/** Checks if inventory contains an item by item name/ID.
	 * @param itemID	String of item name/ID.
	 * @return			returns true/false depending on if inventory contains item.
	 */
	public boolean hasItem(String itemID);
	/** Returns quantity of item in inventory.
	 * @param item		Item item to check quantity.
	 * @return			return int of item quantity.
	 */
	public int getItemQuantity(Item item);
	/** Returns quantity of item in inventory.
	 * @param item		String item name/ID.
	 * @return			return int of item quantity.	
	 */
	public int getItemQuantity(String item);
	/** Removes item from inventory.
	 * @param item		Item item.
	 */
	public void removeItem(Item item);
	/** Returns size of inventory (how many items, not quantity per item).
	 * @return		return int of inventory size.
	 */
	public int getSize();
	/** Adds an item to the inventory.
	 * @param item		Item item.
	 * @param quantity	int quantity of item in inventory.
	 */
	public void add(Item item, int quantity);
	/**	Reduces quantity of item in inventory.
	 * @param item		String item name/ID. 	
	 * @param reduceBy	int value to reduce item by.
	 */
	public void reduceQuantity(String item, int reduceBy);
	/** Formats inventory as a String.
	 * @return	String description of inventory.
	 */
	public String toString();
}
