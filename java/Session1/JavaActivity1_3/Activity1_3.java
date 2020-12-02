package JavaActivity1_3;

public class Activity1_3 {
	public static void main(String[] args) {
		double seconds=1000000000;
		
		double earthSeconds=31557600;
		double mercuryEarthYears=0.2408467;
		double venusEarthYears=0.61519726;
		double marsEarthYears=1.8808158;
		double jupiterEarthYearss=11.862615;
		double saturnEarthYears=29.447498;
		double uranusEarthYears=84.016846;
		double neptuneEarthYears=164.79132;
		
		System.out.println("Age on Earth : "+seconds/earthSeconds);
		System.out.println("Age on Mercury : "+seconds/(earthSeconds*mercuryEarthYears));
		System.out.println("Age on Venus : "+seconds/(earthSeconds*venusEarthYears));
		System.out.println("Age on Mars : "+seconds/(earthSeconds*marsEarthYears));
		System.out.println("Age on Jupiter : "+seconds/(earthSeconds*jupiterEarthYearss));
		System.out.println("Age on Saturn : "+seconds/(earthSeconds*saturnEarthYears));
		System.out.println("Age on Uranus : "+seconds/(earthSeconds*uranusEarthYears));
		System.out.println("Age on Neptune : "+seconds/(earthSeconds*neptuneEarthYears));
		
		
	}
	
	

	

}
