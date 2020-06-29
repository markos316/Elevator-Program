package main;
/**
 * <Job object class>
 * Known bugs: none
 * 
 * @author Markos Alemu
 * markos@brandeis.edu
 *1/22/20
 *COSI 21A PA0
 */
public class Job {
	
	public Person person;//person
	public int floorNumber;//floor number they're going to
	/**
	 * Job constructor
	 * @param person
	 * @param floorNumber
	 */
	public Job(Person person, int floorNumber) {
		this.person = person;
		this.floorNumber=floorNumber;
	}
	//empty constructor
	public Job() {
		
	}
	/**
	 * 
	 * @return floor of job
	 */
	public int getFloorNumber() {
		return floorNumber;
	}
	/**
	 * sets floor  number
	 * @param floorNumber
	 */
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	/**
	 * toString method
	 */
	public String toString() {
		return this.person.toString() + " is requesting to go to " + this.floorNumber + "\n"; 
	}
	
}