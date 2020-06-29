package main;
/**
 * <Floor object class>
 * Known bugs: None
 * 
 * @author Markos Alemu
 * markos@brandeis.edu
 *1/22/20
 *COSI 21A PA0
 */
public class Floor {
	
	Person [] ppl = new Person [1000];//person array
	int index=0;//index
	
	/**
	 * Enters person into floor
	 * @param person
	 */
	public void enterFloor(Person person) {
		this.ppl[index]=person;//puts person into array
		this.index++;//increment index
		
		if(this.ppl.length-this.index<50) {//checks if array is close to getting full
			Person [] ppl1 = new Person [this.ppl.length*10];//resizes array
			for (int i  = 0; i<this.index;i++) {//transfers people from original array to new one
				ppl1[i] = this.ppl[i];
				this.ppl=ppl1;
			}
		}
		
	}
	/**
	 * gets people on floor
	 * @return index/total people on floor
	 */
	public int getCount() {
		return this.index;
	}
	/**
	 * toString method
	 */
	public String toString() {
		return this.getCount() + " patron(s)\n";
	}
}
