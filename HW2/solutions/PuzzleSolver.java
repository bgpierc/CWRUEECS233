// Chris Fietkiewicz (cxf47) Solves word puzzle using Permutation.java
public class PuzzleSolver {
    public static void main(String[] args) {
		int numPersons = 5;
		int maxValue = 5;
		Permutation food = new Permutation(numPersons, maxValue);
		int P = 5 * 4 * 3 * 2 * 1;
		for (int pFood = 0; pFood < P; pFood++) {
			Permutation fear = new Permutation(numPersons, maxValue);
			for (int pFear = 0; pFear < P; pFear++) {
				// For clue #1
				boolean clue1 = food.getTrait(1) != 5 && food.getTrait(2) != 5;
				// For clue #2
				int spiders = fear.getPerson(1);
				boolean clue2 = spiders == 1 && food.getTrait(1) == 2 || spiders == 2 && food.getTrait(2) == 2 || spiders == 3 && food.getTrait(3) == 2 || spiders == 4 && food.getTrait(4) == 2 || spiders == 5 && food.getTrait(5) == 2;
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
					System.out.print("Food: ");
					food.printTraits();
					System.out.print("Fear: ");
					fear.printTraits();
				}
				fear.permute();
			}
			food.permute();
		}
    }
}
