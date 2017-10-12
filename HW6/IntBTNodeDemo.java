// Chris Fietkiewicz. Uses IntBTNode.java from http://www.cs.colorado.edu/~main
// Manually creates a valid binary search tree and searches for a value.
public class IntBTNodeDemo {
	public static void main(String[ ] args) {
		IntBTNode root, temp;
		temp = new IntBTNode(3, null, null); // Create with null children to be set later
		root = new IntBTNode(9, temp, null); // Create root with left child
		temp.setLeft(new IntBTNode(2, null, null)); // Use setLeft() to make connection to new node
		temp.setRight(new IntBTNode(6, null, null)); // Use setRight() to make connection to new node
		// Take a look at what's in there
		root.preorderPrint();
		// Let's search for 6. IMPORTANT: Assumes valid BST!
		int target = 6; // Target value to be searched for
		IntBTNode cursor = root; // Cursor will move through the tree
		while (cursor != null && cursor.getData() != target) { // Stop if past leaf or found
			if (cursor.getData() > target) // Check if target would be on the left
				cursor = cursor.getLeft(); // Move cursor to left child
			else  // Otherwise, target would be on the right
				cursor = cursor.getRight(); // Move cursor to right child
		}
		// Either we found something or we didn't
		if (cursor != null)
			System.out.println("Found " + target + "!");
		else
			System.out.println("Did not find " + target + ".");
	}
}




