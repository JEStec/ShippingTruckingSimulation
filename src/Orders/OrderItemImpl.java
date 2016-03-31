// @author Jessika Stec

package Orders;

import java.util.ArrayList;
import java.util.HashMap;

import Facilities.Data;
import Facilities.Facility;
import Facilities.Inventory;
import FacilityManager.FacilityMgr;
import ItemManager.ItemMgr;

public class OrderItemImpl implements OrderItem {
	
	private String itemId;
	private int itemQuantity;
	private int totalItemCost;
	private int itemSources;
	private int itemFirstDay = 0; // temp value for testing
	private int itemLastDay = 21; // temp value for testing
	private ArrayList<Facility> closestFacWithItem = new ArrayList<Facility>(); 
	
	/**
	 * @param id
	 * @param quant
	 */
	public OrderItemImpl (String id, int quant) { //constructor
		itemSources = 0;
		itemId = id;
		itemQuantity = quant;
	}

	/* (non-Javadoc)
	 * @see Orders.OrderItem#getItemId()
	 */
	@Override
	public String getItemId() {
		return itemId;
	}

	/* (non-Javadoc)
	 * @see Orders.OrderItem#getItemQuantity()
	 */
	@Override
	public int getItemQuantity() {
		return itemQuantity;
	}
	
	/* (non-Javadoc)
	 * @see Orders.OrderItem#getItemCost()
	 */
	@Override
	public int getItemCost() {
		return totalItemCost;
	}
	
	/* (non-Javadoc)
	 * @see Orders.OrderItem#getFirstDay()
	 */
	@Override
	public int getFirstDay() {
		return itemFirstDay;
	}

	/* (non-Javadoc)
	 * @see Orders.OrderItem#getLastDay()
	 */
	@Override
	public int getLastDay() {
		return itemLastDay;
	}
	
	/* (non-Javadoc)
	 * @see Orders.OrderItem#getNumFac()
	 */
	@Override
	public int getNumFac() { 
		return itemSources;
	}
	

	/* (non-Javadoc)
	 * @see Orders.OrderItem#calculateInitialCost(ItemManager.ItemMgr)
	 */
	@Override
	public void calculateInitialCost(ItemMgr itemMgr) {
		for (int i = 0; i < itemMgr.getSize(); i++) {
			if (itemId.equals(itemMgr.getItem(i).getID())) { 
				totalItemCost += (itemMgr.getItem(i).getCost() * itemQuantity);
			}
		}
	}

	/* (non-Javadoc)
	 * @see Orders.OrderItem#findItemsInFacilities(FacilityManager.FacilityMgr)
	 */
	@Override
	public void findItemsInFacilities(FacilityMgr facMgr) {
		Facility temp = null;
		int tempItemQuan = itemQuantity;
		for (int i = 0; i < facMgr.getSize(); i++) { 
			if (tempItemQuan <= 0) { break; }
			temp = facMgr.getFacility(i);
			if (temp.itemInInventory(itemId) && (temp.getItemQuantity(itemId) > 0)) {
				int facilityQuan = temp.getItemQuantity(itemId);
				if (facilityQuan >= tempItemQuan) { 
					temp.reduceItemQuantity(itemId, tempItemQuan);
					tempItemQuan = 0;			
					itemSources++;
				}
				else {
					temp.reduceItemQuantity(itemId, facilityQuan);
					tempItemQuan -= facilityQuan;
					itemSources++;
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see Orders.OrderItem#orderFacilitiesWithItem(FacilityManager.FacilityMgr)
	 */
	@Override
	public void orderFacilitiesWithItem(FacilityMgr facMgr) {
				
	}


}
