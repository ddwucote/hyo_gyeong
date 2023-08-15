import java.util.*;
public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

    	int smallest = -1;
    	int sum = 0;
    	
        int start = sc.nextInt();
        sc.nextLine();
        int end = sc.nextInt();
        sc.nextLine();
        for (int i = start; i <= end; i++) {
        	if (i == 1)
        		continue;
        	int flag = 1;
        	for (int k = 2; k <= Math.sqrt(i); k++) {
        		if (i % k == 0) {
        			flag = 0;
        			break;
        		}
        	}
        	if (flag == 1 && smallest == -1)
        		smallest = i;
        	if (flag == 1) {
        		sum += i;
        	}
        }
        if (sum != 0)
        	System.out.print(sum + "\n" + smallest);
        else
        	System.out.print("-1");
        sc.close();
    }
}