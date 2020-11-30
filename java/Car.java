package JavaActivity1;

public class Car {
	
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	//Car Constructor
	Car()
	{
		tyres=4;
		doors=5;
	}
	
	//displays the values of all the variables
	void displayCharacteristics() {
		System.out.println("Color : "+color);
		System.out.println("Transmission : "+transmission);
		System.out.println("Make : "+make);
		System.out.println("Tyres : "+tyres);
		System.out.println("Doors : "+doors);
	}
	
	//prints "Car is moving forward."
	void accelerate() {
		System.out.println("Car is moving forward");
	}
	
	//prints "Car has stopped."
	void brake() {
		System.out.println("Car has stopped");
	}

}
