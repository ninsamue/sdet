package JavaActivity2_3;

public class Driver {
	public static void main(String[] args) {
		MountainBike mb = new MountainBike(3, 0, 25);
	    System.out.println(mb.bicycleDesc());
	    
	    //Speed Up
	    System.out.println();
	    mb.speedUp(20);
	    System.out.println("Increase Speed");
	    System.out.println(mb.bicycleDesc());
	    
	    //Apply Brake
	    System.out.println();
	    System.out.println("Apply Brakes");
	    mb.applyBrake(5);
	    System.out.println(mb.bicycleDesc());
	    
	}
}
