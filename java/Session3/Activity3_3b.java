package Session3;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Activity3_3b {
	
	public static void main(String[] args) {
		//Create a Deque named dq
		Deque<String> dq = new LinkedList<String>();
		
		//Add any 6 animals to it
		dq.add("Cat");
		dq.addFirst("Dog");
		dq.addLast("Wolf");
		dq.offer("Fox");
		dq.offerFirst("Elephant");
		dq.offerLast("Lion");
		
		//Use the Iterator interface to iterate through the deque and print the values in the queue.
		System.out.print("Animal Queue : ");
		Iterator<String> it=dq.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		
		//Peek() at the head element and the tail element of the queue
		System.out.println("\n");
		System.out.println("Peek at Head Element : "+dq.peekFirst());
		System.out.println("Peek at Tail Element : "+dq.peekLast());
		
		//Check if there is a Wolf present in the queue using the contains() method
		System.out.println();
		System.out.println("Check if Wolf is present in the queue : "+dq.contains("Wolf"));
		
		//Remove() the first and last element from the queue
		System.out.println();		
		System.out.println("Remove the First Element : "+dq.removeFirst());
		System.out.println("Remove the Last Element : "+dq.removeLast());
		
		//Print the size() of the queue after removal
		System.out.println();
		System.out.println("Size of the queue : "+dq.size());
		
		System.out.println();
				System.out.print("Animal Queue : ");
		it=dq.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		
		
		
	}

}
