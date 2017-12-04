import java.util.*;
public class Test{
	public static void main(String[] args){
		Random rand = new Random();
		DynamicList<Integer> list = new DynamicList(20);
		BasicArrayList<Integer> l = new BasicArrayList(20);
		list.setState(0);
		list.addInPlace(5,5);
		list.addInPlace(4,3);
		for(int i = 0; i < 50000; i++){
			list.addInPlace((Integer) (rand.nextInt(50000)+1),i);
		}
		list.print();
	}


}