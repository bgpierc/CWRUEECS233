//Ben Pierce (bgp12)
// The methods removeMax() and add() do not restore the required heap properties.
import java.lang.Math.*;
public class Heap {
	private int[] data = new int[10]; // Heap data
	private int manyItems = 0; // Quantity of items in the heap
	
	public int removeMax() { //first attempt
		if (manyItems == 0)
			throw new RuntimeException();
		int maxValue = data[0]; // Get root value
		data[0] = data[manyItems];
		manyItems--;
		int index = 0;
		int tmp = 0;
		int left,right,max,maxIndex;
		do{
			if(2*index+1 > manyItems) //there are no children
				break; //at end of list so we are good
			left = data[2*index+1];
			if(2*index+2 > manyItems) //there is no right child
				right = -1;
			else
				right = data[2*index+2];
			max = (int)Math.max(right,left);
			if(left == max)
				maxIndex = 2*index+1;
			else
				maxIndex = 2*index+2;
			tmp = data[index];
			data[index] = data[maxIndex];
			data[maxIndex] = tmp;
			index = maxIndex;
		} while (data[index] < data[maxIndex]);

		return maxValue;
	}
	public int removeMax2(){ //second attempt
		if (manyItems == 0)
			throw new RuntimeException();
		int maxValue = data[0]; // Get root value
		data[0] = data[manyItems-1];
		manyItems--;
		int index = 0;
		int right,left,max,maxIndex;
		while((2*index+2 < manyItems-1) && (data[index] < data[2*index +1] || data[index] < data[2*index + 2])){
			if(2*index+1 > manyItems-1){
				return maxValue;	//leaf
			}
			left = data[2*index+1];
			if ((2*index+2) >= manyItems-1)
				right = -1;
			else
				right = data[2*index+2];
			max = Math.max(left,right);
			if(max == left)
				maxIndex = (int)(2*index+1);
			else
				maxIndex = (int)(2*index+2);
			if (data[maxIndex] > data[index]){
				int tmp = data[index];
				data[index] = data[maxIndex];
				data[maxIndex] = tmp;
				System.out.println("swapped " + data[index] + " and " + data[maxIndex] );
				
			}
			index = maxIndex;
		}
		
		return maxValue;
	}
	public int removeMax3(){ //third attempt. This time i stopped trying to be fancy and broke it down to individual parts
		if (manyItems == 0)
			throw new RuntimeException();
		int maxValue = data[0]; // Get root value
		data[0] = data[manyItems-1];
		manyItems--;
		int index = 0;
		int leftChild,rightChild;
		while(2*index+1 <= maxValue){
			leftChild = 2*index+1;
			rightChild = 2*index+2;
			if(rightChild < manyItems-1){ //if we are in bounds
				if(data[rightChild] < data[index] && data[leftChild] < data[index]){ //if there are two children
					return maxValue; //its in the right place
				}
				int left = data[2*index+1];
				int  right = data[2*index+2];
				int max = Math.max(right,left);
				int maxIndex;
				if(left == max)
					maxIndex = 2*index+1;
				else
					maxIndex = 2*index+2;
				int tmp = data[index]; //swap
				data[index] = data[maxIndex];
				data[maxIndex] = tmp;
				index = maxIndex;
			}
			else{ //we only have 1 child
				if(data[index] > data[leftChild]){ //its in the right place
					return maxValue;
				}
				else{
					int tmp = data[index];
					data[index] = data[2*index+1];
					data[2*index+1] = tmp;
					index = 2*index+1;
				}
			}
		}
		return maxValue;
	}

	public void add(int element) {
		if (manyItems == data.length)
			ensureCapacity((manyItems + 1) * 2);
		data[manyItems] = element;
		manyItems++;	
		if(manyItems == 1) //only one element
			return;
		int index = manyItems-1;
		int tmp; //swap
		int parentIndex = (int)((index-1)/2);
		while(data[index] > data[parentIndex]){
			tmp = data[index];
			data[index] = data[parentIndex];
			data[parentIndex] = tmp;
			index = parentIndex;
			parentIndex = (int)((index-1)/2);
		}
	}

	// Print all heap values with array indexes
	public void print() {
		for (int i = 0; i < manyItems; i++)
			System.out.println("[" + i + "] " + data[i]);
	}

	// Taken from ArrayBag.java
	public void ensureCapacity(int minimumCapacity) {
		int[] biggerArray;

		if (data.length < minimumCapacity) {
			biggerArray = new int[minimumCapacity];
			System.arraycopy(data, 0, biggerArray, 0, manyItems);
			data = biggerArray;
		}
	}

	public static void main(String[] args) {
		Heap h = new Heap();
		System.out.println("Adding values...");
		h.add(1);
		h.add(3);
		h.add(2);
		h.add(4);
		h.add(6);
		h.add(7);
		h.add(8);
		h.add(5);
		h.print();
		for(int i = 0 ; i < 6; i++){
			System.out.print("Removing... ");
			System.out.println(h.removeMax3());
			h.print();
		}
		
	}
}
           