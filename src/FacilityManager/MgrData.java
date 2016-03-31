// @author Jessika Stec

package FacilityManager;

public class MgrData {
	private MgrData() { }
	
	/**
	 * @return
	 */
	static public final FacilityMgr newFacilityMgr() { 
		return new FacilityMgrImpl();
	}
}
