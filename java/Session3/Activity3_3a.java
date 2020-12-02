package Session3;

import java.util.LinkedList;
import java.util.Queue;

public class Activity3_3a {
	public static void main(String[] args) {
		//Create a Queue named q
		Queue<Integer> q = new LinkedList<>();
		
		//Add first 5 natural numbers to it and print the Queue
		System.out.println("Add First 5 natural numbers to a queue");
		for(int i=1;i<=5;i++)
			q.add(i);
		
		System.out.println("Elements in the queue : ");
		for(int i:q)
			System.out.print(i+" ");
		
		//Remove a number in the Queue using the remove() method
		System.out.println("\n");
		System.out.println("Remove Number 4 : "+q.remove(4));
		
		//Peek() at the first number in the Queue after removal
		System.out.println("Peek at First Number : "+q.peek());
		
		//Print the size of the Queue using the size() method
		System.out.println("Size of the queue : "+q.size());
		
		//Print the updated Queue
		System.out.println();
		System.out.println("Elements in the queue : ");
		for(int i:q)
			System.out.print(i+" ");
	}

}
