import java.util.*;
public class Test{
	public static void main(String[] args){
		Random rand = new Random();
		DynamicList<Integer> list = new DynamicList(20);
		list.addInPlace(5,5);
		list.addInPlace(4,3);
		//list.print();
		list.setState(1);
		list.print();
		for(int i = 0; i < 5; i++){
			list.addInPlace((Integer) (rand.nextInt(500)+1),i);
		}
		list.print();
	}


}