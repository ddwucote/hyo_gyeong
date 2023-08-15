import java.util.*;
public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	StringBuilder sb = new StringBuilder();

    	int num = sc.nextInt();
    	if (num == 1) {
    		System.out.print("1");
    		sc.close();
    		return;
    	}
    	int i = 2;
    	while (i <= num) {
    		if (num % i == 0) {
    			sb.append(i).append("\n");
    			num /= i;
    		}
    		else
    			i++;
    	}
    	
		System.out.print(sb);
    	
        sc.close();
    }
}