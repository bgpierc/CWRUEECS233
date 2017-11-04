//Ben Pierce (bgp12)

// File: BinarySearcher.java
// A Java application to illustrate the binary search of an array.
// Additional javadoc documentation is available at
//   http://www.cs.colorado.edu/~main/docs/BinarySearcher.html
 
/******************************************************************************
* The <CODE>BinarySearcher</CODE> Java application runs a small test on the 
* <CODE>search</CODE> method from Chapter 11 (using a binary search to
* find a specified number in an array).
*
* <p><b>Java Source Code for this class:</b>
*   <A HREF="../applications/BinarySearcher.java">
*   http://www.cs.colorado.edu/~main/applications/SimpleSearcher.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version Feb 10, 2016
******************************************************************************/
public class BinarySearcher
{

   /**
   * The main method prints a table of test results, searching for numbers
   * in an array that contains 2, 4, 6, 8, 10, 12, and 14.
   * @param args
   *   not used in this implementation
   **/
   public static void main(String[ ] args)
   {
      final int[ ] DATA = { 2, 4, 6, 8, 10, 12, 14 };
      final int[ ] EMPTY = new int[0];
      final int MINIMUM = -1;
      final int MAXIMUM = 16;
      
      int target;
      int answer;

      System.out.println("Searching for numbers in an array.");
      for (target = MINIMUM; target <= MAXIMUM; target++)
      {
          System.out.print("Is " + target + " in the array? ");
          answer = loopSearch(DATA, 0, DATA.length-1, target);
          if (answer == -1)
             System.out.println("No.");
          else
             System.out.println("Yes, at index [" + answer + "].");
      }
      
      System.out.print("Searching for 0 in an empty array: ");
      if (loopSearch(EMPTY, 0, 0, 0) == -1)
         System.out.println(" Not found.");
      else
         System.out.println(" Found!");

      System.out.println("End of searching.");
   }
 
        
   /**
   * Search part of a sorted array for a specified target.
   * @param a
   *   the array to search
   * @param first
   *   the first index of the part of the array to search
   * @param size
   *   the number of elements to search, starting at 
   *   <CODE>a[first]</CODE>
   * @param target
   *   the element to search for
   * <b>Precondition:</b>
   *   If <CODE>size &gt; 0</CODE>, then <CODE>first</CODE> through 
   *   <CODE>first+size-1</CODE> must be valid indexes for the array <CODE>a</CODE>.
   *   Also, starting at <CODE>a[first]</CODE>, the next <CODE>size</CODE> 
   *   elements are sorted in increasing order from small to large.
   * @return
   *   If <CODE>target</CODE> appears in the array segment starting at 
   *   <CODE>a[first]</CODE> and containing <CODE>size</CODE> elements,
   *   then the return value is the index of a location that
   *   contains <CODE>target</CODE>; otherwise the return value is -1.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that some index in the range <CODE>first</CODE>
   *   through <CODE>first+size-1</CODE> is outside the range of
   *   valid indexes for the array <CODE>a</CODE>.
   **/
   public static int search(int[ ] a, int first, int size, int target)
   {
      int middle;

      if (size <= 0)
         return -1;
      else
      {
         middle = first + size/2;
         if (target == a[middle])
            return middle;
         else if (target < a[middle])
            // The target is less than a[middle], so search before the middle.
            return search(a, first, size/2, target);
         else 
            // The target must be greater than a[middle], so search after the middle.
            return search(a, middle+1, (size-1)/2, target);
      } 
   }
   public static int loopSearch(int[] arr, int lowerBound, int upperBound, int target){
      int middle;
      while(lowerBound <= upperBound){
         middle = lowerBound +(upperBound-lowerBound-1)/2; //to avoid going out of bounds
         if(arr.length == 0 || upperBound == 0 || upperBound == -1)
            return -1;
         if(target == arr[middle]){
            //System.out.println("Found at index " + middle);
            return middle;
         }
         else if(target<arr[middle])
            upperBound = middle-1;
         else if(target > arr[middle])
            lowerBound = middle+1;
      }
      return -1;
   }

   public static int searchPrint(int[ ] a, int first, int size, int target)
   {
      int middle;

      if (size <= 0)
         return -1;
      else
      {
         middle = first + size/2;
         if (target == a[middle]){
            System.out.print(" Found at index " + middle + " ");
            return middle;
         }
         else if (target < a[middle]){
            // The target is less than a[middle], so search before the middle.
            System.out.print(" Searching before " + middle + " ");
            return searchPrint(a, first, size/2, target);
         }
         else {
            // The target must be greater than a[middle], so search after the middle.
            System.out.print(" Searching after " + middle);
            return searchPrint(a, middle+1, (size-1)/2, target);
         }
      } 
   }

}
