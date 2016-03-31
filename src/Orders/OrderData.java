// @author Jessika Stec

package Orders;

public class OrderData {
	
	private OrderData() { }
	
	/**
	 * @param id
	 * @param time
	 * @param dest
	 * @param priority
	 * @return
	 */
	static public final Order newOrder(String id, int time, String dest, String priority) { 
		return new OrderImpl(id, time, dest, priority);
	}
	
	/**
	 * @param id
	 * @param quant
	 * @return
	 */
	static public final OrderItem newOrderItem(String id, int quant) { 
		return new OrderItemImpl(id, quant);
	}
}
