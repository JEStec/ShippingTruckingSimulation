// @author Jessika Stec

package Distances;

import FacilityManager.FacilityMgr;

public interface Network {
	/**	Updates 
	 * @param i		
	 * @param j
	 * @param dist	
	 */
	public void updateVal(int i, int j, int dist);
	/**
	 * @param i
	 * @param j
	 */
	public void updateParentVals(int i, int j);
	/**
	 * @return
	 */
	public String getArray();
	/**
	 * @return
	 */
	public String getParentArray();
	/**
	 * Calculates all distances between all facilities.
	 */
	public void calculateAllPairs();
	/**	Gets distance between two facilities.
	 * @param fMgr			FacilityMger fMgr contains all facilities.
	 * @param facility1		String facility1 name of facility.
	 * @param facility2		String facility2 name of facility.
	 * @return	String 		return String of distance between facility1 and facility2.
	 */
	public String getDist(FacilityMgr fMgr, String facility1, String facility2);
}
