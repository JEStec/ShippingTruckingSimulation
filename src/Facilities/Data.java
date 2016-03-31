// @ author Jessika Stec

package Facilities;

public class Data {
	
	private Data() { }
	
	/**
	 * @param name
	 * @param node
	 * @param cost
	 * @param rate
	 * @return
	 */
	static public final Facility newFacility(String name, int node, int cost, int rate) { 
		return new FacilityImpl(name, node, cost, rate);
	}

	/**
	 * @param id
	 * @param cost
	 * @return
	 */
	static public final Item newItem(String id, int cost) { 
		return new ItemImpl(id, cost);
	}
	/**
	 * @return
	 */
	static public final Inventory newInventory() { 
		return new InventoryImpl();
	}
}
