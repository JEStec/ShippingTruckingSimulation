// @author Jessika Stec

package Distances;

public class NetworkData {
	
	private NetworkData() { }
	
	/**	Sets up network of facilities.
	 * @param arraySize		int arraySize (2D array of facility number by facility number).
	 * @return	return Network of facilites.	
	 */
	static public final Network newNetwork(int arraySize) { 
		return new NetworkImpl(arraySize);
	}
}
