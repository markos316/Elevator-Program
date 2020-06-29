package main;
/**
 * <Building object class>
 * Known Bugs: none
 * 
 * @author Markos Alemu
 * markos@brandeis.edu
 *1/22/20
 *COSI 21A PA0
 */
public class Building {
	
	Floor [] floors;// array of floors in building
	public Elevator elv = new Elevator ();//building's elevator object

	/**
	 * Building constructor
	 * @param numFloors number of floors to build array 
	 */
	public Building(int numFloors) {
		if (numFloors<1) {//ensures building can't have less than 1 floor
			throw new IllegalArgumentException("Building can't have less than 1 floor");
		}else {
			this.floors = new Floor [numFloors+1];//creates array of 1 size greater to account for lobby
		}
		
	}
	/**
	 * Creates elevator request
	 * @param person person entering elevator
	 * @param floor floor this person is requesting to go to
	 * @return boolean to check if person can or can't enter floor
	 */
	public boolean enterElevatorRequest(Person person, int floor) {
		if (floor>this.getMaxFloor() || floor<=0) {//if request is greater than highest floor
			return false;
		}else {
			elv.createJob(person, floor);//creates job for elevator
			return true;
		}
	}
	/**
	 * Begins processing requests
	 */
	public void startElevator() {
		this.elv.processAllJobs();
		
	}
	/**
	 * Enters person into floor
	 * @param person person enterring floor
	 * @param floor floor person is entering
	 */
	public void enterFloor(Person person, int floor) {
		if (floors[floor]== null) {//checks if floor needs to be initialized
			this.floors[floor] = new Floor ();//initializes for
			this.floors[floor].enterFloor(person);//enters person into floor
		}else {
			floors[floor].enterFloor(person);//enters person into floor
		}
	}
	/**
	 * Removes person from lobby
	 * @param person
	 */
	public void exitLobby(Person person) {
		this.floors[0].index--;
	}
	/**
	 * Top floor of building
	 * @return
	 */
	public int getMaxFloor() {
		return this.floors.length-1;
	}
	/**
	 * gets total amount of ppl in building
	 * @return ppl in building
	 */
	public int getTotalPeople() {
		int numb = 0;
		for (int i = 0; i<this.getMaxFloor();i++) {
			if (this.floors[i]!=null) {//checks that floor is not null
				numb+=this.floors[i].getCount();
			}
		}
		return numb;
	}
	
	public Floor getFloor(int floor) {
		return floors[floor];
	}
	
	/**
	 * to String method
	 */
	public String toString() {
		String hello = "Building has " + this.getMaxFloor() + " floors and " + this.getTotalPeople() + " people.";
		hello += "\nLobby: " + this.floors[0]; 
		for (int i = 1; i<=this.getMaxFloor();i++) {
			if(this.floors[i]!=null) {
				hello += " Floor " + i + ": " + floors[i].toString();
			}else {
				hello += " Floor " + i + ": empty\n";
			}
		}
		return hello;
				
	}
}
