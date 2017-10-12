// Chris Fietkiewicz. Demonstrates preorder traversal. Uses modified version of preorderPrint()
// from BTNode.java to organize the categories.
public class TraversalExample1 {
	public static void preorder(BTNode n) {
		if (n.isLeaf())
			System.out.print(" " + n.getData());
		else {
			System.out.print("(" + n.getData() + ":");
			if (n.getLeft() != null)
				preorder(n.getLeft());
			if (n.getRight() != null)
				preorder(n.getRight());
			System.out.print(")");
		}
	} 

	public static void main(String[ ] args) {
		BTNode<String> root, leaf1, leaf2, leaf3, leaf4, child1, child2;
		leaf1 = new BTNode<String>("pepperoni", null, null);
		leaf2 = new BTNode<String>("cheese", null, null);
		leaf3 = new BTNode<String>("shell", null, null);
		leaf4 = new BTNode<String>("cheese", null, null);
		child1 = new BTNode<String>("pizza", leaf1, leaf2);
		child2 = new BTNode<String>("taco", leaf3, leaf4);
		root = new BTNode<String>("Foods", child1, child2);
		preorder(root);
		System.out.println(); // Cleanup by going to next line
	}
}




