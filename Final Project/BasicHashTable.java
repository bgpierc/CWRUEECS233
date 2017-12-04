//Ben Pierce (bgp12)
//Basically copied from HW8. There's not really changes I need to make on HashTable
public class BasicHashTable<T extends Comparable<T>>{
   private int manyItems;
   private Object[ ] keys;
   private Object[ ] data;
   private boolean[ ] hasBeenUsed;   

   public BasicHashTable(int capacity)
   {
      if (capacity <= 0)
         throw new IllegalArgumentException("Capacity is negative");
      keys = new Object[capacity];
      data = new Object[capacity];
      hasBeenUsed = new boolean[capacity];
   }
   
   public boolean containsKey(Object key)
   {
      return findIndex(key) != -1;
   }
   
   
   private int findIndex(Object key)
   // Postcondition: If the specified key is found in the table, then the return
   // value is the index of the specified key. Otherwise, the return value is -1.
   {
      int count = 0;
      int i = hash(key);

      System.out.println("Trying index [" + i + "]");
      while (count < data.length && hasBeenUsed[i])
      {
         if (key.equals(keys[i]))
            return i;
         count++;
         i = nextIndex(i);
         System.out.println("Trying index [" + i + "]");
      }
      
      return -1;
   }
      
   public Object get(Object key)
   {
      int index = findIndex(key);
      
      if (index == -1)
         return null;
      else
         return data[index];
   }
   
   
   private int hash(Object key)
   // The return value is a valid index of the table’s arrays. The index is
   // calculated as the remainder when the absolute value of the key’s
   // hash code is divided by the size of the table’s arrays.
   {
      return Math.abs(key.hashCode( )) % data.length;
   }
   
   
   private int nextIndex(int i)
   // The return value is normally i+1. But if i+1 is data.length, then the 
   // return value is zero instead.
   {
      if (i+1 == data.length)
         return 0;
      else
         return i+1;
   }
   
   public Object put(T key1, T element1)
   {
      Object key = (Object)key1; //convert b/w generics and objects
      Object element = (Object)element1;

      int index = findIndex(key);
      Object answer;
      
      if (index != -1)
      {  // The key is already in the table.
         answer = data[index];
         data[index] = element;
         return answer;
      }
      else if (manyItems < data.length)
      {  // The key is not yet in this Table.
         index = hash(key);
         while (keys[index] != null)
            index = nextIndex(index);
         keys[index] = key;
         data[index] = element;
         hasBeenUsed[index] = true;
         manyItems++;
         return null;
      }
      else
      {  // The table is full.
         throw new IllegalStateException("Table is full.");
      }
   }
      
   public Object remove(T key1)
   {
   	  Object key = (Object)key1;
      int index = findIndex(key);
      Object answer = null;
      
      if (index != -1)
      {
         answer = data[index];
         keys[index] = null;
         data[index] = null;
         manyItems--;
      }
      
      return answer;
   }

   public Object remove(int index){
   	 Object ret = data[index];
   	 keys[index] = null;
   	 data[index] = null;
   	 manyItems--;
   	 return ret;
   }

   public Object removeLargest(){
   		return remove(getLargest());
   }

   public int getLargest(){
    	T largest = (T)data[0];
    	int largestIndex = 0;
    	for(int i = 0; i <= data.length-1; i++){
    		if(largest.compareTo((T)data[i]) < 0){
    			largest = (T) data[i];
    			largestIndex=i;
    		}
    	}
    	return largestIndex;
    }

	public void print() {
		for (int i = 0; i < keys.length; i++)
			System.out.print("[" + i + "] ");
		System.out.println();
		for (int i = 0; i < keys.length; i++)
			System.out.print(keys[i] + " ");
		System.out.println();
	}
	public int search(T target){
		for(int i = 0; i < data.length -1; i++){
			if(target.compareTo((T)data[i])==0){
				return i;
			}
		}
	return -1;
	}
	public int size(){
		return manyItems;
	}
	public Object[] items(){
		Object[] ret = new Object[manyItems];
		int j = 0;
		for(int i = 0; i < data.length-1;i++){
			if(data[i] != null){
				ret[j] = data[i];
				j++;
			}
		}
		return ret;
	}
}	