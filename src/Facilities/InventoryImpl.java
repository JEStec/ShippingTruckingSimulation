// @author Jessika Stec

package Facilities;

import java.util.HashMap;
import java.util.Map.Entry;

final class InventoryImpl implements Inventory {
	
	private HashMap<Item, Integer> inventory;
	
	/**
	 * Sets up inventory HashMap for facility.
	 */
	public InventoryImpl () { //constructor
		inventory = new HashMap<Item, Integer>();
	}	

	/* (non-Javadoc)
	 * @see Facilities.Inventory#hasItem(Facilities.Item)
	 */
	@Override
	public boolean hasItem(Item item) {
		return inventory.containsKey(item);
	}
	
	/* (non-Javadoc)
	 * @see Facilities.Inventory#hasItem(java.lang.String)
	 */
	@Override
	public boolean hasItem(String item) { 
		for (Entry<Item, Integer> i : inventory.entrySet()) { 
			if (item.equals(i.getKey().getID())) { 
				return true;
			}
		}		
		return false;
	}

	/* (non-Javadoc)
	 * @see Facilities.Inventory#getItemQuantity(Facilities.Item)
	 */
	@Override
	public int getItemQuantity(Item item) {
		return inventory.get(item);
	}	
	
	/* (non-Javadoc)
	 * @see Facilities.Inventory#getItemQuantity(java.lang.String)
	 */
	@Override
	public int getItemQuantity(String item) {
		int itemQuantity = 0;
		for (Entry<Item, Integer> i : inventory.entrySet()) { 
			String itemId = i.getKey().getID(); 
			if (item.equals(itemId)) { 
				itemQuantity = i.getValue();
			}
		}
		return itemQuantity;
	}

	/* (non-Javadoc)
	 * @see Facilities.Inventory#removeItem(Facilities.Item)
	 */
	@Override
	public void removeItem(Item item) {
		inventory.remove(item);
	}

	/* (non-Javadoc)
	 * @see Facilities.Inventory#getSize()
	 */
	@Override
	public int getSize() {
		return inventory.size();
	}

	/* (non-Javadoc)
	 * @see Facilities.Inventory#add(Facilities.Item, int)
	 */
	@Override
	public void add(Item item, int quantity) {
		inventory.put(item, quantity);
	}
	
	/* (non-Javadoc)
	 * @see Facilities.Inventory#reduceQuantity(java.lang.String, int)
	 */
	@Override
	public void reduceQuantity(String item, int reduceBy) { 
		for (Entry<Item, Integer> i : inventory.entrySet()) { 
			String itemId = i.getKey().getID();
			if (item.equals(itemId)) { 
				int itemQuant = i.getValue();
				i.setValue(itemQuant - reduceBy);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() { 
		StringBuilder s = new StringBuilder();
		s.append("Inventory Set:\n");
		
		for (Entry<Item, Integer> i : inventory.entrySet()) { 
			String itemId = i.getKey().getID(); 
			int itemQuantity = i.getValue();
			
			s.append("Item ID: " + itemId);
			s.append(" : Quantity: " + itemQuantity);
			s.append("\n");
		}
		
		return s.toString();
	}


}
