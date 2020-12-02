package JavaActivity2_4;

public class Activity2_4 {
	public static void main(String[] args) {
		
		try {
			
			exceptionTest("Hello");
			exceptionTest(null);
			exceptionTest("World");
		}
		catch(CustomException ce) {
			System.out.println("Inside Error Block");
		}
	}

	static void exceptionTest(String value) throws CustomException {
		
		if(value==null)
			throw new CustomException("String value is null");
		else
			System.out.println(value);
		
	}
}
