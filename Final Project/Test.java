import java.util.*;
public class Test{
	public static void main(String[] args){
		Random rand = new Random();
		DynamicList<Integer> list = new DynamicList(20);
		list.setState(0);
		list.addInPlace(5,1);
		list.addInPlace(4,1);
		list.addInPlace(6,1);
		list.addInPlace(15,1);
		list.addInPlace(10,1);
		list.print();
		list.setState(2);
		list.print();
		//list.setState(0);
		list.setState(1);
		list.print();
		for(int i = 0; i < 5000000; i++){
			list.addInPlace((Integer) (rand.nextInt(500)+1),i);
		}
		//list.print();
		//list.setState(0);
		//list.print();
	}


}