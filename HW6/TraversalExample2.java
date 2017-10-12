// Chris Fietkiewicz. Demonstrates inorder traversal. Uses modified version of inorderPrint()
// from BTNode.java to organize the categories.
public class TraversalExample2 {
	public static void inorder(BTNode n) {
		if (!n.isLeaf())
			System.out.print("(");
		if (n.getLeft() != null)
			inorder(n.getLeft());
		System.out.print(n.getData());
		if (n.getRight() != null)
			inorder(n.getRight());
		if (!n.isLeaf())
			System.out.print(")");
	} 

	public static void main(String[ ] args) {
		BTNode<String> root, leaf1, leaf2, leaf3, leaf4, child1, child2;
		leaf1 = new BTNode<String>("1", null, null);
		leaf2 = new BTNode<String>("2", null, null);
		leaf3 = new BTNode<String>("3", null, null);
		leaf4 = new BTNode<String>("4", null, null);
		child1 = new BTNode<String>("+", leaf1, leaf2);
		child2 = new BTNode<String>("-", leaf3, leaf4);
		root = new BTNode<String>("*", child1, child2);
		inorder(root);
		System.out.println(); // Cleanup by going to next line
	}
}




