/** Ben Pierce (bgp12)
**I had thought about using Java's built-in data structures, but since I will
**be analyzing time complexities, I want to know every bit of code that I will be
**using.  
**/
public class BasicLinkedList<T extends Comparable<T>>{ 
	private int numNodes;
	private LinkedNode head;

	public BasicLinkedList(){
		head = null;
		numNodes = 0;
	}
	//add in front
	//not overly useful
	public void add(T element){
		head = new LinkedNode(element, head);
		numNodes++;
	}
	//adds to the end
	public void append(T element){
		LinkedNode cursor = head;
		if(head == null){
			head = new LinkedNode(element, null);
			return;
		}
		while(cursor.getLink() != null){
			cursor = cursor.getLink();
		}
		cursor.setLink(new LinkedNode(element, null));
		numNodes++;
	}
	//adds a bunch of elements to the end
	public void addAll(T...elements){
		for(T t:elements){
			append(t);
		}
		numNodes+=elements.length;
	}
	//adds an element to maintain a L->G sorted list
	public void addInOrder(T element){
		LinkedNode insert;
		LinkedNode cursor;
		if(head == null || head.getData().compareTo(element) >= 0){ //if the element needs to be in front
			insert = new LinkedNode(element,head);
			head = insert;
			numNodes++;
		}
		else{
			cursor = head;
			while(cursor.getLink() != null && cursor.getLink().getData().compareTo(element) < 0) //while we arent going to run into a null and the element is greater then the cursor's data
				cursor = cursor.getLink(); //iterate through the list
			insert = new LinkedNode(element,cursor.getLink());
			cursor.setLink(insert);
			numNodes++;
		}
	}

	//returns the node before the largest node in the list
	public LinkedNode getLargestBefore(){ 
		LinkedNode cursor = head;
		if(head == null){
			return null;
		}
		LinkedNode largestNodeBefore = head;
		LinkedNode largestNode = head;
		while(cursor.getLink() != null){
			if(cursor.getLink().getData().compareTo(largestNodeBefore.getData()) >= 0){
				largestNodeBefore = cursor;
				largestNode = cursor.getLink();
			}
		cursor = cursor.getLink();
		}
		return largestNodeBefore;
	}

	//remove the largest node from the list
	public void removeLargest(){
		if(numNodes == 0){
			throw new IllegalStateException("Cannot remove from an empty list");
		}
		else if(numNodes ==1){
			head = null;
			numNodes--;
		}
		else{
			LinkedNode largestBefore = getLargestBefore();
			largestBefore.setLink(largestBefore.getLink().getLink());
			numNodes--;
		}
	}
	//linear search for a target
	public LinkedNode search(LinkedNode head, T target)
    {
      LinkedNode cursor;
     
      for (cursor = head; cursor != null; cursor = cursor.getLink())
         if (cursor.getData().compareTo(target) == 0)
            return cursor;
        
      return null;
  	}

	//Returns the list as a string seperated by spaces.
	public String toString(){
		String ret = "";
		LinkedNode cursor = head;
		while(cursor != null){
			ret+=cursor.getData().toString(); 
			ret+= "->";
			cursor = cursor.getLink();
		}
		return ret;
	}
	//get head
	public LinkedNode getHead(){
		return head;
	}
	//returns the number of nodes in the list
	public int size(){
		int ret = 0;
		LinkedNode cursor = head;
		while(cursor != null){
			ret++;
			cursor = cursor.getLink();
		}
		return ret;
	}
	//returns the list in array form
	//for compare()
	public Object[] items(){
		Object[] ret = new Object[size()];
		LinkedNode cursor = head;
		int i = 0;
		while(cursor != null){
			ret[i] = (Object)cursor.getData();
		}
		return ret;
	}
}