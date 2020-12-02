package Session3;

import java.util.HashSet;

public class Activity3_2 {
	
	public static void main(String[] args) {
		//Create a HashSet named hs
		HashSet<String> hs= new HashSet<String>();
		
		//Add 6 objects using add() method to the HashSet
		hs.add("Aa");
		hs.add("Ba");
		hs.add("Ca");
		hs.add("Da");
		hs.add("Ea");
		hs.add("Fa");
		
		System.out.println("Elements in the HashSet :");
		for(String name:hs)
			System.out.println(name);
		
		//print the size of the HashSet using the size() method
		System.out.println("Size of the Hash Set : "+hs.size());
		
		//Remove an element using the remove() method
		System.out.println();
		System.out.println("Remove the element Da from HastSet");
		hs.remove("Da");
		System.out.println("Elements in the HashSet :");
		for(String name:hs)
			System.out.println(name);
		
		//try to remove an element that is not present in the Set
		System.out.println();
		System.out.println("Remove the element Do from HastSet");
		if(hs.remove("Do"))
			System.out.println("Element Do is removed");
		else
			System.out.println("Element Do is not present");
		System.out.println("Elements in the HashSet :");
		for(String name:hs)
			System.out.println(name);
		
		//Use the contains() method to check if an item is in the Set or not
		System.out.println();
		System.out.println("Check if Item Ea is present in the HashSet : "+hs.contains("Ea"));
		System.out.println("Check if Item Ee is present in the HashSet : "+hs.contains("Ee"));
		
		//Print the updated set
		System.out.println();
		System.out.println("Elements in the HashSet :");
		for(String name:hs)
			System.out.println(name);
	}

}

