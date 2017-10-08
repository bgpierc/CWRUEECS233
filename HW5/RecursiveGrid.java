//Ben Pierce (bgp12)
import java.util.*;
public class RecursiveGrid{
	public static void main(String[] args){
		navigate();
	}
	public static void navigate(){
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter a direction for a step (s=straight, l=left, r=right, q=quit): ");
		String input =  sc.nextLine();
		if(input.equals("q")){
			System.out.println("Turn 180 degrees");
		}
		else{
			navigate();
			if(input.equals("l"))
				System.out.println("Take a step and turn right");
			else if(input.equals("r"))
				System.out.println("Take a step and turn left");
			else if(input.equals("s"))
				System.out.println("Take a step and remain straight");
		}
	}
}