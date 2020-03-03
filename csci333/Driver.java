package csci333;

/**
 * 
 * @author cspradli
 * @version 3.1.20
 * 
 * Driver class form both chained hash table and open-addressed hash table. 
 */

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChainedHashTable test1 = new ChainedHashTable(12);
		test1.insert(12);
		test1.insert(12);
		test1.insert(8);
		test1.insert(0);
		test1.insert(85);
		test1.insert(32);
		test1.insert(4);
		test1.insert(25);
		test1.printTable();
		test1.delete(12);
		test1.delete(0);
		test1.search(12);
		test1.search(0);
		test1.printTable();
	

	}

}
