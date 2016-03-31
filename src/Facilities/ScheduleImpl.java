// @author Jessika Stec

package Facilities;

import java.util.HashMap;
import java.util.Map.Entry;

final class ScheduleImpl implements Schedule{
	
	private HashMap<Integer, Integer> schedule;
	
	/**
	 * 
	 */
	public ScheduleImpl () { //constructor
		schedule = new HashMap<Integer, Integer>();
	}
	
	/* (non-Javadoc)
	 * @see Facilities.Schedule#getSize()
	 */
	@Override
	public int getSize() { 
		return schedule.size();
	}

	/* (non-Javadoc)
	 * @see Facilities.Schedule#add(int, int)
	 */
	@Override
	public void add(int day, int rate) {
		schedule.put(day, rate);
	}

	/* (non-Javadoc)
	 * @see Facilities.Schedule#addManyDays(int, int)
	 */
	@Override
	public void addManyDays(int days, int rate) {
		int startKey = schedule.size();
		
		for (int i = 0; i < days; i++) { 
			schedule.put(i + startKey, rate);
		}	
	}

	/* (non-Javadoc)
	 * @see Facilities.Schedule#reduceRate(int, int)
	 */
	@Override
	public void reduceRate(int day, int val) {
		int newVal = schedule.get(day) - val; 
		schedule.put(day, newVal);
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Schedule:\n");
		
		for (Entry<Integer, Integer> i : schedule.entrySet()) { 
			int schedDay = i.getKey(); 
			int schedRate = i.getValue();
			
			s.append("Day: " + schedDay);
			s.append(" : Available: " + schedRate);
			s.append("\n");
		}
		
		return s.toString();
	}

	
	
}
