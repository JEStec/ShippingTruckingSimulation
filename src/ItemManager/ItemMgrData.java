// @author Jessika Stec

package ItemManager;

public class ItemMgrData {
	
	private ItemMgrData() { }
	
	/**
	 * @return
	 */
	static public final ItemMgr newItemMgr() { 
		return new ItemMgrImpl();
	}
}
