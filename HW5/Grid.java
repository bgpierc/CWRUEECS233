//Ben Pierce (bgp12)
import java.util.*;
public class Grid{
	
	Stack stack = new Stack();
	public static void main(String[] args){
		Grid g = new Grid();
		while(g.navigate());
	}

	public String getInput(){
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	public boolean navigate(){
		System.out.println("Enter a direction for a step (s=straight, l=left, r=right, q=quit): ");
		String token = getInput();
		stack.push(token);
		if(token.equals("q")){
			stack.pop();
			System.out.println("Turn 180 degrees");
			while(!stack.empty()){
				if(stack.peek().equals("l")){
					System.out.println("Take a step and turn right");
					stack.pop();
				}
				else if(stack.peek().equals("r")){
					System.out.println("Take a step and turn left");
					stack.pop();
				}
				else if(stack.peek().equals("s")){
					System.out.println("Take a step and remain straight");
					stack.pop();
				}
				else
					throw new IllegalArgumentException("Your input was invalid");
			}
			System.out.println("You have arrived where you started!");
			return false;
		}
		return true;
	}

}
