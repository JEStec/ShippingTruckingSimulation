// @author Jessika Stec

package Distances;

import FacilityManager.FacilityMgr;

public class NetworkImpl implements Network {
	private int[][] network = new int[18][18];
	private int[][] parent = new int[18][18];
	private int size;	
	
	/** Sets up network.
	 * @param arraySize 	int arraySize. 
	 */
	public NetworkImpl(int arraySize) { 
		size = arraySize;
		for (int i = 0; i < arraySize; i++) { 
			for (int j = 0; j < arraySize; j++) { 
				if (i == j) { network[i][j] = 0; }
				else { network[i][j] = Integer.MAX_VALUE / 2; }
				parent[i][j] = -1;
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see Distances.Network#updateVal(int, int, int)
	 */
	@Override
	public void updateVal(int i, int j, int dist) {
		network[i][j] = dist;
	}
	
	/* (non-Javadoc)
	 * @see Distances.Network#updateParentVals(int, int)
	 */
	@Override
	public void updateParentVals(int i, int j) { 
		parent[i][j] = i;
	}

	/* (non-Javadoc)
	 * @see Distances.Network#getArray()
	 */
	@Override
	public String getArray() {
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < size; i++) { 
			for (int j = 0; j < size; j++) { 
				if (j == 0) { s.append("\n"); }
				s.append(network[i][j] + ", ");
			}
		}
		
		return s.toString();
	}

	/* (non-Javadoc)
	 * @see Distances.Network#getParentArray()
	 */
	@Override
	public String getParentArray() {
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < size; i++) { 
			for (int j = 0; j < size; j++) { 
				if (j == 0) { s.append("\n"); }
				s.append(parent[i][j] + ", ");
			}
		}
		
		return s.toString();
	}

	/* (non-Javadoc)
	 * @see Distances.Network#calculateAllPairs()
	 */
	@Override
	public void calculateAllPairs() {
		// using Floyd-Warshall
		
		for( int k = 0; k < size; k++ ) {
			for( int i = 0; i < size; i++ ) {
				for( int j = 0; j < size; j++ ) {
					int newD = network[i][k] + network[k][j];
					if( newD < network[i][j] ) {
						network[i][j] = newD;
						parent[i][j] = parent[k][j];
					}
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see Distances.Network#getDist(FacilityManager.FacilityMgr, java.lang.String, java.lang.String)
	 */
	@Override
	public String getDist(FacilityMgr fMgr, String facility1, String facility2) {
		int node1 = 0, node2 = 0;
		int fMgrSize = fMgr.getSize();
		double dist;
		
		for (int i = 0; i < fMgrSize; i++) { 
			if (fMgr.getFacility(i).getFacName().equals(facility1)) { node1 = fMgr.getFacility(i).getNodeVal(); }
			if (fMgr.getFacility(i).getFacName().equals(facility2)) { node2 = fMgr.getFacility(i).getNodeVal(); }
		}		
		
		dist = network[node1][node2] / (8.0 * 50.0);
		return dist + " days";
	}

}
