public class BagTest{ //yes I realize that it might 
	public static void main(String[] args){
		IntArrayBagTest test = new IntArrayBagTest();
		System.out.println(test.partA(10000000)+ "ms");
		System.out.println(test.partB(100000)+ "ms");
		System.out.println(test.partC(100000)+ "ms");
	}
	public int partA(long N){
		long startTime, stopTime;
		IntArrayBag bag = new IntArrayBag(); // I create a new object every time for consistency
		startTime= System.currentTimeMillis();
		for(int i = 0; i <= N; i++){
			bag.add(i);
		}
		stopTime= System.currentTimeMillis();
		return (int)(stopTime-startTime);
	}
	public int partB(long N){
		long startTime,stopTime;
		IntArrayBag bag = new IntArrayBag();
		for(int i = 0; i <= N; i++){
			bag.add(i);
		}
		startTime= System.currentTimeMillis();
		for(long i = bag.getCapacity(); i > 0; i--){
			bag.remove((int)i);
		}
		stopTime= System.currentTimeMillis();
		return (int) (stopTime-startTime);
	}
	public int partC(long N){
		long startTime,stopTime;
		IntArrayBag bag = new IntArrayBag();
		for(int i = 0; i <= N; i++){
			bag.add(i);
		}
		startTime= System.currentTimeMillis();
		for(int j = 0; j<=N ;j++){
			bag.remove(j);
		}
		stopTime= System.currentTimeMillis();
		return (int)(stopTime-startTime);
	}
	public int partD()
}