package JavaActivity2_2;

import java.util.List;

public class EncapsulationActivity {
	public static void main(String[] args) throws InterruptedException {
		//Initialize Constructor with maximum number of Passengers
		Plane pl=new Plane(10);
		System.out.println("Maximum Number of Passengers Allowed in Plane : "+pl.getMaxPassengers());
		
		//Add Passenger Name
		pl.onboard("Tom");
		pl.onboard("Don");
		
		//Print Take Off Time
		System.out.println("Take Off Time : "+pl.takeOff());
		
		//Print Passenger List
		List<String> Passengers=pl.getPassengers();
		System.out.println("Passenger Names :");
		for(String name:Passengers)
			System.out.println(name);
		
		//Sleep for 5 seconds
		Thread.sleep(5000);

		//Print Landing Time
		System.out.println("Landing Time : "+pl.land());

		//Print Passenger List
		Passengers=pl.getPassengers();
		System.out.println("Passenger Names :");
		for(String name:Passengers)
			System.out.println(name);
		
	}
	

	
}
