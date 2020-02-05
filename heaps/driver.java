package heaps;

import java.util.Random;

public class driver {

	public static void main(String[] args) {
		
		Random randn = new Random();
		
		/**
		 * Test case 1
		 */
		int []arr1 = {0, 1, 13, 8, 6, 9};
		MaxHeap mh1 = new MaxHeap(arr1);
		mh1.heapsort();
		mh1.printMaxHeap();
		
		/**
		 * Test case 2
		 */
		int []arr2 = {0, 2, 10, 5, 4, 7};
		MaxHeap mh2 = new MaxHeap(arr2);
		mh2.heapsort();
		mh2.printMaxHeap();
		
		/**
		 * Test case 3
		 */
		int []arr3 = {0, 4, 3, 2, 16, 9, 10, 14, 8, 7};
		MaxHeap mh3 = new MaxHeap(arr3);
		mh3.heapsort();
		mh3.printMaxHeap();
		
		
		/**
		 * Test case 4: test the boundary condition of 1 element in array
		 */
		int []arr4 = {0, 1};
		MaxHeap mh4 = new MaxHeap(arr4);
		mh4.heapsort();
		mh4.printMaxHeap();
		
		/**
		 * Test case 5 : test extended array
		 */
		int []arr5 = new int[101];
		for (int i = 1; i < 101; i++) {
			arr5[i] = randn.nextInt(101);
		}
		MaxHeap mh5 = new MaxHeap(arr5);
		mh5.heapsort();
		mh5.printMaxHeap();
	}
}
