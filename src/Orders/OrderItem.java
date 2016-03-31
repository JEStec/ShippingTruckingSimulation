// @author Jessika Stec

package Orders;

import FacilityManager.FacilityMgr;
import ItemManager.ItemMgr;

public interface OrderItem {
	/**
	 * @return
	 */
	public String getItemId();
	/**
	 * @return
	 */
	public int getItemQuantity();
	/**
	 * @return
	 */
	public int getItemCost();
	/**
	 * @return
	 */
	public int getFirstDay();
	/**
	 * @return
	 */
	public int getLastDay();
	/**
	 * @return
	 */
	public int getNumFac();
	/**
	 * @param itemMgr
	 */
	public void calculateInitialCost(ItemMgr itemMgr); 
	/**
	 * @param facMgr
	 */
	public void findItemsInFacilities(FacilityMgr facMgr);
	/**
	 * @param facMgr
	 */
	public void orderFacilitiesWithItem(FacilityMgr facMgr);
}
