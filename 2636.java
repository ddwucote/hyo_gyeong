import java.util.*;
class Main {
	
    public static void main(String[] args) {	
        Scanner sc = new Scanner(System.in);
        Queue<int []> q = new LinkedList<>();
        int[] sh = {-1,1,0,0};
        int[] sw = {0,0,1,-1};
        int cntOne = 0;
        int cntHall = 0, cnt = 0;
        
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[][] arr = new int[h][w];
        int[][] visited = new int[h][w];
        for (int i = 0; i < h; i++) {
        	for (int j = 0; j < w; j++) {
        		arr[i][j] = sc.nextInt();
        		if (arr[i][j] == 1)
        			cntOne++;
        	}
        }
        if (cntOne == 0){
            System.out.print("0\n0"); 
            return;
        }
        while(cntOne > 0) {
	        q.add(new int[] {0,0});
	        while(!q.isEmpty()) {
	        	int[] e = q.poll();
	        	int x = e[0];
	        	int y = e[1];
	        	if (arr[x][y] == 0 && visited[x][y] == 0) {
                    visited[x][y] = 1;
	        		for (int k = 0; k < sh.length; k++) {
	    				int tx = x+sh[k];
	    				int ty = y+sw[k];
	    				if (tx >= 0 && tx < h && ty >= 0 && ty < w && visited[tx][ty] == 0) {
	    					if (arr[tx][ty] == 0) 
	    						q.add(new int[] {tx,ty});
	    					else if (arr[tx][ty] == 1) {
	    						visited[tx][ty] = 1;
	    						arr[tx][ty] = 0;
	        					cntOne--;
	        					cntHall++;
	    					}
	    				}
	    			}
	        	}
	        }
	        cnt++;
	        visited = new int[h][w];
	        if (cntOne == 0)
	        	System.out.println(cnt+"\n"+cntHall);
	        cntHall = 0;
        }          
       
    }
}