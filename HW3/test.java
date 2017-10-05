public class test{
	
	public static void main(String[] args){
		int[] arr = new int[4];
		System.out.println(arr);
		System.out.println("sum=" + sum(arr));
	}
	public int sum(int[] array){
		int sum = 0;
			if (array.length == 0){
			return 0;
		}
		for(int i = 0; i < array.length -1; i++){
			sum += array[i];
		}
		return sum;
}
}