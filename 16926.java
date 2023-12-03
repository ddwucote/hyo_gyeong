import java.io.*;
import java.util.*;

class Main {	
	private static int[][] arr;
	private static int N, M, R;
	
	public static void printArr(int[][] arr) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);  
        
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        arr = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= M; j++) {
        		arr[i][j] = sc.nextInt();
        	}
        }
        int count = Math.min(N, M)/2;
        for (int k = 0; k < R; k++) {
        	int[][] tempArr = new int[N+1][M+1];
	        for (int i = 1; i <= count; i++) {
	        	rotate(i, tempArr);
	        }
	        arr = tempArr;
        }
        printArr(arr);
        sc.close();
    }
    
    public static void rotate(int startValue, int[][] tempArr) {
    	int n = N-startValue+1;
    	int m = M-startValue+1;
    	Queue<int[]> q = new LinkedList<>();
        
    	for (int i = startValue; i <= n; i++) {
    		if (i == startValue) { //맨 윗줄
    			for (int j = startValue; j <= m; j++) {
                    if (j == startValue) {
                        tempArr[i+1][j] = arr[i][j];
                    }
                    else {
                        tempArr[i][j-1] = arr[i][j];
                    }
    			}
    		}
    		else if (i == n) { // 맨 아랫줄
    			for (int j = startValue; j <= m; j++) {
	    			if (j == m) {
	    				tempArr[i-1][j] = arr[i][j];
	    			}
	    			else {
	    				tempArr[i][j+1] = arr[i][j];
	    			}
    			}
    		}
    		else {
    			for (int j = startValue; j <= m; j += m-startValue) {
	    			if (j == startValue) {
	    				tempArr[i+1][j] = arr[i][j];
	    			}
	    			else if (j == m) {
	    				tempArr[i-1][j] = arr[i][j];
	    			}
    			}
    		}
    	}
    }
}