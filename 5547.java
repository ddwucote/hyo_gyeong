import java.util.*;

class Main {
    
    public static void main(String[] args) {	
        Scanner sc = new Scanner(System.in);
        Queue<int[]> q = new LinkedList<>();
        int[] H = {0,0,-1,1,-1,1};
        int[] evenW = {-1,1,0,0,1,1};
        int[] oddW = {-1,1,0,0,-1,-1};
        
        int w = sc.nextInt();
        int h = sc.nextInt();
        int[][] arr = new int[h][w];
        int[][] visited = new int[h][w];
        for(int i = 0; i < h; i++) {
        	for (int j = 0; j < w; j++) {
        		arr[i][j] = sc.nextInt();
        		if (visited[i][j] == 0 && arr[i][j] == 0 && (i == 0 || i == h-1 || j == 0 || j == w-1)) {
        			q.add(new int[] {i,j});
        		}
        	}
        }
        while(!q.isEmpty()) {
        	int[] e = q.poll();
        	int i = e[0];
        	int j = e[1];
        	if (arr[i][j] == 0)
        		arr[i][j] = 2;
        	for (int k = 0; k < H.length; k++) {
    			int ti = i+H[k];
    			int tj = i%2 == 0 ? j+evenW[k] : j+oddW[k];
    			if (ti >= 0 && ti < h && tj >= 0 && tj < w && visited[ti][tj] == 0 && arr[ti][tj] == 0) {
    				visited[ti][tj] = 1;
    				arr[ti][tj] = 2;
    				q.add(new int[] {ti, tj});
    			}
    		}        	
        }
        
        int ans = 0;       
        for(int i = 0; i < h; i++) {
        	for (int j = 0; j < w; j++) {
        		if (arr[i][j] == 1) {
        			for (int k = 0; k < H.length; k++) {
    	    			int ti = i+H[k];
    	    			int tj = i%2 == 0 ? j+evenW[k] : j+oddW[k];
    	    			if (ti >= 0 && ti < h && tj >= 0 && tj < w) {
    	    				if (arr[ti][tj] == 2)
    	    					ans++;
    	    			}
    	    			else
    	    				ans++;
    	    		}
        			
        		}
        	}
        }
        System.out.print(ans);
    }
}