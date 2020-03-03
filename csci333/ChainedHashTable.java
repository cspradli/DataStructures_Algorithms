package csci333;

import java.lang.String;
import java.lang.Integer;
import java.util.LinkedList;
import java.util.Random;
import java.util.Arrays;
/**
 * 
 * @author cspradli
 * @version 3.1.20
 * CSCI 333
 * 
 * ChainedHashTable class which implements the a chained hash table outline in the book,
 * includes all basic functions which come with it
 */


public class ChainedHashTable {

	
LinkedList<Integer> ll[];
public static Integer DELETED;

public ChainedHashTable(int n) {
		int nl = nextLogTwo(n);
		int m = (int) Math.pow(2, nl);
		
		ll = new LinkedList[m];
		
		//Set all array elements to be LinkedLists
		for(int i=0; i<m; i++) {
			ll[i] = new LinkedList<Integer>();
		}
		
		System.out.println(Arrays.toString(ll));
		
		
		//System.out.println(Arrays.toString(arr));
		
		
}
	
	
	/**
	 * Helper function to get the next largest power of two from n
	 * @param n
	 * @return
	 */
	private int nextLogTwo(int n) {
		float res = (float)(Math.log(n) / Math.log(2));
		System.out.println("Ch " + res);
		int next_pow = (int) Math.ceil(res);
		return next_pow;
		
	}
	
	private int hash(int key, int m) {
		float A = (float) 0.6180339887;
		float ret_1 = (float) (m * ((key * A) % 1.0));
		int ret = (int) ret_1;
		System.out.println("Hash float - " + ret_1 + "Int rount " + ret);
		return ret;
	}
	
	public void insert(int key) {
		int h = hash(key, ll.length);
		ll[h].addFirst((Integer) key);
		
	}
	
	public void delete(int key) {
		int h = hash(key, ll.length);
		ll[h].remove((Integer) key);
		
	}
	
	public void search(int key) {
		int h = hash(key, ll.length);
		System.out.println(ll[h].contains((Integer) key));
		
	}
	
	public void printTable() {
		System.out.println(Arrays.toString(ll));
	}
}
