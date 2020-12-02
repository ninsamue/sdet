package Session3;

import java.util.ArrayList;
import java.util.List;

public class Activity3_1 {
	
	public static void main(String[] args) {
		//Create an ArrayList named myList of type String
		List<String> myList=new ArrayList<String>();
		
		//Add 5 names to the ArrayList using add() method
		myList.add("Aa");
		myList.add("Ba");
		myList.add("Ca");
		myList.add("Da");
		myList.add("Ea");
		
		//print all the names using for loop
		System.out.println("Names : ");
		for(String str:myList)
			System.out.println(str);
		
		//use get() method to retrieve the 3rd name in the ArrayList
		System.out.println();
		System.out.println("Third Name in the ArrayList : "+myList.get(2));
		
		//Use contains() method to check if a name exists in the ArrayList
		System.out.println();
		System.out.println("Check if ArrayList containts Da");
		if(myList.contains("Da"))
			System.out.println("Da is present in the ArrayList");
		else
			System.out.println("Da is not present in the ArrayList");
		
		//Use size() method to print the number of names in the ArrayList
		System.out.println();
		System.out.println("Number of names in the ArrayList : "+myList.size());
		
		//Use remove() method to remove a name from the list
		System.out.println();
		System.out.println("Remove Da from the Array List");
		myList.remove("Da");
		
		System.out.println();
		System.out.println("Names : ");
		for(String str:myList)
			System.out.println(str);
		
		//print the size() of the list
		System.out.println();
		System.out.println("Number of names in the ArrayList : "+myList.size());
		
		
		
		
	}

}
