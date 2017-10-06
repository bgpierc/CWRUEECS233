import java.util.*;
public class Question12{ 
	public static void main(String[] args){
		Question12 q1 = new Question12();
		q1.track();
	}

	public void track(){
		Queue<String> names = new LinkedList<String>();
		Queue<Integer> times = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		String input = ""; 
		int currentTime = 0;
		while(!input.equals("q") || !input.equals("quit")){
			System.out.print("Enter name (or 'quit'): ");
			input = sc.next();
			if(input.equals("q")){
				return;
			}
			System.out.print("Enter current time ");
			currentTime = sc.nextInt();
			if(times.size() == 0){
				System.out.println(input + " can have it now!");
				times.add(currentTime + 100);
				names.add(input);
			}
			else if(times.peek() > currentTime){
				System.out.println(input + " can have it at " + times.peek());
				times.add(times.peek() + 100);
				names.add(input);
			}
			else if(times.peek() <= currentTime){ 
				for(int i = 0; i < times.size(); i++){
					if(times.peek() <= currentTime){
					System.out.println(names.remove()+ " is done! ");
					times.remove();
					}
				}
				names.add(input);
				times.add(currentTime+100);
				if(times.peek() >= currentTime){	
					System.out.println(input + " can have it at " + times.peek());
					names.add(input);
					times.add(times.peek() + 100);
				}
				else
					System.out.println(input + " can have it now!");
				}
			}
		}
	}
