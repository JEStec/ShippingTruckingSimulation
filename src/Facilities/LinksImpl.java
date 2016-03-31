// @author Jessika Stec

package Facilities;

import java.util.HashMap;
import java.util.Map.Entry;

final class LinksImpl implements Links{
	
	private HashMap<String, Double> links;
	
	/**
	 * 
	 */
	public LinksImpl () { //constructor
		links = new HashMap<String, Double>();
	}

	/* (non-Javadoc)
	 * @see Facilities.Links#getSize()
	 */
	@Override
	public int getSize() {
		return links.size();
	}

	/* (non-Javadoc)
	 * @see Facilities.Links#add(java.lang.String, int)
	 */
	@Override
	public void add(String fName, int fDist) {
		//System.out.println("This is working!");
		double distInDays = fDist / (8.0 * 50.0);
		links.put(fName, distInDays);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Link Set:\n");
				
		for (Entry<String, Double> i : links.entrySet()) { 
			String linkName = i.getKey(); 
			double linkDist = i.getValue();
			
			s.append("Name: " + linkName);
			s.append(" : Distance: " + linkDist + " days");
			s.append("\n");
		}
		
		return s.toString();
	}
}
