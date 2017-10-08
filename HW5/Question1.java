import java.util.*;
public class Question1{ 
	public Queue<String> names = new LinkedList<String>();
	public Queue<Integer> times = new LinkedList<Integer>();
	public int currentTime =0;
	public String currentPerson = "";
	public static void main(String[] args){
		Question1 q1 = new Question1();
		q1.run();
	}

	public boolean query(){ 
		Scanner sc = new Scanner(System.in);
		String input = ""; 
		System.out.print("Enter name (or 'quit'): ");
		input = sc.next();
		if(input.equals("q")){
			return false;
		}
		currentPerson = input;
		System.out.print("Enter current time ");
		currentTime = sc.nextInt();
		names.add(currentPerson);
		times.add(currentTime+100);	
		return true;
	}


	public boolean track(){
		if(query() == false){
			return false;
		}
		if(times.size() == 1){
			System.out.println(currentPerson + " can have it now");
		}
		else if(times.peek() >= currentTime){
			System.out.println(names.remove() + " is done");
			times.remove();
		}
		else if(times.peek() <= currentTime){
			System.out.println(currentPerson +" can have it at " + times.peek());
		}
		return true;
	}
	public void run(){
		while (true){

			if(track() == false){
				return;
			}
			System.out.println("1");
		}
	}
}