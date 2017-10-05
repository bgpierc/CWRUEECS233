//Ben Pierce (bgp12)


public class Permutation{
	public int[] trait;    // Trait values for all persons
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

	private void addOne() { //there are better ways to do this. but this one works
		boolean carry = true;
		if(trait[trait.length-1] < maxValue){
			trait[trait.length-1] += 1;
			carry = false;
		}
		int i=trait.length-1;
		while(carry == true){
			if(trait[i] == maxValue){
				trait[i] = 1;
				carry = true;
			}
			else if(trait[i] < maxValue){
				trait[i] += 1;
				carry = false;
			}
			if(i == 0){
				carry = false;
			}
			i--;
		}
	}
	
	private boolean notEqual() {
		for(int i = 0; i< trait.length-1; i++){ 
			for(int k = i+1; k< trait.length; k++){ //it only took me twenty minutes of debugging to realize that I forgot to offset k by one.Now it returns things other then false!
				if(trait[i] == trait[k])
					return false;
			}
		}
		return true;
	}
    public static void main(String[] args) {
		//Permutation p = new Permutation(5, 5);

		//for (int i = 0; i < 120; i++) { //24 = 4!
		//	p.permute();
		//	p.printTraits();
		
	
	}
}
