// Chris Fietkiewicz. Based on Table.java from www.cs.colorado.edu/~main
public class Table2
{
   private int manyItems;
   private Object[ ] keys;
   private Object[ ] data;
   private boolean[ ] hasBeenUsed;   

   public Table2(int capacity)
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
   
   public Object put(Object key, Object element)
   {
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
      
   public Object remove(Object key)
   {
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

	public void print() {
		for (int i = 0; i < keys.length; i++)
			System.out.print("[" + i + "]\t");
		System.out.println();
		for (int i = 0; i < keys.length; i++)
			System.out.print(keys[i] + "\t");
		System.out.println();
	}

	public static void main(String[] args) {
		Table2 t = new Table2(13);
		t.put(1, "X");
		t.put(2, "X");
		t.put(12, "X");
		t.put(13, "X");
		t.put(14, "X");
		t.put(130, "X");
		t.put(1312, "X");
		t.put(1301, "X");
		t.put(1300, "X");
		t.print();
	}
}
           
