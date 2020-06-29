package main;
import main.Person;

/**
 * <Created a linkedlist like structure for elevator list>
 * Known bugs: None
 * 
 * @author Markos Alemu
 * 1/22/20
 * COS121A PAO
 */

public class JobList {
	
	public JobNode front;//front/current list
	public JobNode end;
	public int size=0;//checks size of list
	
	public JobList() {//constructor
	}
	/**
	 * Adds job to linked list
	 * @param job
	 */
	public void add(Job job) {
		JobNode J = new JobNode(job);
		if (this.front==null) {
			this.front=J;
			this.end=J;
		}else if(this.end.getFloor()<=J.getFloor()) {
			this.end.setNext(J);
			this.end=this.end.next;
		}else if (this.front.getFloor()>=J.getFloor()) {
			this.front.setPrev(J);
			this.front=this.front.prev;
		}
		else {
			JobNode temp = this.front;
			while(J.getFloor()<temp.getFloor()) {
				temp=temp.next;
			}
			temp.setNext(J);
		}
	}
	/**
	 * Gets first job and returns job
	 * @return jobs of first node
	 */
	public Job getJob() {
		Job j = new Job();
		j = this.front.job;
		this.front=front.next;//increments list
		
		return j;
	}
	
	public String toString() {
		JobNode j = this.front;
		String printer = "";
		
		while (j!=null) {
			printer += j.job.toString();
			j=j.next;
		}
		return printer;
	}
	
	public int Size() {
		return this.size;
	}

}
