// Chris Fietkiewicz. Based on IntTreeBag.java from the package edu.colorado.collections
public class IntTreeBag2 implements Cloneable
{
   // Invariant of the IntTreeBag class:
   //   1. The elements in the bag are stored in a binary search tree.
   //   2. The instance variable root is a reference to the root of the
   //      binary search tree (or null for an empty tree).
   private IntBTNode root = null;   


public static void main(String[] args){
   IntTreeBag2 bag = new IntTreeBag2();
   bag.add(9);
   bag.add(3);
   bag.add(2);
   bag.add(1);
   bag.add(6);
   bag.add(5);
   bag.add(4);
   bag.add(7);
   bag.add(8);
   System.out.println("Preorder Print method: ");
   bag.preorderPrint();
   System.out.println("Inorder Print method: ");
   bag.inorderPrint();
   System.out.println("Postorder Print method: ");
   bag.postorderPrint();
}







   /**
   * Insert a new element into this bag.
   * @param element
   *   the new element that is being inserted
   * <b>Postcondition:</b>
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory a new IntBTNode.
   **/
   public void add(int element){
      IntBTNode cursor = root;
      boolean done = false;
      while(!done){
         if(root == null){
            root = new IntBTNode(element,null,null);
            done = true;
         }
         else if(element < cursor.getData()){
            if(cursor.getLeft() == null){
               cursor.setLeft(new IntBTNode(element,null,null));
               done = true;
            }
            else
               cursor = cursor.getLeft();
         }
         else if(element > cursor.getData()){
            if(cursor.getRight() == null){
               cursor.setRight(new IntBTNode(element,null,null));
               done = true;
            }
            else
               cursor = cursor.getRight();
         }
      }
   }

   /**
   * Remove one copy of a specified element from this bag.
   * @param target
   *   the element to remove from the bag
   * <b>Postcondition:</b>
   *   If <CODE>target</CODE> was found in the bag, then one copy of
   *   <CODE>target</CODE> has been removed and the method returns true. 
   *   Otherwise the bag remains unchanged and the method returns false. 
   **/
   private boolean remove(int target)
   {
      IntBTNode cursor = root;
      IntBTNode parentOfCursor = null;
      while(cursor.getData() != target && cursor != null)
      {
         if(target < cursor.getData()){
            parentOfCursor = cursor;
            cursor = cursor.getLeft();
         }
         else if(target > cursor.getData()){
            parentOfCursor = cursor;
            cursor = cursor.getRight();
         }
      }
      if(cursor == null)
         return false;
      else if(cursor == root && root.getLeft() == null){
         root = root.getRight(); //we'll let the garbage collector take care of that
         return true;
      }
      else if(cursor.getLeft() == null){
         if(cursor == parentOfCursor.getLeft())
            parentOfCursor.setLeft(cursor.getRight());
         else
            parentOfCursor.setRight(cursor.getRight());
         return true;
      }
      else if(cursor != null && cursor.getLeft() != null){
         cursor.setData(cursor.getLeft().getRightmostData());
         cursor.setLeft(cursor.getLeft().removeRightmost());
         return true;
      }
      return false; //should never reach this point
   }
   private void preorderPrint(){
      root.preorderPrint();
   }
   private void inorderPrint(){
      root.inorderPrint();
   }
   private void postorderPrint(){
      root.postorderPrint();
   }
}
           
