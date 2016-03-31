// @author Jessika Stec

package FacilityManager;

import Facilities.Facility;

public interface FacilityMgr {
	/**
	 * @param fac
	 */
	public void addFacility(Facility fac);
	/**
	 * @return
	 */
	public int getSize();
	/**
	 * @param index
	 * @return
	 */
	public Facility getFacility(int index);
	/**
	 * @return
	 */
	public String toString();

}
