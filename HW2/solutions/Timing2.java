// Fix numPersons
// Chris Fietkiewicz (cxf47) Timing test to compare Permutation.java
public class Timing2 {
    public static void main(String[] args) {
        long startTime, stopTime; // For recording start/stop times
		int numPersons = 5;
		for (int maxValue = 5; maxValue <= 8; maxValue++) {
			int P = 1;
			for (int n = maxValue; n > (maxValue - numPersons); n--)
				P = P * n;
			startTime = System.currentTimeMillis();
			Permutation food = new Permutation(numPersons, maxValue);
			for (int pFood = 0; pFood < P; pFood++) {
				Permutation fear = new Permutation(numPersons, maxValue);
				for (int pFear = 0; pFear < P; pFear++) {
					fear.permute();
				}
				food.permute();
			}
			stopTime = System.currentTimeMillis();
			System.out.println("maxValue = " + maxValue + ", P = " + P + ", time = " + (stopTime - startTime) + " msec");
		}
    }
}
