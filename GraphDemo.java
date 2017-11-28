// Chris Fietkiewicz
public class GraphDemo {
	public static void main(String[ ] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.setLabel(0, "Home");
		g.setLabel(1, "1st base");
		g.setLabel(2, "2nd base");
		g.setLabel(3, "3rd base");
		Graph.depthFirstPrint(g, 0);
	}
}


