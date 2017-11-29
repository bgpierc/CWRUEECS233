//Ben Pierce (bgp12)
import java.util.*;
public class Graph implements Cloneable
{
   // Invariant of the Graph class:
   //   1. The vertex numbers range from 0 to labels.length-1.
   //   2. For each vertex number i, labels[i] contains the label for vertex i.
   //   3. For any two vertices i and j, edges[i][j] is true if there is a
   //      vertex from i to j; otherwise edges[i][j] is false.  
   private boolean[ ][ ] edges;
   private Object[ ] labels;
   

   /**
   * Initialize a <CODE>Graph</CODE> with <CODE>n</CODE> vertices,
   * no edges, and null labels.
   * @param n
   *   the number of vertices for this <CODE>Graph</CODE>
   * <b>Precondition:</b>
   *   <CODE>n</CODE> is nonnegative.
   * <b>Postcondition:</b>
   *   This <CODE>Graph</CODE> has <CODE>n</CODE> vertices, numbered 
   *   <CODE>0</CODE> to <CODE>n-1</CODE>. It has no edges and all
   *   vertex labels are null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the specified number of nodes.
   * @exception NegativeArraySizeException
   *   Indicates that <CODE>n</CODE> is negative. 
   **/   
   public Graph(int n)
   {
      edges = new boolean[n][n];  // All values initially false
      labels = new Object[n];     // All values initially null
   }
   
   
   /**
   * Add a new edge to this <CODE>Graph</CODE>.
   * @param source
   *   the vertex number of the source of the new edge
   * @param target
   *   the vertex number of the target of the new edge
   * <b>Precondition:</b>
   *   Both <CODE>source</CODE> and <CODE>target</CODE> are nonnegative and
   *   less than <CODE>size()</CODE>.
   * <b>Postcondition:</b>
   *   This <CODE>Graph</CODE> has all the edges that it originally had plus
   *   another edge from the specified <CODE>source</CODE> to the specified
   *   <CODE>target</CODE>. (If the edge was already present, then this
   *   <CODE>Graph</CODE> is unchanged.)
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that the <CODE>source</CODE> or <CODE>target</CODE> was not a
   *   valid vertex number.
   **/
   public void addEdge(int source, int target)   
   {
      edges[source][target] = true;
   }
   
      
   /**
   * Generate a copy of this <CODE>Graph</CODE>.
   * @return
   *   The return value is a copy of this <CODE>Graph</CODE>. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be type cast to a <CODE>Graph</CODE> before it can be used.
   * @throws OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public Object clone( )
   {  // Clone a Graph object.
      Graph answer;
      
      try
      {
         answer = (Graph) super.clone( );
      }
      catch (CloneNotSupportedException e)
      {  // This would indicate an internal error in the Java runtime system
         // because super.clone always works for an Object.
         throw new InternalError(e.toString( ));
      }
      
      answer.edges = (boolean [ ][ ]) edges.clone( );
      answer.labels = (Object [ ]) labels.clone( );
      
      return answer;
   }
   

   /**
   * Static method to print the labels of a graph with a depth-first search.
   * @param g
   *   a nonnull <CODE>Graph</CODE>
   * @param start
   *   a vertex number from the <CODE>Graph g</CODE>
   * <b>Precondition:</b>
   *   <CODE>start</CODE> is nonnegative and less than <CODE>g.size()</CODE>.
   * <b>Postcondition:</b>
   *   A depth-first search of <CODE>g</CODE> has been conducted, starting at
   *   the specified start vertex. Each vertex visited has its label printed 
   *   using <CODE>System.out.println</CODE>. Note that vertices that are not 
   *   connected to the start will not be visited.
   * @throws NullPointerException
   *   Indicates that <CODE>g</CODE> is null.
   * @throws ArrayIndexOutOfBoundsException
   *   Indicates that the vertex was not a valid vertex number.
   * @throws OutOfMemoryError
   *   Indicates that there is insufficient memory for an array of boolean values 
   *   used by this method.
   **/
   public static void depthFirstPrint(Graph g, int start)
   {
      boolean[ ] marked = new boolean [g.size( )];
      
      depthFirstRecurse(g, start, marked);
      
   }
   
   
   /**
   * Recursive method to carry out the work of <CODE>depthFirstPrint</CODE>.
   * @param g
   *   a nonnull <CODE>Graph</CODE>
   * @param v
   *   a vertex number from the <CODE>Graph g</CODE>
   * @param marked
   *   an array to indicate which vertices of <CODE>g</CODE> have already
   *   been visited
   * <b>Precondition:</b>
   *   <CODE>v</CODE> is nonnegative and less than <CODE>g.size()</CODE>.
   *   <CODE>marked.length</CODE> is equal to <CODE>g.size()</CODE>;
   *   for each vertex <CODE>x</CODE> of <CODE>g</CODE>, <CODE>marked[x]</CODE>
   *   is <CODE>true</CODE> if <CODE>x</CODE> has already been visited by this
   *   search; otherwise <CODE>marked[x]</CODE> is <CODE>false</CODE>.
   *   The vertex <CODE>v</CODE> is an unmarked vertex that the search has
   *   just arrived at.
   * <b>Postcondition:</b>
   *   The depth-first search of <CODE>g</CODE> has been continued through 
   *   vertex <CODE>v</CODE> and beyond to all vertices that can be reached
   *   from <CODE>v</CODE> via a path of unmarked vertices. Each vertex visited
   *   has its label printed using <CODE>System.out.println.</CODE> 
   * @throws NullPointerException
   *   Indicates that <CODE>g</CODE> is null.
   * @throws ArrayIndexOutOfBoundsException
   *   Indicates that the vertex was not a valid vertex number, or 
   *   <CODE>marked</CODE> was the wrong size. 
   **/
   public static void depthFirstRecurse(Graph g, int v, boolean[ ] marked)
   {
      int[ ] connections = g.neighbors(v);
      int i;
      int nextNeighbor;
      
      marked[v] = true;
      System.out.println(g.getLabel(v));
      
      // Traverse all the neighbors, looking for unmarked vertices:
      for (i = 0; i < connections.length; i++)
      {
         nextNeighbor = connections[i];
         if (!marked[nextNeighbor])
            depthFirstRecurse(g, nextNeighbor, marked);
      } 
   }
   
   public static void breadthFirstSearch(Graph g, int start){
      Queue<Integer> q = new LinkedList<>();
      boolean[ ] marked = new boolean [g.size( )];
      q.add(start);
      while(q.size()!=0){
         int tmp = q.remove();
         if(marked[tmp] == false){
            System.out.print(" " + g.getLabel(tmp) + " "); 
            int[] tmp2 = g.neighbors(tmp);
            for(int i: tmp2){
               q.add(i);
            }
            marked[tmp] = true;
         }
      }
   }
   
   /**
   * Accessor method to get the label of a vertex of this <CODE>Graph</CODE>. 
   * @param vertex
   *   a vertex number
   * <b>Precondition:</b>
   *   <CODE>vertex</CODE> is nonnegative and
   *   less than <CODE>size()</CODE>.
   * @return
   *   the label of the specified vertex in this <CODE>Graph</CODE>
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that the <CODE>vertex</CODE> was not a
   *   valid vertex number.
   **/
   public Object getLabel(int vertex)
   {
      return labels[vertex];
   }

 
   /**
   * Accessor method to determine whether this <CODE>Graph</CODE> contains
   * a specified edge.
   * @param source
   *   the vertex number of the source of the specified edge
   * @param target
   *   the vertex number of the target of the specified edge
   * <b>Precondition:</b>
   *   Both <CODE>source</CODE> and <CODE>target</CODE> are nonnegative and
   *   less than <CODE>size()</CODE>.
   * @return
   *   The return value is true if this <CODE>Graph</CODE> has an edge from the
   *   specified <CODE>source</CODE> to the specified <CODE>target</CODE>.
   *   Otherwise the return value is false.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that the <CODE>source</CODE> or <CODE>target</CODE> was not a
   *   valid vertex number.
   **/
   public boolean isEdge(int source, int target)
   {
      return edges[source][target];
   }

   /**
   * Accessor method to obtain a list of neighbors of a specified vertex of
   * this <CODE>Graph</CODE>
   * @param vertex
   *   a vertex number
   * <b>Precondition:</b>
   *   The value of <CODE>source</CODE> is nonnegative and
   *   less than <CODE>size()</CODE>.
   * <b>Precondition:</b>
   *   <CODE>vertex</CODE> is nonnegative and
   *   less than <CODE>size()</CODE>.
   * @return
   *   The return value is an array that contains all the vertex numbers of
   *   vertices that are targets for edges with a source at the specified
   *   <CODE>vertex</CODE>.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that the <CODE>source</CODE> or <CODE>target</CODE> was not a
   *   valid vertex number.
   **/
   public int[ ] neighbors(int vertex)
   {
      int i;
      int count;
      int[ ] answer;
      
      // First count how many edges have the vertex as their source
      count = 0;
      for (i = 0; i < labels.length; i++)
      {
         if (edges[vertex][i])
            count++;
      }
           
      // Allocate the array for the answer
      answer = new int[count];
      
      // Fill the array for the answer
      count = 0;
      for (i = 0; i < labels.length; i++)
      {
         if (edges[vertex][i])
            answer[count++] = i;
      }
      
      return answer;
   }
              
   
   /**
   * Remove an edge from this <CODE>Graph</CODE>.
   * @param source
   *   the vertex number of the source of the removed edge
   * @param target
   *   the vertex number of the target of the removed edge
   * <b>Precondition:</b>
   *   Both <CODE>source</CODE> and <CODE>target</CODE> are nonnegative and
   *   less than <CODE>size()</CODE>.
   * <b>Postcondition:</b>
   *   This <CODE>Graph</CODE> has all the edges that it originally had minus
   *   the edge from the specified <CODE>source</CODE> to the specified
   *   <CODE>target</CODE>. (If the edge was not present, then this
   *   <CODE>Graph</CODE> is unchanged.)
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that the <CODE>source</CODE> or <CODE>target</CODE> was not a
   *   valid vertex number.
   **/
   public void removeEdge(int source, int target)   
   {
      edges[source][target] = false;
   }
   
   
   /**
   * Modification method to change the label of a vertex of this <CODE>Graph</CODE>. 
   * @param vertex
   *   a vertex number
   * @param newLabel
   *   a new label (which may be null)
   * <b>Precondition:</b>
   *   <CODE>vertex</CODE> is nonnegative and
   *   less than <CODE>size()</CODE>.
   * <b>Postcondition:</b>
   *   The label of the specified vertex in this <CODE>Graph</CODE> has been
   *   changed to the <CODE>newLabel</CODE>.
   * @exception IndexOutOfBoundsException
   *   Indicates that the <CODE>vertex</CODE> was not a
   *   valid vertex number.
   **/
   public void setLabel(int vertex, Object newLabel)
   {
      labels[vertex] = newLabel;
   }   
   
   
   /**
   * Determine the number of vertices in this <CODE>Graph</CODE>.
   * @return
   *   the number of vertices in this <CODE>Graph</CODE>
   **/ 
   public int size( )
   {
      return labels.length;
   }


        
}
           
