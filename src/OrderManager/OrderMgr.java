// @author Jessika Stec

package OrderManager;

import Orders.Order;

public interface OrderMgr {
	/**
	 * @param order
	 */
	public void addOrder(Order order);
	/**
	 * @return
	 */
	public int getSize();
	/**
	 * @param index
	 * @return
	 */
	public Order getOrder(int index);
	/**
	 * @return
	 */
	public String toString();
}
