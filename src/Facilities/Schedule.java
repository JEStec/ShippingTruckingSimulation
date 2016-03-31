// @author Jessika Stec

package Facilities;

public interface Schedule {
	/**
	 * @return
	 */
	public int getSize();
	/**
	 * @param day
	 * @param rate
	 */
	public void add(int day, int rate);
	/**
	 * @param days
	 * @param rate
	 */
	public void addManyDays(int days, int rate);
	/**
	 * @param day
	 * @param val
	 */
	public void reduceRate(int day, int val);
	/**
	 * @return
	 */
	public String toString();	
}
