import java.util.*;

class Main {
	private static int COUNT = 0;
	private static int N, M;
	
    public static void main(String[] args) {	
        Scanner sc = new Scanner(System.in);
        Queue<ArrayList<int[]>> icebergs = new LinkedList<>();
        
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] arr = new int[N][M];
        ArrayList<int[]> iceberg = new ArrayList<>();
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		int input = sc.nextInt();
        		if (input != 0) {
        			arr[i][j] = input;
        			iceberg.add(new int[] {i,j});
        		}
        		else {
        			arr[i][j] = -1;
        		}
        	}
        }
        
        icebergs.add(iceberg);
    	if (ifAllMelted(arr)) {
    		System.out.print(0);
    		return;
    	}
    	int[] sideX = {0,0,1,-1};
    	int[] sideY = {-1,1,0,0};
    	while(!icebergs.isEmpty()) {
    		COUNT++;
    		ArrayList<int[]> element = icebergs.poll();
    		iceberg = new ArrayList<>();
    		for (int[] e : element) {
    			int i = e[0];
    			int j = e[1];
    			if (arr[i][j] > 0) {
	    			for (int k = 0; k < 4; k++) {
	        			int tx = i+sideX[k];
	        			int ty = j+sideY[k];
	        			if (tx >= 0 && tx < N && ty >= 0 && ty < M && arr[tx][ty] == -1 && arr[i][j] > 0) {
	        				arr[i][j] -= 1;
	        			}
	        		}
	    			if (arr[i][j] > 0) {
    					iceberg.add(new int[] {i, j});
    				}
    			}
    		}
    		//0으로 계산된 부분 -1로 바꿔주기
    		for (int i = 0; i < N; i++) {
            	for (int j = 0; j < M; j++) {
            		if (arr[i][j] == 0) {
            			arr[i][j] = -1;
            		}
            	}
    		}
    		if (!iceberg.isEmpty()) {
    			icebergs.add(iceberg);
    		}
    		else {
    			System.out.print(0);
    			return;
    		}
        	// 빙산이 나뉘었는지 확인
        	int part = 0;
        	Queue<int[]> q = new LinkedList<>();
        	boolean[][] visited = new boolean[N][M];
        	for (int i = 0; i < N; i++) {
            	for (int j = 0; j < M; j++) {
            		if (arr[i][j] != -1 && visited[i][j] == false) {
            			q.add(new int[] {i, j});
            			visited = checkVisited(arr, q, visited);
            			part++;
            		}
            	}
        	} 
        	if (part >= 2) {
        		System.out.print(COUNT);
        		return;
        	}
    	}
    	
    }
    
    public static boolean[][] checkVisited(int[][] arr, Queue<int[]> icebergs, boolean[][] visited){
    	int[] sideX = {0,0,1,-1};
    	int[] sideY = {-1,1,0,0};
    	
    	while (!icebergs.isEmpty()) {
    		int[] e = icebergs.poll();
    		int i = e[0];
    		int j = e[1];
    		if (visited[i][j] == false) {
    			visited[i][j] = true;
	    		for (int k = 0; k < 4; k++) {
	    			int tx = i+sideX[k];
	    			int ty = j+sideY[k];
	    			if (tx >= 0 && tx < N && ty >= 0 && ty < M && arr[tx][ty] != -1 && visited[tx][ty] == false) {
	    				icebergs.add(new int[] {tx, ty});
	    			}
	    		}
    		}
    	}
    	return visited;
    }
    
    public static boolean ifAllMelted(int[][] arr) {
    	for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		if (arr[i][j] != -1)
        			return false;
        	}
    	}
    	return true;
    }
}