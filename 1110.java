import java.util.*;
public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

    	int origin = sc.nextInt();
    	int num = origin;
    	int new_num = -1;
    	int cycle = 0;
    	
    	while (true) {
    		int right = ((num % 10) + (num / 10)) % 10;
        	new_num = (num % 10 * 10) + right;
        	cycle++;
        	num = new_num;
        	if (origin == new_num)
        		break;
    	}    	
		System.out.print(cycle);
        sc.close();
    }
}