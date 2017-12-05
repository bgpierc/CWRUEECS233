import java.util.*;
public class DynamicListTest{
	public static void main(String[] args){
		DynamicListTest tester = new DynamicListTest();
		System.out.println("Custom array add in place: "+ tester.testAddArrayDynamic() + " ms");
		System.out.println("ArrayList add in place: " + tester.testAddArrayListStdLib() + " ms" );
		System.out.println("Custom linkedlist add in place: " + tester.testAddLinkedDynamic() + " ms");
		System.out.println("LinkedList add in place: " + tester.testAddLinkedStdLib() + " ms");
		System.out.println("Custom hash table add: " + tester.testAddHashTableDynamic()+ " ms");
		System.out.println("Hashtable class add: " + tester.testAddhashTableStdLib() + " ms");

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
			Collections.sort(ll);
			//addInPlace(ll,(rand.nextInt(500)+1));
			
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
	}
	private void addInPlace(LinkedList<Integer> ll, Integer element){
		 if (ll.size() == 0) 
            ll.add(element);
        else if (ll.get(0).compareTo(element) > 0) 
            ll.add(0, element);
         else if (ll.get(ll.size() - 1) < element) 
             ll.add(ll.size(),element);
        else{
            int i = 0;
            while (ll.get(i).compareTo(element) < 0) {
                i++;
            }
            ll.add(i, element);
        }
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
}

