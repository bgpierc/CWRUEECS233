// Ben Pierce(bgp12)
public class balancedParens{
	public static void main(String[] args){
		balancedParens tst = new balancedParens();
		System.out.println(tst.isBalanced("(())(()()()"));
	}
	public boolean isBalanced(String str){
		int lCount = 0;
		int rCount = 0;
		if(str.endsWith("(")) //catches loners
			return false;
		if(str.startsWith(")"))
			return false;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == ')'){
				if((lCount==rCount && lCount >0 && rCount > 0)) //catches reversed
					return false;
				lCount++;
			}
			if(str.charAt(i) == '(')
				rCount++;
		}
		return (lCount == rCount);
	}
}