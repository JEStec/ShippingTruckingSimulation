// @author Jessika Stec

package OrderManager;

public class OrderMgrData {
	private OrderMgrData() { }
	
	/**
	 * @return
	 */
	static public final OrderMgr newOrderMgr() { 
		return new OrderMgrImpl();
	}
}
