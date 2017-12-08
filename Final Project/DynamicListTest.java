import java.util.*;
import java.util.HashSet;
public class DynamicListTest{
	public static void main(String[] args){
		DynamicListTest tester = new DynamicListTest();
		System.out.println("Add In Order ");
		System.out.println("Custom array: "+ tester.testAddArrayDynamic() + " ms");
		System.out.println("ArrayList: " + tester.testAddArrayListStdLib() + " ms" );
		System.out.println("Custom linkedlist: " + tester.testAddLinkedDynamic() + " ms");
		System.out.println("LinkedList: " + tester.testAddLinkedStdLib() + " ms");
		System.out.println("Custom hash table : " + tester.testAddHashTableDynamic()+ " ms");
		System.out.println("Hashtable class: " + tester.testAddhashTableStdLib() + " ms");
		System.out.println("Remove Maximum: ");
		System.out.println("Custom array: " + tester.testRemoveMaxArrayDynamic()+ " ms");
		System.out.println("ArrayList : " + tester.testRemoveMaxStdLib()+ " ms");
		System.out.println("Custom linkedlist: " + tester.testRemoveMaxLinkedDynamic()+ " ms");
		System.out.println("LinkedList: " + tester.testRemoveMaxLinkedStdLib()+ " ms");
		System.out.println("Custom HashTable: " + tester.testRemoveMaxCustomHash()+ " ms");
		System.out.println("HashSet (java.util.HashSet): " + tester.testRemoveMaxStdHash() + " ms");
		System.out.println("Linear search: ");
		System.out.println("Custom array: " + tester.testSearchDynamicArr() + " ms");
		System.out.println("ArrayList: "+ tester.testSearchArrayList()+ " ms");
		System.out.println("Custom linkedlist: " + tester.testSearchDynamicLinked() + " ms");
		System.out.println("LinkedList: "+ tester.testSearchLinkedList() + " ms");
		System.out.println("Custom HashTable: " + tester.testSearchDynamicHash()+ " ms");
		System.out.println("HashSet: "+ tester.testSearchHashSet()+ " ms");



	}

	public int testAddArrayDynamic(){
		long startTime, stopTime;
		Random rand = new Random();
		DynamicList<Integer> dl = new DynamicList(20);
		dl.setState(0);
		startTime = System.currentTimeMillis();
		for(int i = 0; i < 5000; i++){
			dl.addInPlace((Integer) (rand.nextInt(500)+1),i);
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
		
	}
	public int testAddArrayListStdLib(){
		long startTime,stopTime;
		Random rand = new Random();
		ArrayList<Integer> al = new ArrayList();
		startTime = System.currentTimeMillis();
		for(int i = 0; i < 5000; i++){
			al.add((Integer) (rand.nextInt(500)+1));
			Collections.sort(al); //random guy on discord said this was faster then insert when using .util libs. will test later
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
	}

	public int testAddLinkedDynamic(){
		long startTime, stopTime;
		Random rand = new Random();
		DynamicList<Integer> dl = new DynamicList(20);
		dl.setState(1);
		startTime = System.currentTimeMillis();
		for(int i = 0; i < 5000; i++){
			dl.addInPlace((Integer) (rand.nextInt(500)+1),i);
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
	}

	public int testAddLinkedStdLib(){
		LinkedList<Integer> ll = new LinkedList();
		long startTime, stopTime;
		Random rand = new Random();
		startTime = System.currentTimeMillis();
		for(int i = 0; i < 5000; i++){
			ll.add(rand.nextInt(500)+1);
			Collections.sort(ll); //TODO: BETTER INSERT METHOD		
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
	}
    public int testAddHashTableDynamic(){
    	long startTime, stopTime;
		Random rand = new Random();
		DynamicList<Integer> dl = new DynamicList(20);
		dl.setState(2);
		startTime = System.currentTimeMillis();
		for(int i = 0; i < 5000; i++){
			dl.addInPlace((Integer) (rand.nextInt(500)+1),i);
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
    }

    public int testAddhashTableStdLib(){
    	long startTime, stopTime;
		Random rand = new Random();
		Hashtable hash = new Hashtable(50000);
		startTime = System.currentTimeMillis();
		for(int i = 0; i < 50000; i++){
			int num = (Integer) (rand.nextInt(500)+1);
			hash.put(num,num);
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
    }
//___________________________________________________________________________________
    public int testRemoveMaxArrayDynamic(){
    	long startTime, stopTime;
		Random rand = new Random();
		DynamicList<Integer> dl = new DynamicList(20);
		dl.setState(0);
		
		for(int i = 0; i < 50000; i++){
			dl.add((Integer) (rand.nextInt(500)+1),i);
		}
		startTime = System.currentTimeMillis();
		for(int i = 0; i < 50000; i++){
			dl.removeLargest();
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
    }
    public int testRemoveMaxStdLib(){
    	long startTime, stopTime;
		Random rand = new Random();
		ArrayList<Integer> al = new ArrayList();
		for(int i = 0; i < 50000; i++){
			al.add((Integer) (rand.nextInt(500)+1));
			Collections.sort(al);
		}
		startTime =  System.currentTimeMillis();
		for(int i = 0; i < 50000-1; i++){
			int max = Collections.max(al);
			al.remove(max);
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
    
    }	

    public int testRemoveMaxLinkedDynamic(){
    	long startTime, stopTime;
		Random rand = new Random();
		DynamicList<Integer> dl = new DynamicList(20);
		dl.setState(1);
		for(int i = 0; i < 5000; i++){
			dl.add((Integer) (rand.nextInt(500)+1),i);
		}
		startTime = System.currentTimeMillis();
		for(int i = 0; i < 5000-1; i++){
			dl.removeLargest();
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
    }

    public int testRemoveMaxLinkedStdLib(){
    	long startTime, stopTime;
		Random rand = new Random();
		LinkedList<Integer> ll = new LinkedList();
		for(int i = 0; i < 5000; i++){
			ll.add(rand.nextInt(500)+1);
			Collections.sort(ll);
		}
		startTime = System.currentTimeMillis();
		for(int i = 0; i < 4999 && ll.size() >1; i++){
			int max = Collections.max(ll); 
			ll.remove(max);
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
    }

    public int testRemoveMaxCustomHash(){
    	long startTime, stopTime;
		Random rand = new Random();
		DynamicList<Integer> dl = new DynamicList(20);
		dl.setState(2);
		for(int i = 0; i < 5000; i++){
			dl.add((rand.nextInt(50000)+1),(rand.nextInt(50000)+1));
		}
		startTime = System.currentTimeMillis();
		for(int i = 0; i < dl.size(); i++){
			dl.removeLargest();
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
    }

    public int testRemoveMaxStdHash(){
    	long startTime, stopTime;
		Random rand = new Random();
		HashSet hash = new HashSet();
		for(int i = 0; i < 50000; i++){
			int num = (Integer) (rand.nextInt(500)+1);
			hash.add(num);
		}
		startTime = System.currentTimeMillis();
		for(int i = 0; i < hash.size(); i++){
			int max = (Integer)Collections.max(hash);
			hash.remove(max);
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
    }
    //____________________________________________________________________

    public int testSearchDynamicHash(){
    	long startTime, stopTime;
		Random rand = new Random();
		DynamicList<Integer> dl = new DynamicList(20);
		dl.setState(2);
		int i = 0;
		for(; i < 500000; i++){
			dl.add((Integer) (rand.nextInt(50000)+1),(Integer)i);
		}
		startTime = System.currentTimeMillis();
		for(int j = 0; j < 500000; j++){
			dl.get(i); //most often the worst case
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
    }
    public int testSearchHashSet(){
    	long startTime, stopTime;
		Random rand = new Random();
		HashSet hash = new HashSet();
		int i = 0;
		for(; i < 500000; i++){
			hash.add((rand.nextInt(50000)+1));
		}
		startTime = System.currentTimeMillis();
		for(int j = 0; j < 500000; j++){
			hash.contains(rand.nextInt(50000)+1);
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
    }

    public int testSearchDynamicArr(){
    	long startTime, stopTime;
		Random rand = new Random();
		DynamicList<Integer> dl = new DynamicList(20);
		dl.setState(0);
		int i = 0;
		for(; i < 5000; i++){
			dl.add((Integer) (rand.nextInt(500)+1),(Integer)i);
		}
		startTime = System.currentTimeMillis();
		for(int j = 0; j < 5000; j++){
			dl.search(rand.nextInt(500)+1); //most often the worst case
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
    }

    public int testSearchArrayList(){
    	long startTime, stopTime;
		Random rand = new Random();
		ArrayList<Integer> al = new ArrayList(5003);
		int i = 0;
		for(; i < 5000; i++){
			al.add((Integer) (rand.nextInt(500)+1));
		}
		startTime = System.currentTimeMillis();
		for(int j = 0; j < 5000; j++){
			al.contains(rand.nextInt(500)+1); //most often the worst case
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
    }

    public int testSearchDynamicLinked(){
    	long startTime, stopTime;
		Random rand = new Random();
		DynamicList<Integer> dl = new DynamicList(20);
		dl.setState(1);
		int i = 0;
		for(; i < 5000; i++){
			dl.add((Integer) (rand.nextInt(500)+1),(Integer)i);
		}
		startTime = System.currentTimeMillis();
		for(int j = 0; j < 5000; j++){
			dl.search(rand.nextInt(500)+1); //most often the worst case
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
    }
    public int testSearchLinkedList(){
    	long startTime, stopTime;
		Random rand = new Random();
		LinkedList ll = new LinkedList();
		int i = 0;
		for(; i < 5000; i++){
			ll.add((Integer) (rand.nextInt(500)+1));
		}
		startTime = System.currentTimeMillis();
		for(int j = 0; j < 5000; j++){
			ll.contains(rand.nextInt(500)+1); //most often the worst case
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
    }
}

