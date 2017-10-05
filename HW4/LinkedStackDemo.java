// Chris Fietkiewicz (cxf47) Demonstrates classes LinkedStack
public class LinkedStackDemo {
    public static void main(String[] args) {
		LinkedStack linked = new LinkedStack<Integer>();
		linked.push(10);
		linked.push(20);
		linked.push(30);
		linked.print();
		// System.out.println(linked.peek());
		// System.out.println(linked.pop());
		// System.out.println(linked.pop());
		// System.out.println(linked.pop());
		// System.out.println(linked.pop()); // Generates exception
	}
}
