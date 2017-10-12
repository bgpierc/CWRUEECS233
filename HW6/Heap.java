// Chris Fietkiewicz. Incomplete implementation of a priority heap.
// The methods removeMax() and add() do not restore the required heap properties.

public class Heap {
	private int[] data = new int[10]; // Heap data
	private int manyItems = 0; // Quantity of items in the heap
	
	public int removeMax() {
		if (manyItems == 0)
			throw new RuntimeException();
		int maxValue = data[0]; // Get root value
		manyItems--;

		// COMPLETE THIS METHOD TO RESTORE THE REQUIRED HEAP PROPERTIES

		return maxValue;
	}

	public void add(int element) {
		if (manyItems == data.length)
			ensureCapacity((manyItems + 1) * 2);
		data[manyItems] = element;
		manyItems++;

		// COMPLETE THIS METHOD TO RESTORE THE REQUIRED HEAP PROPERTIES

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
		h.add(10);
		h.add(15);
		h.add(5);
		h.add(20);
		h.add(12);
		h.print();
		System.out.print("Removing... ");
		System.out.println(h.removeMax());
		h.print();
	}
}
           