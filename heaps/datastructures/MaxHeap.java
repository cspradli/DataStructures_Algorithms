/**
 * @author cspradli
 * @version 2.5.2020
 * Assignement: HW2 Heaps
 * Class: CSCI 333
 * 
 * This code gives the user the ability to input an array, and build a 
 * heap from an array.
 * 
 * The heap is then able to be sorted using the heapsort method.
 * 
 * 
 */
package heaps.datastructures;

import java.util.Arrays;

public class MaxHeap {

	private int[] array;
	private int heapsize;

	public MaxHeap(int[] input) {
		array = Arrays.copyOfRange(input, 0, input.length);
		heapsize = array.length - 1;
		buildMaxHeap();

	}

	/**
	 * @param index
	 * @return the index of the left child within the array/heap
	 */
	private int leftChildOf(int index) {
		int ret_value = 2 * index;
		if (index > array.length || ret_value > array.length) {
			return -1;
		}
		return ret_value;
	}

	/**
	 * @param index
	 * @return the index of the right child within the array/heap
	 */
	private int rightChildOf(int index) {
		int ret_value = 2 * index + 1;
		if (index > array.length || ret_value > array.length) {
			return -1;
		}
		return ret_value;
	}

	/**
	 * Writes out the content of heaps array data field. Copies the array from 1 to
	 * array.length because of zero indexing
	 */
	public void printMaxHeap() {
		int[] arr_out = Arrays.copyOfRange(array, 1, array.length);
		System.out.println("\nHeap size: " + heapsize);
		System.out.println(Arrays.toString(arr_out) + "\n");
	}

	/**
	 * swap is a minor helper function to swap elements in the array
	 * 
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
	 * 
	 * @param index
	 */
	private void maxHeapify(int index) {

		int left = leftChildOf(index);
		int right = rightChildOf(index);

		int largest = 0;

		if ((left != -1) && (left <= heapsize) && (array[left] > array[index])) {
			largest = left;
		} else {
			largest = index;
		}

		if (right != -1 && right <= heapsize && array[right] > array[largest])
			largest = right;

		if (largest != index) {
			swap(index, largest);
			maxHeapify(largest);
		}

	}

	/**
	 * Loop which invokes maxHeapify
	 * 
	 */
	private void buildMaxHeap() {
		for (int i = (heapsize / 2); i >= 1; i--) {
			maxHeapify(i);
		}
	}

	/**
	 * Makes use of buildMaxHeap and maxHeapify to sort the heap
	 * 
	 */
	public void heapsort() {
		buildMaxHeap();
		int backup = heapsize;
		for (int i = heapsize; i >= 2; i--) {
			swap(1, i);
			heapsize -= 1;
			maxHeapify(1);
		}
		heapsize = backup;
	}
}
