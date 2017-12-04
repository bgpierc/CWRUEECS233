/** Ben Pierce (bgp12)
** For this  project, I decided to focus on time-efficency. This is NOT intended
** to be a memory-efficent implementation; which would be quite possible, but diffrent. 
** Instead, I focus getting the best BigO complexity possible.
**/
import java.util.*;
public class DynamicList<T extends Comparable<T>>{
	private static final int HASH_THRESHOLD = 700; //number that we switch to a hash table, regardless of other factors
	private static int SIZE;
	private BasicArrayList<T> arr;
	private BasicLinkedList<T> linked;
	private BasicHashTable<T> hash;

	private static int addInOrder = 0; //how many times each of these operations have been performed
	private static int removeLargest = 0;
	private static int search = 0;


	private int numElements;
	private int state = 0;

	public DynamicList(int size){
		this.SIZE = size;
		this.numElements = 0;
		this.arr = new BasicArrayList(SIZE);
		this.linked = new BasicLinkedList();
		this.hash = new BasicHashTable(SIZE);

	}

	//0 = arraylist, 1 = linkedlist, 2 = hash tabe
	public void setState(int stateKey){
		if(this.
		this.state = stateKey;
	}
	// The time constant system is how the data structure adapts to its situations
	// it is computed by multiplying the number of times the strucutre performs an
	// operation by its time complexity with respect to number of elements
	public void chooseStructure(){
		//best = smallest
		int timeConstantAddArr = addInOrder*(3*numElements); // 3 loops
		int timeConstantAddLink = addInOrder*numElements;
		int timeConstantAddHash = addInOrder; //avg case

		int timeConstantRemoveArr = removeLargest*(2*numElements); //accounts for shift
		int timeConstantRemoveLink = removeLargest*numElements;
		int timeConstantRemoveHash = removeLargest*numElements; //does not require shift

		int timeConstantSearchArr = search*numElements;
		int timeConstantSearchLink = search*numElements;
		int timeConstantSearchHash = search; //avg case

		int sumArr = timeConstantAddArr + timeConstantRemoveArr + timeConstantSearchArr;
		int sumLink = timeConstantAddLink + timeConstantRemoveLink +timeConstantSearchLink;
		int sumHash = timeConstantAddHash + timeConstantRemoveHash + timeConstantSearchHash;

		int smallest = lowest(sumArr,sumLink,sumHash);
		if(numElements>=HASH_THRESHOLD){ //if we've got a lot of data, we're using a hash table. Otherwise, it's crap.
			setState(2);
		}
		else if(addInOrder > 0){
			if(smallest == sumArr){
				setState(0);
			}
			else if(smallest == sumLink){
				setState(1);
			}
			else
				setState(0);
		}
		
	}

	public int lowest(int... elements){
		int smallest = elements[0]; 
		for(int i: elements){
			if (i < smallest)
				smallest = i;
		}
		return smallest;
	}

	public void addInPlace(T element, T key){
		chooseStructure();
		if(state == 2 && key != null){
			hash.put(element,key); //add in place meaningless for hashtable.
		}
		else if (state == 0){
			arr.addInOrder(element);
		}
		else if (state == 1){
			linked.addInOrder(element);
		}
		addInOrder++;
	}
	public void removeLargest(){
		chooseStructure();
		if (state == 0){
			arr.removeLargest();
		}
		else if(state == 1){
			linked.removeLargest();
		}
		else if(state ==2){
			hash.removeLargest();
		}
		removeLargest++;
	}
	public Object search(T target){
		chooseStructure();
		if(state == 0){
			return arr.search(target);
		}
		else if(state == 1){
			return linked.search(linked.getHead(),target);
		}
		else if(state == 2){
			return hash.search(target);
		}
		search++;
		return -1;
	}

	public void print(){
		if(state == 0){
			System.out.println("ArrayList: ");
			arr.print();
		}
		else if(state ==1){
			System.out.println("LinkedList: "  + linked.toString());
		}
		else if(state == 2){
			System.out.println("HashTable: ");
			hash.print();
		}
	}
	//arguemnt: which comparison: 0= linked-arr, 1= linked-hash, 2=arr-hash
	public boolean compare(int a){
		if(a == 0){
			LinkedNode cursor = linked.getHead();
			if(linked.size() != arr.size())
				return false;
			for(int i = 0; i < arr.size(); i++){
				if(cursor.getData().compareTo(arr.get(i)) != 0)
					return false;
				cursor = cursor.getLink();
			}
			return true;
		}
		else if(a==1){
			LinkedNode cursor = linked.getHead();
			if(linked.size() != hash.size()){
				return false;
			}
			Object[] hashContents = hash.items();
			Object[] linkedContents = linked.items();
			Arrays.sort(hashContents);
			Arrays.sort(linkedContents);
			return (Arrays.equals(hashContents,linkedContents)); 
		}
		else if(a==2){
			Object[] hashContents = hash.items();
			Arrays.sort(hashContents);
			return Arrays.equals(hashContents,arr.items());
		}
		else
			throw new IllegalArgumentException("Bad arguement");
			
	}



}