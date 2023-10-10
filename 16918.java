import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException{
    	Scanner sc = new Scanner(System.in);
    	Queue<int[]> queue = new LinkedList<>();
    	int[] sideX = {-1,1,0,0};
    	int[] sideY = {0,0,-1,1};
    	int r = sc.nextInt();
    	int c = sc.nextInt();
    	int n = sc.nextInt();
      
    	int[][] bomb = new int[r][c];
    	int[][] bomb2 = new int[r][c];
    	for (int i = 0; i < r; i++) {
    		String s = sc.next();
    		String[] sArr = s.split("");
    		for (int j = 0; j < c; j++) {
    			if (sArr[j].equals(".")) {
    				bomb[i][j] = 0;
    			}
    			else {
    				bomb[i][j] = 1;
    			}
    		}
    	}
    	if (n % 2 == 0) {
    		for (int i = 0; i < r; i++) {
    			for (int j = 0; j < c; j++) {
    				System.out.print("O");
    			}
    			System.out.println();
    		}
    	}
    	else {
    		for (int m = 0; m < n/2; m++) {
		    	for (int i = 0; i < r; i++) {
		    		for (int j = 0; j < c; j++) {
		    			if (bomb[i][j] == 1) {
		    				bomb[i][j] = 0;
		    				queue.add(new int[] {i,j});
		    			}
		    			else {
		    				bomb[i][j] = 1;
		    			}
		    		}
		    	}
		    	while(!queue.isEmpty()) {
		    		int[] element = queue.poll();
		    		int i = element[0];
		    		int j = element[1];
		    		for (int k = 0; k < 4; k++) {
						int tmpX = i+sideX[k];
						int tmpY = j+sideY[k];
						if (tmpX >= 0 && tmpX < r && tmpY >= 0 && tmpY < c)
							bomb[tmpX][tmpY] = 0;
					}
		    	}
    		}
	    	for (int i = 0; i < r; i++) {
    			for (int j = 0; j < c; j++) {
    				if (bomb[i][j] == 0)
    					System.out.print(".");
    				else
    					System.out.print("O");
    			}
    			System.out.println();
    		}
    	}
    }
}