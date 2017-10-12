public class BTNodeDemo
{
   public static void main(String[ ] args)
   {
      BTNode<String> root, leaf1, leaf2, leaf3, child1, child2;
      leaf1 = new BTNode<String>("???", null, null);
      leaf2 = new BTNode<String>("???", null, null);
      leaf3 = new BTNode<String>("???", null, null);
      child1 = new BTNode<String>("???", leaf1, leaf2);
      child2 = new BTNode<String>("???", null, leaf3);
      root = new BTNode<String>("I'm the root!", child1, child2);
      root.inorderPrint();
   }
}




