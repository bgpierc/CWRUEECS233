// Chris Fietkiewicz (cxf47) Iterates through permutations
public class Permutation {
	private int[] trait; // Trait values for all persons
	private int numPersons; // Total number of persons
	private int maxValue; // Maximum value for a trait (starting at 1)

	public Permutation(int numPersons, int maxValue) {
		if (numPersons > maxValue) {
			numPersons = maxValue;
			throw new IllegalArgumentException("Number of persons must be less than or equal to maximum value. Reduced number of persons to " + numPersons + ".");
		}
		this.numPersons = numPersons;
		this.maxValue = maxValue;
		trait = new int[numPersons];
		for (int i = 0; i < numPersons; i++)
			trait[i] = i + 1;
	}

	public void permute() {
		addOne();
		while (!notEqual())
			addOne();
	}

	private void addOne() {
		boolean carry = true;
		int i = numPersons - 1;
		while (carry == true && i >= 0) {
			trait[i]++; // addOne to next possible digit
			if (trait[i] > maxValue) { // If max digit is exceded
				trait[i] = 1; // Roll over to 1
				i--; // Move to next highest digit
			}
			else
				carry = false; // No carry needed
		}

	}

	public int getTrait(int iPerson) {
		if (0 < iPerson && iPerson <= numPersons)
			return trait[iPerson - 1];
		else
			return 0;
	}

	public int getPerson(int target) {
		int i = 0;
		while (i < numPersons && trait[i] != target)
			i++;
		if (i < numPersons)
			return i + 1;
		else
			return 0;
	}

	public void printTraits() {
		for (int i = 0; i < numPersons - 1; i++)
			System.out.print(trait[i] + ", ");
		System.out.println(trait[numPersons - 1]);
	}

	private boolean notEqual() {
		for (int i = 0; i < numPersons; i++)
			for (int j = 0; j < numPersons; j++)
				if (i != j && trait[i] == trait[j])
					return false;
		return true;
	}

    public static void main(String[] args) {
		Permutation p = new Permutation(3, 4);
		for (int i = 0; i < 10; i++) {
			p.printTraits();
			p.permute();
		}
	}
}