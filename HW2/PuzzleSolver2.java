/* Chris Fietkiewicz (cxf47) Solves word puzzle with 2 traits
	Items are identified by number (1, 2, 3, 4, 5).
	To match the ID numbers with the puzzle description (see notes):
        String[] name = {"Bert", "Bart", "Betty", "Bertha", "Beverly"};
        String[] food = {"bananas", "strawberries", "pizza", "sushi", "donuts"};
        String[] fear = {"spiders", "snakes", "heights", "enclosed spaces", "public speaking"};
	Note: The Strings shown above are NOT used in the program. They are
	provided for reference and possibly interested students who wish to
	print out the text instead of just the ID numbers.
*/

public class PuzzleSolver2 {
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

	private static boolean notEqual(int a, int b, int c, int d, int e) {
		boolean compare1 = a != b && a != c && a != d && a != e;
		boolean compare2 = b != a && b != c && b != d && b != e;
		boolean compare3 = c != a && c != b && c != d && c != e;
		boolean compare4 = d != a && d != b && d != c && d != e;
		boolean compare5 = e != a && e != b && e != c && e != d;
		return compare1 && compare2 && compare3 && compare4 && compare5;
	}

    public static void main(String[] args) {
		for (int food1 = 1; food1 <= 5; food1++) {
		for (int food2 = 1; food2 <= 5; food2++) {
		for (int food3 = 1; food3 <= 5; food3++) {
		for (int food4 = 1; food4 <= 5; food4++) {
		for (int food5 = 1; food5 <= 5; food5++) {
			for (int fear1 = 1; fear1 <= 5; fear1++) {
			for (int fear2 = 1; fear2 <= 5; fear2++) {
			for (int fear3 = 1; fear3 <= 5; fear3++) {
			for (int fear4 = 1; fear4 <= 5; fear4++) {
			for (int fear5 = 1; fear5 <= 5; fear5++) {
				boolean choose1 = notEqual(food1, food2, food3, food4, food5);
				boolean choose2 = notEqual(fear1, fear2, fear3, fear4, fear5);
				boolean uniqueCombo = choose1 && choose2;
				// For clue #1
				boolean clue1 = food1 != 5 && food2 != 5;
				// For clue #2
				int spiders = getPerson(1, fear1, fear2, fear3, fear4, fear5);
				boolean clue2 = spiders == 1 && food1 == 2 || spiders == 2 && food2 == 2 || spiders == 3 && food3 == 2 || spiders == 4 && food4 == 2 || spiders == 5 && food5 == 2;
				// For clue #3
				int enclosed = getPerson(4, fear1, fear2, fear3, fear4, fear5);
				boolean clue3 = enclosed == 1 && food1 == 5 || enclosed == 5 && food2 == 5 || enclosed == 3 && food3 == 5 || enclosed == 4 && food4 == 5 || enclosed == 5 && food5 == 5;
				// For clue #4
				boolean clue4 = fear4 != 4 && food5 != 5;
				// For clue #5
				boolean clue5 = fear4 != 2 && fear4 != 5 && fear5 != 2 && fear5 != 5;
				// For clue #6
				int banana = getPerson(1, food1, food2, food3, food4, food5);
				boolean clue6 = (banana == 1 && fear1 == 2 || banana == 2 && fear2 == 2 || banana == 3 && fear3 == 2 || banana == 4 && fear4 == 2 || banana == 5 && fear5 == 2) && fear5 != 3;
				// For clue #7
				boolean clue7 = fear2 != 5 && food4 != 3;
				// Check all clues
				if (uniqueCombo && clue1 && clue2 && clue3 && clue4 && clue5 && clue6 && clue7) {
					printPerson("food", food1, food2, food3, food4, food5);
					printPerson("fear", fear1, fear2, fear3, fear4, fear5);
				}
			}
			}
			}
			}
			}
		}
		}
		}
		}
		}
    }
}
