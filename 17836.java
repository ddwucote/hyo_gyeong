import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException{
    	Scanner sc = new Scanner(System.in);
    	Queue<ArrayList<int[]>> queue = new LinkedList<>();
    	ArrayList<int[]> tmp = new ArrayList<>();
    	int[] sx = {0,0,1,-1};
    	int[] sy = {-1,1,0,0};
    	int cnt = 0;
    	int foundTwo = Integer.MAX_VALUE;
    	
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	int t = sc.nextInt();
    	int[][] arr = new int[n][m];
    	int[][] visited = new int[n][m];
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < m; j++) {
    			arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1)
                    visited[i][j] = 1;
    		}
    	}
        if (arr[0][0] == 2){
            System.out.print(n+m-2);
            return;
        }
    	tmp.add(new int[] {0,0});
    	arr[0][0] = 1;
    	visited[0][0] = 1;
    	queue.add(tmp);
    	while(!queue.isEmpty()){
    		ArrayList<int[]> element = queue.poll();
            tmp = new ArrayList<>();
    		for (int k = 0; k < element.size(); k++) {
	    		int x = element.get(k)[0];
	    		int y = element.get(k)[1];
	    		visited[x][y] = 1;
	    		if (x == n-1 && y == m-1) {
	    			System.out.print(Math.min(foundTwo, cnt));
	    			return;
	    		}
	    		if (arr[x][y] == 2) {
	    			foundTwo = Math.min(foundTwo, cnt+(n-x-1)+(m-y-1));
	    		}
	    		for (int i = 0; i < 4; i++) {
	    			int tx = x+sx[i];
	    			int ty = y+sy[i];
	    			if (tx >= 0 && tx < n && ty >= 0 && ty < m && visited[tx][ty] == 0) {
	    				visited[tx][ty] = 1;
    					tmp.add(new int[] {tx, ty});
	    			}
	    		}
    		}
    		if (!tmp.isEmpty()) {
    			queue.add(tmp);
    			cnt++;
    		}
    		if (cnt > t) {
    			if (foundTwo <= t)
    	    		System.out.print(foundTwo);
    			else
    				System.out.print("Fail");
    			return;
    		}
    	}
    	if (foundTwo <= t)
    		System.out.print(foundTwo);
    	else
    		System.out.print("Fail");
    	sc.close();
    }
}