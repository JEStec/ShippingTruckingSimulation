// @author Jessika Stec

package Start;

import java.util.ArrayList;

import Distances.Network;
import Distances.NetworkData;
import FacilityManager.FacilityMgr;
import FacilityManager.MgrData;
import ItemManager.ItemMgr;
import ItemManager.ItemMgrData;
import OrderManager.OrderMgr;
import OrderManager.OrderMgrData;
import Orders.Order;
import Orders.OrderItem;

public class Control {
	// variables
	FacilityMgr facilityMgr = MgrData.newFacilityMgr();
	ItemMgr itemMgr = ItemMgrData.newItemMgr();
	OrderMgr orderMgr = OrderMgrData.newOrderMgr();
	Network net = NetworkData.newNetwork(18);
	
	// sets up the facility manager by parsing XML file, initiate facility objects, adding these objects to manager
	/**
	 * 
	 */
	public void initiateFacMgr() {
		XmlReader xr = new XmlReader();
		facilityMgr = xr.parseFacility();
	}
	
	// sets up the network by parsing XML file of networks
	/**
	 * 
	 */
	public void initiateNetwork() { 
		XmlReader xr = new XmlReader();
		net = xr.parseNetwork(facilityMgr);
		System.out.println(facilityMgr);
	}
	
	// sets up the item manager by parsing XML file of all Items, creating Item objects, adding these to manager
	/**
	 * 
	 */
	public void initiateItemMgr() { 
		XmlReader xr = new XmlReader();
		itemMgr = xr.parseItem();
	}
	
	// sets up the existing inventory per facility 
	/**
	 * 
	 */
	public void addFacilityInventory() { 
		XmlReader xr = new XmlReader();
		xr.parseInventory(facilityMgr, itemMgr);
		
		for (int i = 0; i < facilityMgr.getSize(); i++) { 
			facilityMgr.getFacility(i).setUpDepletedItems(itemMgr);
		}
	}
	
	/**
	 * 
	 */
	public void initiateOrders() { 
		XmlReader xr = new XmlReader();
		orderMgr = xr.parseOrder();
		System.out.println("\n\n\n" + orderMgr);
	}
	
	// calculate all pairs in network + examples of retrieving distances between two facilities 
	/**
	 * 
	 */
	public void calculateDist() {
		//System.out.println("Currently in calcDist");
		net.calculateAllPairs();
		System.out.println("Example distance calculations:: ");
		System.out.println("Seattle,WA -> Nashville,TN: " + net.getDist(facilityMgr, "Seattle,WA", "Nashville,TN"));
		System.out.println("NewYorkCity,NY -> Phoenix,AZ: " + net.getDist(facilityMgr, "NewYorkCity,NY", "Phoenix,AZ"));
		System.out.println("Fargo,ND -> Austin,TX: " + net.getDist(facilityMgr, "Fargo,ND", "Austin,TX"));
		System.out.println("Denver,CO -> Miami,FL: " + net.getDist(facilityMgr, "Denver,CO", "Miami,FL"));
	}
	
	/**
	 * 
	 */
	public void processOrders() { 
		for (int i = 0; i < orderMgr.getSize(); i++) { 
			Order currentOrder = orderMgr.getOrder(i);
			System.out.println("Processing Order #" + currentOrder.getOrderId());
			ArrayList<OrderItem> currentOrderList = currentOrder.getOrderItemList();
			for (int j = 0; j < currentOrderList.size(); j++) { 
				currentOrderList.get(j).calculateInitialCost(itemMgr);				
				currentOrderList.get(j).findItemsInFacilities(facilityMgr);
				currentOrder.setTotalCost();
			}
			System.out.println(currentOrder.getProcessedOrder());
		}
	}

}
