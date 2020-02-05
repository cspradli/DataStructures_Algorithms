package heaps;

import java.util.Arrays;


public class MaxHeap {

private int[] array;
private int heapsize;

public MaxHeap(int[] input) {
	array = Arrays.copyOfRange(input, 0, input.length);
	heapsize = array.length-1;
	printMaxHeap();
	
}

private int leftChildOf(int index) {
	return (2 * index);
	
}

private int rightChildOf(int index) {
	return 2 * index + 1;
}
	

public void printMaxHeap() {
	int[] arr_out = Arrays.copyOfRange(array, 1, array.length);
	System.out.println("Heap size: " + heapsize);
	System.out.println(Arrays.toString(arr_out));
}

/**
 * swap is a minor helper function to swap elements in the array
 * @param first_pos
 * @param last_pos
 */
private void swap(int first_pos, int last_pos) {
	int tmp;
	tmp = array[first_pos];
	array[first_pos] = array[last_pos];
	array[last_pos] = tmp;
}

/**
 * maxHeapify lets the value at array[index] "float down" in the max-heap
 * @param index
 */
public void maxHeapify(int index) {
	
	int left = leftChildOf(index);
	int right = rightChildOf(index);
	int largest = 0;
	
	if ((left <= heapsize) && (array[left] > array[index])) {
		largest = left;
	} else {
		largest = index;
	}
	
	if (right <= heapsize && array[right] > array[largest]) largest = right;
	
	if (largest != index) {
		swap(index, largest);
		maxHeapify(largest);
	}
	
}

private void buildMaxHeap() {
	for (int i = (heapsize/2); i >= 1; i--) {
		maxHeapify(i);
	}
}

public void heapsort() {
	buildMaxHeap();
	int backup = heapsize;
	for (int i = heapsize; i >= 2; i--) {
		swap(1, i);
		heapsize -= 1;
		maxHeapify(1);
	}
	
}
}
