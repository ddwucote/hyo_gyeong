import java.io.*;
import java.util.*;

class Main {	
	private static int[][] ARR;
	private static int N;
	private static int ANS = 0;
	
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        ARR = new int[N][N];
        
        putQueen(0);
        System.out.print(ANS);
        
        sc.close();
    }

    public static void print(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(ARR[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }
    
    public static void putQueen(int start) {
    	if (start == N) {
    		ANS += 1;
    		return;
    	}
    	for (int i = 0; i < N; i++) {
    		if (ifAvailable(start, i) == 1) {
                // print();
                // System.out.println("put "+start+" "+i);
    			ARR[start][i] = 1;
    			putQueen(start+1);
                ARR[start][i] = 0;
    		}
        }
    }
    
    public static int ifAvailable(int start, int n) {
    	//상 하
    	for (int i = 0; i < N; i++) {
    		if (ARR[i][n] == 1)
    			return 0;
    	}
    	//좌 우
    	for (int i = 0; i < N; i++) {
    		if (ARR[start][i] == 1)
    			return 0;
    	}
    	//대각선
    	for (int i = 1; i < N; i++) {
    		if (start+i < N && start+i >= 0) {
	    		if (n+i < N && n+i >= 0 && ARR[start+i][n+i] == 1)
	    			return 0;
	    		if (n-i < N && n-i >= 0 && ARR[start+i][n-i] == 1)
	    			return 0;
    		}
    		if (start-i < N && start-i >= 0) {
	    		if (n+i < N && n+i >= 0 && ARR[start-i][n+i] == 1)
	    			return 0;
	    		if (n-i < N && n-i >= 0 && ARR[start-i][n-i] == 1)
	    			return 0;
    		}
    	}
    	return 1;
    }
}