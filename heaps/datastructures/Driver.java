package heaps.datastructures;

import java.util.Random;
import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {

		Random randn = new Random();

		/**
		 * Test case 1
		 */
		int[] arr1 = { 0, 4, 93, 27, 40, 16};
		System.out.println("** Test 1 **");
		//System.out.println(Arrays.toString(arr1));
		MaxHeap mh1 = new MaxHeap(arr1);
		//mh1.printMaxHeap();
		//mh1.heapsort();
		//mh1.buildMaxHeap();
		mh1.printMaxHeap();
		
		
		
	}
}
