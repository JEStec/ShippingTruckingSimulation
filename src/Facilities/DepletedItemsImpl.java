// @author Jessika Stec

package Facilities;

import java.util.ArrayList;

public class DepletedItemsImpl implements DepletedItems {

	private ArrayList<Item> depletedItemsList; 
	
	/**
	 * 
	 */
	public DepletedItemsImpl() { 
		depletedItemsList = new ArrayList<Item>();
	}	
	
	/* (non-Javadoc)
	 * @see Facilities.DepletedItems#add(Facilities.Item)
	 */
	@Override
	public void add(Item item) {
		depletedItemsList.add(item);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < depletedItemsList.size(); i++) { 
			s.append("Depleted Item #" + (i + 1));
			s.append(": " + depletedItemsList.get(i).getID());
			s.append("\n");
		}
		return s.toString();
	}
}
