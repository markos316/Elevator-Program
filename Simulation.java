package main;

public class Simulation {

	public static void main(String[] args) {
		
		Person bob = new Person ("Bob", "Smith");
		Person bob1 = new Person ("Bobby", "Smith");
		Person bob2 = new Person ("Booby", "Smiths");
		Person bob3 = new Person ("Bobby", "Smiths");
		
		Building bigben = new Building (10);
		
		bob.enterBuilding(bigben, 4);
		bob1.enterBuilding(bigben, 5);
		bob2.enterBuilding(bigben, 2);
		bob3.enterBuilding(bigben, 5);
		
		//bigben.elv.shuffle();
		//System.out.println(bigben);
		bigben.startElevator();
		System.out.println(bigben);
		
	

	}

}
