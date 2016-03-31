// @author Jessika Stec

package Start;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Control c = new Control(); 
		c.initiateFacMgr(); // set up facility manager
		c.initiateItemMgr(); // set up item manager
		c.addFacilityInventory(); // set up inventory per facility
		c.initiateNetwork(); // set up network of facilities
		c.calculateDist(); // calculate all pairs distances
		c.initiateOrders(); // set up orders
		c.processOrders(); // process orders
	}

}
