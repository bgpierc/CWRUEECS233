//Ben Pierce (bgp12)
public class PermutationTest{
	public static void main(String[] args){
		PermutationTest test = new PermutationTest();
		test.Letter_D();
		test.Letter_C();
	}
	private long numLoops(long size){ //calculates the factorial
		long result = 1;
		for(int i = 1; i <= size; i++){
			result = result*i;
		}
		return result;
	}
	private int Permutalyzer(int numPersons, int maxValue){ //a portmanteau of "Permute" and "analyzer". I wish this naming convention would catch on
		long startTime,stopTime;
		Permutation food = new Permutation(numPersons,maxValue);
		Permutation fear = new Permutation(numPersons,maxValue);
		startTime = System.currentTimeMillis();
		for(long i = 0; i < numLoops(maxValue); i++){
			fear.permute();
			for(int j = 0; j < numLoops(maxValue); j++){			
			food.permute();
			}
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
	}

	public void Letter_C(){
		System.out.println("Letter C");
		for(int i = 3; i <8; i++){
			System.out.println("Number of People: " + i +" Number of Traits: 7" + " Time: " + Permutalyzer(i,7) + "ms"); 
		}
	}

	public void Letter_D(){
		System.out.println("Letter D");
		for(int i = 5; i<=8;i++){
			System.out.println("Number of People: 5"  +" Number of Traits: " + i + " Time: " + Permutalyzer(5,i) + "ms"); 
		}
	}
	public PermutationTest(){

	}
}