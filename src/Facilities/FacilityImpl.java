// @author Jessika Stec

package Facilities;

import java.util.ArrayList;

import ItemManager.ItemMgr;

final class FacilityImpl implements Facility {
	
	private String facilityName; 
	private int nodeVal;
	private int cost;
	private int rate;
	private LinksImpl links;
	private ScheduleImpl schedule;
	private InventoryImpl inventory;
	private DepletedItemsImpl doesNotContain;

	/** Implements a facility object.
	 * @param fName		String facility name.
	 * @param fNode		int facility node in network of facilities.
	 * @param fRate		int facility rate (items to process per day).
	 * @param fCost		int facility cost (cost to ship from this facility).
	 */
	public FacilityImpl (String fName, int fNode, int fRate, int fCost) { //constructor
		facilityName = fName;
		nodeVal = fNode;
		cost = fCost;
		rate = fRate;
		inventory = new InventoryImpl();
		schedule = new ScheduleImpl();
		links = new LinksImpl();
		doesNotContain = new DepletedItemsImpl();
	}	
	
	/* (non-Javadoc)
	 * @see Facilities.Facility#getFacName()
	 */
	@Override
	public String getFacName() {
		return facilityName;
	}
	
	/* (non-Javadoc)
	 * @see Facilities.Facility#getNodeVal()
	 */
	@Override
	public int getNodeVal() {
		return nodeVal;
	}
	
	/* (non-Javadoc)
	 * @see Facilities.Facility#getCost()
	 */
	@Override
	public int getCost() {
		return cost;
	}

	/* (non-Javadoc)
	 * @see Facilities.Facility#getRate()
	 */
	@Override
	public int getRate() {
		return rate;
	}

	/* (non-Javadoc)
	 * @see Facilities.Facility#getLinks()
	 */
	@Override
	public LinksImpl getLinks() {
		return links;
	}

	/* (non-Javadoc)
	 * @see Facilities.Facility#getSchedule()
	 */
	@Override
	public ScheduleImpl getSchedule() {
		return schedule;
	}

	/* (non-Javadoc)
	 * @see Facilities.Facility#getInventory()
	 */
	@Override
	public InventoryImpl getInventory() {
		return inventory;
	}
	
	/* (non-Javadoc)
	 * @see Facilities.Facility#addToLinks(java.lang.String, int)
	 */
	@Override
	public void addToLinks(String name, int dist) {
		links.add(name, dist);
	}
	
	/* (non-Javadoc)
	 * @see Facilities.Facility#addToInventory(Facilities.Item, int)
	 */
	@Override
	public void addToInventory(Item item, int quantity) {
		inventory.add(item, quantity);
	}
/*	
	@Override
	public void removeFromInventory(String item) {
		inventory.removeItem(item);
	}
*/	
	/* (non-Javadoc)
	 * @see Facilities.Facility#addOneDayToSchedule(int, int)
	 */
	@Override
	public void addOneDayToSchedule(int day, int rate) { 
		schedule.add(day, rate);
	}
	
	/* (non-Javadoc)
	 * @see Facilities.Facility#addManyDaysToSchedule(int)
	 */
	@Override
	public void addManyDaysToSchedule(int days) { 
		schedule.addManyDays(days, rate);
	}
/*
	@Override
	public void addLink(Facility facility, int distance) {
		links.put(facility, distance);
	}
*/	
	/* (non-Javadoc)
	 * @see Facilities.Facility#setUpDepletedItems(ItemManager.ItemMgr)
	 */
	@Override
	public void setUpDepletedItems(ItemMgr itemMgr) {
		for (int i = 0; i < itemMgr.getSize(); i++) { 
			if (!inventory.hasItem(itemMgr.getItem(i))) { 
				doesNotContain.add(itemMgr.getItem(i));
			}
		}
	}	
	
	/* (non-Javadoc)
	 * @see Facilities.Facility#itemInInventory(java.lang.String)
	 */
	@Override
	public boolean itemInInventory(String item) {
		return inventory.hasItem(item);
	}
	
	/* (non-Javadoc)
	 * @see Facilities.Facility#getItemQuantity(java.lang.String)
	 */
	@Override
	public int getItemQuantity(String item) { 
		return inventory.getItemQuantity(item);
	}
	
	/* (non-Javadoc)
	 * @see Facilities.Facility#reduceItemQuantity(java.lang.String, int)
	 */
	@Override
	public void reduceItemQuantity(String item, int reduceBy) { 
		inventory.reduceQuantity(item, reduceBy);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Facility Name: " + facilityName + "\nLinks::\n" + links + "\nInventory::\n" + inventory + "\nDepleted Inventory::\n" + doesNotContain + "\nSchedule::\n" + schedule + "\n\n";
	}
}
