public class BagTestLoop{ 

	public static void main(String[] args){
			long start = 10000;
			BagTestLoop test = new BagTestLoop(); 
			for(int i = 0; i < 5; i++){
			System.out.println("IntArrayBag tests: "); //yes, this could have been done better then a wall of println(). but this is simple and easier to debug
			System.out.println("Part A: N =  " + start +"   " + test.arrayPartA(start)+ " ms"); 
			System.out.println("Part B: N =  " + start +"   " +test.arrayPartB(start)+ " ms");
			System.out.println("Part C: N =  " + start +"   " +test.arrayPartC(start)+ " ms");
			System.out.println("Part D: N =  " + start +"   " +test.arrayPartD(start)+ " ms");
			System.out.println();
			System.out.println("IntLinkedBag tests: ");
			System.out.println("Part A: N =  " + start +"   " +test.linkedPartA(start) + "ms");
			System.out.println("Part B: N = " + start +"   " +test.linkedPartB(start)+ "ms");
			System.out.println("Part C: N =  " + start +"   " +test.linkedPartC(start) + "ms");
			System.out.println("Part D: N =  " + start +"   " +test.linkedPartD(start) + "ms");
			start+=1000;
			}
			
	}
	public int arrayPartA(long N){
		long startTime, stopTime;
		IntArrayBag bag = new IntArrayBag(); // I create a new object every time for consistency. I have plenty of RAM. 
		startTime= System.currentTimeMillis();
		for(int i = 0; i <= N; i++){
			bag.add(i);
		}
		stopTime= System.currentTimeMillis();
		return (int)(stopTime-startTime);
	}
	public int arrayPartB(long N){
		long startTime,stopTime;
		IntArrayBag bag = new IntArrayBag();
		for(int i = 0; i <= N; i++){
			bag.add(i);
		}
		startTime= System.currentTimeMillis();
		for(long i = N; i >= 0; i--){ //thanks to prof. Fietkiewicz for finding the bug here (I used getCapacity() instead of N.)
			bag.remove((int)i);
		}
		stopTime= System.currentTimeMillis();
		return (int) (stopTime-startTime);
	}
	public int arrayPartC(long N){
		long startTime,stopTime;
		IntArrayBag bag = new IntArrayBag();
		for(int i = 0; i <= N; i++){
			bag.add(i);
		}
		int tmp = 0;
		startTime= System.currentTimeMillis();
		for(int i = 0; i <= N; i++){ 
			tmp = bag.countOccurrences(i);
		}
		stopTime= System.currentTimeMillis();
		return (int)(stopTime-startTime);
	}
	public int arrayPartD(long N){
		long startTime,stopTime;
		IntArrayBag bag = new IntArrayBag();
		startTime= System.currentTimeMillis();
		for(int i = 0; i <= N; i++){
			bag.add(0);
		}
		stopTime= System.currentTimeMillis();
		return (int)(stopTime-startTime);
	}
	public int linkedPartA(long N){
		long startTime,stopTime;
		IntLinkedBag bag = new IntLinkedBag();
		startTime = System.currentTimeMillis();
		for(int i = 0; i <= N; i++){
			bag.add(i);
		}
		stopTime = System.currentTimeMillis();
		return(int)(stopTime-startTime);
	}
	public int linkedPartB(long N){
		long startTime,stopTime;
		IntLinkedBag bag = new IntLinkedBag();
		for(int i = 0; i <= N; i++){ //I should have made an add to n function
			bag.add(i);
		}
		startTime = System.currentTimeMillis();
		bag.remove(1); //removes head
		for(int i = bag.size(); i > 1 ;i--){
			bag.remove(i);
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
	}
	public int linkedPartC(long N){
		long startTime,stopTime;
		IntLinkedBag bag = new IntLinkedBag();
		for(int i = 0; i <= N; i++){ 
			bag.add(i);
		}
		int tmp = 0;
		startTime = System.currentTimeMillis();
		for(int i = 0; i<=N; i++){
			tmp = bag.countOccurrences(i);
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
	}
	public int linkedPartD(long N){
		long startTime,stopTime;
		IntLinkedBag bag = new IntLinkedBag();
		startTime = System.currentTimeMillis();
		for(int i = 0; i <= N; i++){
			bag.add(0);
		}
		stopTime = System.currentTimeMillis();
		return(int)(stopTime-startTime);
	}
} //end class