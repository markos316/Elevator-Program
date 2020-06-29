package main;
/**
 * <Node for job linked list>
 * Known bugs: none
 * 
 * @author markos alemu
 * 1/22/20
 * COSI21 PA0
 */
public class JobNode {
	
	public Job job;//job field
	public JobNode next;//next node
	public JobNode prev;
	//node constructor
	
	public JobNode(Job job) {
		this.job=job;
		this.next=null;
	}
	
	public int getFloor() {
		return this.job.getFloorNumber();
	}
	
	public void setNext(JobNode JobN) {
		this.next=JobN;
		JobN.prev=this;
	}
	
	public void setPrev(JobNode JobN) {
		this.prev=JobN;
		JobN.next=this;
	}

	
}
