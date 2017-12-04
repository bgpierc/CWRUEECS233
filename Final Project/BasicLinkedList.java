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
	//adds after a given node
	public void addAfter(LinkedNode current, T element){
	 	if(element == null)
	 		throw new NullPointerException("Element cannot be null");
	 	if(current == null){// there's no head
	 		append(element);
	 		return;
	 	}
	 	current.setLink(new LinkedNode(element, current.getLink()));
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
	}
	//adds a bunch of elements to the end
	public void addAll(T...elements){
		for(T t:elements){
			append(t);
		}
	}
	//adds an element to maintain a L->G sorted list
	public void addInOrder(T element){

		if (element == null)
			throw new NullPointerException("NULL");

		LinkedNode cursor = head;
		while(cursor != null && cursor.getData().compareTo(element) >0){
			cursor = cursor.getLink();

		}

		addAfter(cursor,element);
	}
	public void addInOrder2(T element){
		if (element == null)
			throw new NullPointerException("NULL");
		LinkedNode cursor = head;
		if(head == null || head.getData().compareTo(element) > 0){
			head = new LinkedNode(element,head);
		}
	}
	//returns the largest node in the list
	public LinkedNode getLargest(){ 
		LinkedNode cursor = head;
		LinkedNode before = null;
		Comparable<T> largest = cursor.getData();
		while(cursor.getLink() != null){
			if(cursor.getData().compareTo(largest) < 0)
				largest = cursor.getData(); 
		before = cursor;
		cursor = cursor.getLink();
		}
		return before;
	}
	//removes a node from the list.
	public void remove(LinkedNode node){
		if(node == null){ //no
			throw new NullPointerException("Cannot remove a null value");
		}
		if(node.getLink() == null){ //at the end
			node = null;
			return;
		}
		else
			getBefore(node).setLink(node.getLink()); //else remove from middle
	}
	//get the node before the given node
	public LinkedNode getBefore(LinkedNode node){
		LinkedNode cursor = head;
		while(cursor.getLink() != null){
			if(cursor.getLink() == node)
				return cursor;
		}
		return null;
	}
	//remove the largest node from the list
	public LinkedNode removeLargest(){
		LinkedNode largest = getLargest();
		remove(largest);
		return largest;
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
	public int size(){
		int ret = 0;
		LinkedNode cursor = head;
		while(cursor != null){
			ret++;
			cursor = cursor.getLink();
		}
		return ret;
	}
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