// @author Jessika Stec

package OrderManager;

import java.util.ArrayList;
import Orders.Order;

public class OrderMgrImpl implements OrderMgr {
	
	private ArrayList<Order> orderList;
	
	/**
	 * 
	 */
	public OrderMgrImpl() { 
		orderList = new ArrayList<Order>();
	}

	/* (non-Javadoc)
	 * @see OrderManager.OrderMgr#addOrder(Orders.Order)
	 */
	@Override
	public void addOrder(Order order) {
		orderList.add(order);
	}

	/* (non-Javadoc)
	 * @see OrderManager.OrderMgr#getSize()
	 */
	@Override
	public int getSize() {
		return orderList.size();
	}

	/* (non-Javadoc)
	 * @see OrderManager.OrderMgr#getOrder(int)
	 */
	@Override
	public Order getOrder(int index) {
		return orderList.get(index);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() { 
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < orderList.size(); i++) { 
			s.append("Order #" + (i + 1));
			s.append(": " + orderList.get(i));
			s.append("\n\n");
		}
		return s.toString();
	}

}
