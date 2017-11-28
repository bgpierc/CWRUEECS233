// Chris Fietkiewicz
public class CheckPath {
	public static void main(String[ ] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);

		int[] p1 = {1, 2, 3};
		if (checkPath(g, p1))
			System.out.println("1st path IS valid");
		else
			System.out.println("1st path is NOT valid");

		int[] p2 = {0, 2, 3};
		if (checkPath(g, p2))
			System.out.println("2nd path IS valid");
		else
			System.out.println("2nd path is NOT valid");
	}

	public static boolean checkPath(Graph g, int[] path) {
		for (int i = 0; i < path.length - 1; i++)
			if (!g.isEdge(path[i], path[i + 1]))
				return false;
		return true;
	}
}


