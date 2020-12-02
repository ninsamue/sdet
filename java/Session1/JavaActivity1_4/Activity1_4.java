package JavaActivity1_4;

public class Activity1_4 {

 
	    public static void main(String args[]) {
	        int[] data = { 34, 15, 53, 40, 31 };
	       
	        
	        System.out.println("Array before sorting : ");
	        for(int i:data)
	        	System.out.print(i+" ");
	        
	        insertionSort(data);
	        
	        System.out.println("\nSorted Array in Ascending Order : ");
	        
	        for(int i:data)
	        	System.out.print(i+" ");
	        
	    }
	
	    static void insertionSort(int[] array) {
	        int size = array.length, i;
	        
	        for (i = 1; i < size; i++) {
	            int key = array[i];
	            int j = i - 1;
	            
	            while (j >= 0 && key < array[j]) {
	                array[j + 1] = array[j];
	                --j;
	            }
	            array[j + 1] = key;
	        }
	    }
}
