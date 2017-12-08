import java.util.*;
public class Test{
	public static void main(String[] args){
		Random rand = new Random();
		DynamicList<Integer> list = new DynamicList(20);
		list.setState(1);
		list.add(5,1);
		list.add(15,1);
		list.add(6,1);
		list.add(4,1);
		list.add(10,1);
		list.print();
		list.setState(2);
		list.print();
		System.out.println("Remove largest");
		list.removeLargest();
		list.removeLargest();
		list.removeLargest();
		list.removeLargest();
		list.removeLargest();

		list.print();

		// list.setState(0);
		// list.print();
		// for(int i = 0; i < 50; i++){
		// 	list.addInPlace((Integer) (rand.nextInt(500)+1),i);
		// }
		// list.print();
		// list.setState(1);
		// list.print();
	}


}