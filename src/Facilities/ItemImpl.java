// @author Jessika Stec

package Facilities;

final class ItemImpl implements Item {
	
	private String itemId;
	private int itemCost;

	/**
	 * @param id
	 * @param cost
	 */
	public ItemImpl (String id, int cost) { //constructor
		itemId = id;
		itemCost = cost;
	}
	
	/* (non-Javadoc)
	 * @see Facilities.Item#getID()
	 */
	@Override
	public String getID() {
		return itemId;
	}

	/* (non-Javadoc)
	 * @see Facilities.Item#getCost()
	 */
	@Override
	public int getCost() {
		return itemCost;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() { 
		return "Item: \n" + "ID: " + itemId + " Cost: " + itemCost;
	}

}
