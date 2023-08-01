package test;
//1935
import java.util.*;

public class test2 {
	
	public static boolean isInteger(String strValue) {
	    try {
	      Integer.parseInt(strValue);
	      return true;
	    } catch (NumberFormatException ex) {
	      return false;
	    }
	  }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack<>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        int cnt = sc.nextInt(); //5
        sc.nextLine();
        String input = sc.nextLine(); //ABC*+DE/-
        
        alphabet = alphabet.substring(0, cnt); //ABCDE

        for(int i = 0; i < cnt; i++){
        	String a = String.valueOf(alphabet.charAt(i)); //A,B,C,D,E
        	if (input.contains(a)){
        		input = input.replaceAll(a, String.valueOf(sc.nextInt()));
        		sc.nextLine();
        	}
        }
        
        for (int i = 0; i < input.length(); i++) {
        	String s = String.valueOf(input.charAt(i));
        	if (isInteger(s))
        		stack.push(s);
        	else {
        		double b = Double.parseDouble(stack.pop());
        		double a = Double.parseDouble(stack.pop());
        		switch(s) {
        		case"*":
        			stack.push(String.valueOf(a*b));
        			break;
        		case"-":
        			stack.push(String.valueOf(a-b));
        			break;
        		case"/":
        			stack.push(String.valueOf(a/b));
        			break;
        		case"+":
        			stack.push(String.valueOf(a+b));
        			break;
        		}
        	}
        }
        System.out.println(String.format("%.2f", Double.parseDouble(stack.pop())));
        sc.close();
        
	}

}
