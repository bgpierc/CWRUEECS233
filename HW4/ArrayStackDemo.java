// Chris Fietkiewicz (cxf47) Demonstrates classes ArrayStack
public class ArrayStackDemo {
    public static void main(String[] args) {
		ArrayStack array = new ArrayStack<Integer>();
		array.push(10);
		array.push(20);
		array.push(30);
		array.print();
		// System.out.println(array.peek());
		// System.out.println(array.pop());
		// System.out.println(array.pop());
		// System.out.println(array.pop());
		// System.out.println(array.pop()); // Generates exception
	}
}
