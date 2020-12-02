package JavaActivity1_2;

public class Activity1_2 {

	public static void main(String[] args) {
		int[] arr = {10, 77, 10, 54, -11, 10};
		
		if(result(arr)==true) {
			System.out.println("The sum of all elements in array is 30");
		}
		else
		{
			System.out.println("The sum of all elements in the array is not 30");
		}
		
	}
	
	public static boolean result(int[] arr) {
		int sum=0;
		for(int i:arr)
		{
			if(i==10)
				sum=sum+i;
		}
		
		//check if the sum of all the 10's in the array is exactly 30
		if(sum==30)
			return true;
		else
			return false;
		
	}
}
