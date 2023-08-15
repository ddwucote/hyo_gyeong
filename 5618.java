import java.util.*;
public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	StringBuilder sb = new StringBuilder();

    	int n = sc.nextInt();
    	sc.nextLine();
    	if (n == 2) {
    		int n1 = sc.nextInt();
    		int n2 = sc.nextInt();
    		int smallest = (n1 > n2 ? n2 : n1);
    		for (int i = 1; i <= smallest; i++)
    			if (n1 % i == 0 && n2 % i == 0)
    				sb.append(i+"\n");
    		
    	}
    	if (n == 3) {
    		int n1 = sc.nextInt();
    		int n2 = sc.nextInt();
    		int n3 = sc.nextInt();
    		int smallest;
    		if (n1 > n2)
    			if (n2 > n3)
    				smallest = n3;
    			else
    				smallest = n2;
    		else
    			if (n1 > n3)
    				smallest = n3;
    			else
    				smallest = n1;
    		for (int i = 1; i <= smallest; i++)
    			if (n1 % i == 0 && n2 % i == 0 && n3 % i == 0)
    				sb.append(i+"\n");
    	}
    	System.out.print(sb);
        sc.close();
    }
}