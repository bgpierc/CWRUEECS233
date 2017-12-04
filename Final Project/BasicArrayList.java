//Ben Pierce (bgp12)
public class BasicArrayList<T extends Comparable<T>>{
	private Object[] data;
	private int upperIndex; //index that contains the last element

	public BasicArrayList(int size){
		data = new Object[size];
		upperIndex = 0;
	}
	//gets the item at the specified index
	public T get(int index){
		T t = (T) data[index]; //weak typing, results in unchecked warnings. We ignore those. 
		return t;
	}
	public int size(){
		return upperIndex+1;
	}
	//sets a specific index to a value without increasing the number of elements
	public void set(int index, T element){
		if(index > upperIndex){
			throw new ArrayIndexOutOfBoundsException("Index is not in the array");
		}
		data[index] = (Object) element;
	}
	//adds to the end
	public void add(T element){
		if(data.length >= upperIndex)
			ensureCapacity((upperIndex+1)*2);
		data[upperIndex] = (Object) element;
		upperIndex++;
	}
	//adds an element in a way that maintains the L->G order
	public void addInOrder(T element){
	  ensureCapacity(upperIndex*2);
	  int i;
      for(i=0;i<upperIndex;i++){
        if(element.compareTo((T)data[i]) < 0 || data[i] == null)
          break; // yeah yeah dont use break sorry
      }
      for(int k=upperIndex-1; k>=i; k--){
        data[k+1]=data[k];            
      }
      data[i]=(Object)element;
	  upperIndex++;
	}
	public void ensureCapacity(int minimumCapacity)
    {
      Object[ ] biggerArray;
      
      if (data.length < minimumCapacity)
      {
         biggerArray = new Object[minimumCapacity+1];
         System.arraycopy(data, 0, biggerArray, 0, upperIndex);
         data = biggerArray;
      }
    }
    public int getLargest(){
    	T largest = (T)data[0];
    	int largestIndex = 0;
    	for(int i = 0; i <= upperIndex-1; i++){
    		if(largest.compareTo((T)data[i]) < 0){
    			largest = (T) data[i];
    			largestIndex=i;
    		}
    	}
    	return largestIndex;
    }
    public void removeLargest(){
    	int largestIndex = getLargest();
    	for(int i = largestIndex; i < upperIndex;i++){
    		data[i] = data[i+1];
    	}
    	upperIndex--;
    }

    public int search(T target){
    	for(int i = 0; i < upperIndex; i++){
    		if(target.compareTo((T)data[i])==0){
    			return i;
    		}
    	}
    	return -1;
    }
	//prints the list
	public void print(){
		for(Object i: data){
			if(i != null)
				System.out.print(i.toString() + " ");
		}
		// for(int i = 0; i < upperIndex-1; i++){
		// 	System.out.print(data[i].toString()+ " ");
		// }
	}
	public Object[] items(){
		Object[] ret = new Object[upperIndex];
		for(int i = 0; i < upperIndex; i++){
			ret[i] = data[i];
		}
		return ret;
	}
}