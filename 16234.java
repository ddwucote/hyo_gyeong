import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException{
    	Scanner sc = new Scanner(System.in);
    	Queue<ArrayList<int[]>> queue = new LinkedList<>();
    	int[] sideX = {-2,2,0,0};
    	int[] sideY = {0,0,-2,2};
    	
    	int n = sc.nextInt();
    	n = 2*n + 1;
    	int L = sc.nextInt();
    	int R = sc.nextInt();
    	int[][] arr = new int[n][n];
    	int[][] check = new int[n][n];    	
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			if (i%2 == 0 || j %2 == 0)
    				arr[i][j] = 0;
    			else
    				arr[i][j] = sc.nextInt();
    		}
    	}
    	
    	int flag;
    	int days = 0;
    	ArrayList<int[]> pair = new ArrayList<>();
    	Queue<int[]> tmpPair = new LinkedList<>();
    	Queue<Integer> calc = new LinkedList<>();
    	int sum = 0, cnt = 0;
    	while(true) {
	    	flag = 0;
	    	check = new int[n][n];
	    	for (int i = 1; i < n; i += 2) {
	    		for (int j = 1; j < n; j += 2) {
	    			for (int k = 0; k < 4; k++) {
	    				int tmpX = i+sideX[k];
	    				int tmpY = j+sideY[k];
	    				if (tmpX >= 0 && tmpX < n && tmpY >= 0 && tmpY < n
	    						&& Math.abs(arr[tmpX][tmpY]-arr[i][j]) >= L
	    						&& Math.abs(arr[tmpX][tmpY]-arr[i][j]) <= R) {
	    					check[i][j] = 1;
	    					check[tmpX][tmpY] = 1;
	    					arr[i+sideX[k]/2][j+sideY[k]/2] = 1;
	    					flag = 1;
	    				}
	    			}
	    		}
	    	}
	    	
	    	if (flag == 0) {
	    		System.out.print(days);
	    		return;
	    	}
	    	
	    	for (int i = 1; i < n; i += 2) {
	    		for (int j = 1; j < n; j += 2) {
	    			sum = 0;
	    			cnt = 0;
	    			if (check[i][j] == 1) {
	    				tmpPair.add(new int[] {i,j});
	    				pair.add(new int[] {i,j});
	    				check[i][j] = 0;
	    				sum += arr[i][j];
	    				cnt++;
	    				while(!tmpPair.isEmpty()) {
	    					int[] e = tmpPair.poll();
	    					int x = e[0];
	    					int y = e[1];
			    			for (int k = 0; k < 4; k++) {
			    				int tmpX = x+sideX[k];
			    				int tmpY = y+sideY[k];
			    				if (tmpX >= 0 && tmpX < n && tmpY >= 0 && tmpY < n
			    						&& check[tmpX][tmpY] == 1
			    						&& arr[x+(sideX[k]/2)][y+(sideY[k]/2)] == 1) {
			    					tmpPair.add(new int[] {tmpX,tmpY});
			    					pair.add(new int[] {tmpX,tmpY});
			    					check[tmpX][tmpY] = 0;
			    					arr[i+sideX[k]/2][j+sideY[k]/2] = 0;
			    					sum += arr[tmpX][tmpY];
			    					cnt++;
			    				}
			    			}
	    				}
	    			}
	    			if (!pair.isEmpty()) {
		    			for (int[] e : pair) {
			        		int x = e[0];
			        		int y = e[1];
			        		arr[x][y] = sum/cnt;
		    	    	}  
	    			}
	    			pair.clear();
	    		}
	    	}
	    	days++;
	    	for (int i = 0; i < n; i++) {
	    		for (int j = 0; j < n; j++) {
	    			if (i%2 == 0 || j %2 == 0)
	    				arr[i][j] = 0;
	    		}
	    	}
	    	
    	}
    }
}