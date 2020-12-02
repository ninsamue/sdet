package JavaActivity2_3;

public class Bicycle implements BicycleParts,BicycleOperations {
	int gears;
	int currentSpeed;
	
	Bicycle(int gears,int currentSpeed){
		this.gears=gears;
		this.currentSpeed=currentSpeed;
	}

	@Override
	public void applyBrake(int decrement) {
		this.currentSpeed-=decrement;
		
	}

	@Override
	public void speedUp(int increment) {
		this.currentSpeed+=increment;
		
	}
	
	public String bicycleDesc() {
		 return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
	}

}
