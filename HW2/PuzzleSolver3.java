//Ben Pierce (bgp12)
public class PuzzleSolver3{
	public static void main(String[] args){
		Permutation food = new Permutation(5,5);
		Permutation fear = new Permutation(5,5);
		for(int i = 0; i <61; i++){
		food.permute();
		//food.printTraits();
		for(int j = 0; j < 61; j++){
		//fear.printTraits();
		fear.permute();
		//for clue #1
		boolean clue1 = food.getTrait(1) != 5 && food.getTrait(2) != 5;
		// For clue #2
		int spiders = fear.getPerson(1);
		boolean clue2 = spiders == 1 && food.getTrait(2) == 2 || spiders == 2 && food.getTrait(2) == 2 || spiders == 3 && food.getTrait(3) == 2 || spiders == 4 && food.getTrait(4) == 2 || spiders == 5 && food.getTrait(5) == 2;
		// For clue #3
		int enclosed = fear.getPerson(4);
		boolean clue3 = enclosed == 1 && food.getTrait(1) == 5 || enclosed == 5 && food.getTrait(2) == 5 || enclosed == 3 && food.getTrait(3) == 5 || enclosed == 4 && food.getTrait(4) == 5 || enclosed == 5 && food.getTrait(5) == 5;
		// For clue #4
		boolean clue4 = fear.getTrait(4) != 4 && food.getTrait(5) != 5;
		// For clue #5
		boolean clue5 = fear.getTrait(4) != 2 && fear.getTrait(4) != 5 && fear.getTrait(5) != 2 && fear.getTrait(5) != 5;
		// For clue #6
		int banana = food.getPerson(1);
		boolean clue6 = (banana == 1 && fear.getTrait(1) == 2 || banana == 2 && fear.getTrait(2) == 2 || banana == 3 && fear.getTrait(3) == 2 || banana == 4 && fear.getTrait(4) == 2 || banana == 5 && fear.getTrait(5) == 2) && fear.getTrait(5) != 3;
		// For clue #7
		boolean clue7 = fear.getTrait(2) != 5 && food.getTrait(4) != 3;
		// Check all clues
		if (clue1 && clue2 && clue3 && clue4 && clue5 && clue6 && clue7) {
			printPerson("food", food.getTrait(1), food.getTrait(2), food.getTrait(3), food.getTrait(4), food.getTrait(5));
			printPerson("fear", fear.getTrait(1), fear.getTrait(2), fear.getTrait(3), fear.getTrait(4), fear.getTrait(5));
		}
	}
}

}
	private static void printPerson(String category, int a, int b, int c, int d, int e) {
		System.out.println(category + ": " + a + ", " + b + ", " + c + ", " + d + ", " + e);
	}

	private static int getPerson(int target, int a, int b, int c, int d, int e) {
		if (target == a) return 1;
		if (target == b) return 2;
		if (target == c) return 3;
		if (target == d) return 4;
		if (target == e) return 5;
		return 0;
	}

}