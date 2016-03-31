// @author Jessika Stec

package Orders;

import java.util.ArrayList;

public interface Order {
	/**
	 * @param item
	 */
	public void addOrderItem(OrderItem item);
	/**
	 * @return
	 */
	public ArrayList<OrderItem> getOrderItemList();
	/**
	 * @return
	 */
	public String getOrderId();
	/**
	 * 
	 */
	public void setTotalCost();
	/**
	 * 
	 */
	public void setFirstLastDeliveryDays();
	/**
	 * @return
	 */
	public String getProcessedOrder();
	/**
	 * @return
	 */
	public String toString();
}
