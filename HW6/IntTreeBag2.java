//Ben Pierce (bgp12)
public class IntTreeBag2 implements Cloneable
{
   // Invariant of the IntTreeBag class:
   //   1. The elements in the bag are stored in a binary search tree.
   //   2. The instance variable root is a reference to the root of the
   //      binary search tree (or null for an empty tree).
   private IntBTNode root = null;   


public static void main(String[] args){
   IntTreeBag2 bag = new IntTreeBag2();
   for(int i = 1; i <10 ;i++){
      bag.add(i);
   }
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
         if(root == null){ //if there's nothing in the bag
            root = new IntBTNode(element,null,null);
            done = true;
         }
         else if(element < cursor.getData()){ 
            if(cursor.getLeft() == null){ //if there's nothing on the left, insert here
               cursor.setLeft(new IntBTNode(element,null,null));
               done = true;
            }
            else
               cursor = cursor.getLeft(); //move left
         }
         else if(element > cursor.getData()){
            if(cursor.getRight() == null){ //if there's nothing on the right, insert here
               cursor.setRight(new IntBTNode(element,null,null));
               done = true;
            }
            else
               cursor = cursor.getRight(); //move right
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
      while(cursor.getData() != target && cursor != null) //find element to remove
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
      if(cursor == null) // if it isn't found, we can't remove it
         return false;
      else if(cursor == root && root.getLeft() == null){ //if the cursor is the root and it doesn't have a left child
         root = root.getRight(); //we'll let the garbage collector take care of that
         return true;
      }
      else if(cursor.getLeft() == null){ // if the cursor doesn't have a left child
         if(cursor == parentOfCursor.getLeft())
            parentOfCursor.setLeft(cursor.getRight());
         else
            parentOfCursor.setRight(cursor.getRight());
         return true;
      }
      else if(cursor != null && cursor.getLeft() != null){ //if the cursor isn't at the end and it has a left child, we can't outright remove it
         cursor.setData(cursor.getLeft().getRightmostData()); //move biggest node on the rightmost side of the tree after the cursor
         cursor.setLeft(cursor.getLeft().removeRightmost()); //remove node we just moved
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
           
