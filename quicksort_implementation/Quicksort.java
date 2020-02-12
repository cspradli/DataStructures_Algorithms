package quicksort_implementation;

import java.util.Arrays;

public class Quicksort {

	public void quicksort(int[] array, int p, int r) {
		int q = 0;
		if (p < r) {
			q = partition(array, p, r);
			quicksort(array, p, q-1);
			quicksort(array, q+1, r);
		}
	}
	
	private int partition(int[] array, int p, int r) {
		int x = array[r];
		int i = (p-1);
		for (int j = p; j <= (r-1); j++) {
			if (array[j] <= x) {
				i = i+1;
				swap(array,i,j);
			}
		}
		swap(array, (i+1), r);
		return (i+1);
	}
	
	private void swap(int[] array, int i1, int i2) {
		int temp = 0;
		temp = array[i1];
		array[i1] = array[i2];
		array[i2] = temp;
	}
	
	public void randomizedQuicksort() {
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = {0, 12, 3, 1, 45, 67, 10, 11};
		Quicksort qs1 = new Quicksort();
		System.out.println(test1.length);
		qs1.quicksort(test1, 1, test1.length-1);
		System.out.println(Arrays.toString(test1));
	}

}
