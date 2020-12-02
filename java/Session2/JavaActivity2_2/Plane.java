package JavaActivity2_2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Plane {
	
	private List<String> Passengers;
	private Integer maxPassengers;
	private Date TakeOffTime;
	private Date LandingTime;
	

	Plane(Integer maxPassengers){
		this.maxPassengers=maxPassengers;
		this.Passengers=new ArrayList<>();
	}
	
	
	void onboard(String Name) {
		this.Passengers.add(Name);
	}
	
	
	Date takeOff() {
		
		this.TakeOffTime=new Date();
		return TakeOffTime;
	}
	
	Date land() {
		this.LandingTime=new Date();
		this.Passengers.clear();
		return LandingTime;
	}
	
	Date getLastTimeLanded(){
		return TakeOffTime;
	}
	
	
	List<String> getPassengers() {
		return Passengers;
	}


	public Integer getMaxPassengers() {
		return maxPassengers;
	}


}
