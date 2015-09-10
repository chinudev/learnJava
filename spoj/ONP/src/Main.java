// http://www.spoj.com/problems/ONP/
// Transform the expression

import java.io.*;

public class Main {

	public static class Tuple <X,Y>{
		public final X first;
		public final Y second;
		public Tuple(X first, Y second) {
			this.first = first;
			this.second = second;
		}
	}
	
	public static Tuple<String,String> transform(String input) {
		String first, operator, second;
		
		//System.out.println("Entering with " + input);

		// We will encounter an expression of form 
		//    var op var    
		// or  (expr) op (expr)
		
		// Read the first param 
		if (input.charAt(0) == '(') {
			Tuple<String,String> resp = transform(input.substring(1));
			first = resp.first;
			// truncate closing paren from the leftover 
			input = resp.second.substring(1); 
		} else {
			first = input.substring(0,1);
			input = input.substring(1);
		}
		
		operator = input.substring(0,1);
		input = input.substring(1);
		
		if (input.charAt(0) == '(') {
			Tuple<String,String> resp = transform(input.substring(1));
			second = resp.first;
			input = resp.second.substring(1);
		} else {
			second = input.substring(0,1);
			input = input.substring(1);
		}
		
		//System.out.println("Returning " + first+second+operator + "," + input);
		return (new Tuple<String,String>(first+second+operator, input));		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader in=new InputStreamReader(System.in);
	    BufferedReader br=new BufferedReader(in);
	  
	    int numTest = Integer.valueOf(br.readLine());
	    
	    for (int i=0; i < numTest; i++) {
	    	String s=br.readLine();
	    	System.out.println(transform(s.substring(1,s.length()-1)).first);
	    }
	}
}
