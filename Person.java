package main;
/**
 * <Person object class>
 * 
 * @author Markos Alemu
 * markos@brandeis.edu
 *1/22/20
 *COSI 21A PA0
 */
public class Person {
	
	String firstName;
	String lastName;
	Building building;//building that the person enters
	int request=0;//request floor
	int floor;//current floor
	
	/**
	 * Person constructor
	 * @param firstName 
	 * @param lastName 
	 */
	public Person(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
	}
	/**
	 * Enters person into building
	 * @param building building person is enterting
	 * @param floor
	 * @return
	 */
	public boolean enterBuilding(Building building, int floor) {
		this.floor=0;//set person's floor
		building.enterFloor(this, 0);//enters them into floors building
		this.building=building;//sets person's building building
		if (floor>this.building.getMaxFloor()) {//checks if there request is not possible
			this.setLocation(0);//sends them to lobby
			return false;//returns false, person cannot enter elevator
		}
		else {//else
			this.request=floor;//sets their request floor to appropriate floor
			this.setLocation(-1);//sets location to being serviced
			this.building.enterElevatorRequest(this, floor);//creates job for elevator
			return true;//return true, person can enter elevator
		}
	}
	/**
	 * Sets location of person
	 * @param floor
	 */
	public void setLocation(int floor) {
		this.floor=floor;
	}
	/**
	 * getLocation of person
	 * @return String of location
	 */
	public String getLocation() {
		if (this.floor==0) {
			return "In Lobby";//if floor is set to 0, person is in lobby
		}else if (this.floor > 0) {
			return "In floor " + this.floor;//greater than 0, returns floor person is on
		}else {
			return "Waiting to be serviced";//if negative, person is waiting to get serviced
		}
	}	
	/**
	 * Floor person is on
	 * @return int of floor
	 */
	public int getFloor() {
		return floor;//
	}
	/**
	 * toString
	 */
	public String toString() {
		return this.firstName + " " + this.lastName + " is on floor " + this.floor + ".\n";
	}
}
