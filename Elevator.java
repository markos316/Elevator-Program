package main;
/**
 * <Elevator object class>
 * Known bugs: None
 * @author Markos Alemu
 * markos@brandeis.edu
 *1/22/20
 *COSI 21A PA0
 */
public class Elevator {

	public JobList jobL = new JobList();//Linked List of jobs
	int counter = 0;//total amount of people awaiting jobs
	int index = 0;
	int currFloor=0;

	/**
	 * This specifies the number of people that can be brought to their floors by an Elevator 
	 * instance at any given time. 
	 * <p>DO NOT REMOVE THIS FIELD</p>
	 * <p>You may edit it. But keep it public.</p>
	 */
	public static int maxOccupants = 5;

	/**
	 * Creates a job 
	 * @param person
	 * @param floor
	 */
	
	public void createJob(Person person, int floor) {
		Job job = new Job (person, floor);

		jobL.add(job);
	}
	/**
	 * Processes jobs in linked list
	 */
	public void processAllJobs() {
		for (int i = 0; i<this.maxOccupants;i++) {//for loop from 0 to maxOccupants
			if (jobL.front!=null) {//ensures that empty spot is not processed
				processJob(jobL.getJob());//retrieves job
			}
		}

		Job dummyJob = new Job (null,0);//dummy job to send elevator to lobby
		processJob(dummyJob);//processes job
		
		if(this.jobL.front!=null) {//if list is not done, continue processing
			this.processAllJobs();
		}
	}

	/**
	 * Processes job
	 * @param job to process
	 */
	public void processJob(Job job) {

		if (this.currFloor>=job.getFloorNumber()) {//checks if currFloor is above or equal to the job floor
			for (int i = this.currFloor; i>=job.getFloorNumber();i--) {//if it is, elevator goes down
				if (this.currFloor == 0) {
					System.out.println("Elevator at Lobby");
				}else {
					System.out.println("Elevator at floor " + this.currFloor);
				}
				this.currFloor--;//increments currfloor down
			}
		}else {//if elevator is going up
			for (int j=currFloor; j<=job.getFloorNumber(); j++) {// 
				if (this.currFloor == 0) {
					System.out.println("Elevator at Lobby");
				}else {
					System.out.println("Elevator at floor " + this.currFloor);
				}
				this.currFloor++;//incrememnts elevator up
			}
		}
		this.currFloor=job.getFloorNumber();//sets floor to requested floor to avoid incrementation messing it up
		exit(job.person, job.floorNumber);
		if(job.person!=null) {
			System.out.println(job.person);
		}
	}
	/**
	 * 
	 * @param person
	 * @param floor
	 */
	public void exit(Person person, int floor) {
		if (person != null) {
			person.building.exitLobby(person);
			person.building.enterFloor(person, floor);
			person.setLocation(floor);
		}
	}

	public String toString() {
		return "Elevator is on floor " + this.currFloor;
	}
}