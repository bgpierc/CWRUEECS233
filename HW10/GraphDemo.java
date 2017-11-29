// Ben Pierce
public class GraphDemo {
	public static void main(String[ ] args) {
		Graph g = new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(2, 0);
		g.addEdge(1, 3);
		g.addEdge(3,6);
		g.addEdge(3,5);
		g.addEdge(3,0);
		g.addEdge(6,1);
		for(int i = 0; i < 7; i++){
			g.setLabel(i, "v" + (Integer)i); 
		}
		//Graph.depthFirstPrint(g, 0);
		System.out.println();
		Graph.breadthFirstSearch(g,0);
	}
}


