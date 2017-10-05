//Ben Pierce (bgp12)
import java.util.Stack;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Postfix{
	public static void main(String[] args){
		Postfix what = new Postfix();
		System.out.println(what.evaulate("6 5 2 3 + 8 * + 3 + *"));
	}

	public double evaulate(String s){
		Scanner sc =  new Scanner(s);
		Stack<Double> stack = new Stack<Double>();
		double next;
		String comp;
		while(sc.hasNext()){ //I really liked how the book used scanner in this case, so I did that, but I think my use of Scanner is a little more elegant.
			if(sc.hasNextDouble()){
				next = sc.nextDouble();
				stack.push(new Double(next));
			}
			else{
				comp = sc.next();
				double right = stack.pop();
				double left = stack.pop();
				if(comp.equals("+")){ //I like ifs more then switch, so I converted over.
					stack.push(right + left); //this is from when I wrote a program in C++ and forgot to break a switch, and segfault debugging sucks.
				}
				else if(comp.equals("-")){
					stack.push(right - left);
				}
				else if(comp.equals("*")){
					stack.push(right*left);

				}
				else if(comp.equals("/")){
					stack.push(right/left);
				}
				else{
					System.out.print(comp);
					throw new IllegalArgumentException("One of your operators is not valid!");
				}
			}
		}
		if(stack.size() != 1){
			throw new IllegalArgumentException("Your input is not valid!");
		}
		return stack.pop();
	}
}