import java.util.*;

class Main {
	private static int COUNT = 0;
	private static int N;
    public static void main(String[] args) {	
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        int[][] list = new int[N][2];
        for (int i = 0; i < N; i++) {
        	list[i][0] = sc.nextInt();
        	list[i][1] = sc.nextInt();        	
        }
        boolean[] broken = new boolean[N];
        calculate(0, list, broken, 0);
        System.out.print(COUNT);
        sc.close();
    }
    public static void calculate(int pick, int[][] list, boolean[] broken, int cnt) {
    	if (pick == N) {
    		COUNT = Math.max(COUNT, cnt);
    		return;
    	}
    	else if (ifEveryEgssBrokenExceptPickedEgg(pick, broken) || broken[pick] == true) {
    		calculate(pick+1, list, broken, cnt);
    	}
    	else {
	    	for (int i = 0; i < N; i++) {
	    		if (broken[i] == false && i != pick) {
	    			int countBrokenEgg = 0;
		    		list[i][0] -= list[pick][1];
		    		list[pick][0] -= list[i][1];
		    		if (list[i][0] <= 0) {
		    			broken[i] = true;
		    			countBrokenEgg += 1;
		    		}		    		
		    		if (list[pick][0] <= 0) {
		    			broken[pick] = true;
		    			countBrokenEgg += 1;
		    		}
		    		calculate(pick+1, list, broken, cnt+countBrokenEgg);
		    		list[i][0] += list[pick][1];
		    		list[pick][0] += list[i][1];
		    		if (broken[i] = true) {
		    			broken[i] = false;
		    		}		    		
		    		if (broken[pick] = true) {
		    			broken[pick] = false;
		    		}
	    		}
	    	}
    	}
    }
    
    public static boolean ifEveryEgssBrokenExceptPickedEgg(int pick, boolean[] broken) {
    	for (int i = 0; i < N; i++) {
    		if (i == pick)
    			continue;
    		if (broken[i] == false)
    			return false;
    	}
    	return true;
    }
}