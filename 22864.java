import java.util.*;
public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

    	int A = sc.nextInt(); //tired
    	int B = sc.nextInt(); //work
    	int C = sc.nextInt(); //rest
    	int M = sc.nextInt(); //Max
    	int tiredness = 0;
    	int work = 0;
    	for (int i = 0; i < 24; i++) {
    		if (tiredness + A <= M) { // work
    			work += B;
    			tiredness += A;
    		}
    		else { // rest
    			tiredness -= C;
    			if (tiredness < 0)
    				tiredness = 0;
    		}
    	}
    
		System.out.print(work);
        sc.close();
    }
}