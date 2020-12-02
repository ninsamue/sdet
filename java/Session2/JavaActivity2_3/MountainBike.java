package JavaActivity2_3;

public class MountainBike extends Bicycle{
	
	double seatHeight;
	
	MountainBike(int gears,int currentSpeed,double seatHeight){
		super(gears,currentSpeed);
		this.seatHeight=seatHeight;
	}

	public void setHeight(int newValue) {
	    seatHeight = newValue;
	}
	
	public String bicycleDesc() {
		return(super.bicycleDesc()+"\nHeight of the Seat is "+seatHeight);
	}
	
}
