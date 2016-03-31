// @author Jessika Stec

package FacilityManager;

import java.util.ArrayList;
import Facilities.Facility;

final class FacilityMgrImpl implements FacilityMgr {
	
	private ArrayList<Facility> facList; 
	
	/**
	 * 
	 */
	public FacilityMgrImpl() { 
		facList = new ArrayList<Facility>();
	}
	
	/* (non-Javadoc)
	 * @see FacilityManager.FacilityMgr#addFacility(Facilities.Facility)
	 */
	public void addFacility(Facility f) { 
		facList.add(f);
	}
	
	/* (non-Javadoc)
	 * @see FacilityManager.FacilityMgr#getSize()
	 */
	@Override
	public int getSize() {
		return facList.size();
	}
	
	/* (non-Javadoc)
	 * @see FacilityManager.FacilityMgr#getFacility(int)
	 */
	@Override
	public Facility getFacility(int index) {
		return facList.get(index);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < facList.size(); i++) { 
			s.append("Facility #" + (i + 1));
			s.append(": " + facList.get(i));
			s.append("\n");
		}
		return s.toString(); 
	}
	
}
