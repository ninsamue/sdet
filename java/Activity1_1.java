package JavaActivity1;

public class Activity1_1 {
	
	public static void main(String[] args) {
		//Intialize a new instance of Car class
		Car c1= new Car();
		
		//Initialize variables in main
		c1.color="Black";
		c1.make=2014;				
		c1.transmission="Manual";
	
		//Call the method from Car class
		c1.displayCharacteristics();
		c1.accelerate();
		c1.brake();
	}

}
