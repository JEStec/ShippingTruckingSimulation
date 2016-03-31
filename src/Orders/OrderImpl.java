// @author Jessika Stec

package Orders;

import java.util.ArrayList;
import Facilities.Item;

public class OrderImpl implements Order {
	
	private String id;
	private int startTime;
	private String destination;
	private String priority;
	private ArrayList<OrderItem> orderItems;
	private int totalCost;
	private int firstDeliveryDay;
	private int lastDeliveryDay;
	
	/**
	 * @param orderId
	 * @param orderTime
	 * @param orderDest
	 * @param orderPriority
	 */
	public OrderImpl (String orderId, int orderTime, String orderDest, String orderPriority) { //constructor
		totalCost = 0;
		id = orderId;
		startTime = orderTime;
		destination = orderDest;
		priority = orderPriority;
		orderItems = new ArrayList<OrderItem>();
	}

	/* (non-Javadoc)
	 * @see Orders.Order#addOrderItem(Orders.OrderItem)
	 */
	@Override
	public void addOrderItem(OrderItem item) {
		orderItems.add(item);
	}	
	
	/* (non-Javadoc)
	 * @see Orders.Order#getOrderItemList()
	 */
	@Override
	public ArrayList<OrderItem> getOrderItemList() {
		return orderItems;
	}	
	
	/* (non-Javadoc)
	 * @see Orders.Order#getOrderId()
	 */
	@Override
	public String getOrderId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see Orders.Order#setTotalCost()
	 */
	@Override
	public void setTotalCost() { 
		int tempCost = 0;				
		for (int i = 0; i < orderItems.size(); i++) { 
			tempCost += orderItems.get(i).getItemCost();
			tempCost += (orderItems.get(i).getNumFac() * 300);
		}	
		totalCost = tempCost;
	}
	
	/* (non-Javadoc)
	 * @see Orders.Order#setFirstLastDeliveryDays()
	 */
	@Override
	public void setFirstLastDeliveryDays() {
		int lowestFirst = Integer.MAX_VALUE;
		int highestLast = 0; 
		for (int i = 0; i < orderItems.size(); i++) { 
			if (orderItems.get(i).getFirstDay() < lowestFirst) { lowestFirst = orderItems.get(i).getFirstDay(); }
			if (orderItems.get(i).getLastDay() > highestLast) { highestLast = orderItems.get(i).getLastDay(); }
		}
		
		firstDeliveryDay = lowestFirst;
		lastDeliveryDay = highestLast;
	}
	
	/* (non-Javadoc)
	 * @see Orders.Order#getProcessedOrder()
	 */
	@Override
	public String getProcessedOrder() {
		StringBuilder s = new StringBuilder();
		s.append("Order::\n" + "Order ID: " + id + "\nDestination: " + destination 
				 + "\nPriority: " + priority + "\nTotal Cost: " + totalCost
				 + "\nFirst Delivery Day: " + firstDeliveryDay + "\nLast Delivery Day: " + lastDeliveryDay);
		
		for (int i = 0; i < orderItems.size(); i++) { 
			String itemId = orderItems.get(i).getItemId();
			int itemQuantity = orderItems.get(i).getItemQuantity();
			int first = orderItems.get(i).getFirstDay();
			int last = orderItems.get(i).getLastDay();
			int cost = orderItems.get(i).getItemCost();
			int sources = orderItems.get(i).getNumFac();
			
			s.append("\nItem ID: " + itemId);
			s.append(" : Quantity: " + itemQuantity);
			s.append(" : Cost: " + cost);
			s.append(" : Sources: " + sources);
			s.append(" : First Day: " + first);
			s.append(" : Last Day: " + last);
		}		
		return s.toString();
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() { 
		StringBuilder s = new StringBuilder();
		s.append("Order::\n" + "Order ID: " + id + "\nStart Day: " + startTime + "\nDestination: " + destination + "\nPriority: " + priority);
		
		for (int i = 0; i < orderItems.size(); i++) { 
			String itemId = orderItems.get(i).getItemId();
			int itemQuantity = orderItems.get(i).getItemQuantity();
			
			s.append("\nItem ID: " + itemId);
			s.append(" : Quantity: " + itemQuantity);
		}		
		return s.toString();
	}
}
