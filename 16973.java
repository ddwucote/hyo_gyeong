import java.util.*;
import java.io.*;

class Main {
	private static boolean[][] visited;
	private static int[][] arr;
	private static int H, W, sqrh, sqrw;
	
	public static boolean checkIfWallExist(int h, int w) {
		for (int i = h; i < h+sqrh; i++) {
			for (int j = w; j < w+sqrw; j++) {
				if (i > H || j > W)
					return true;
				else if (arr[i][j] == 1)
					return true;
			}
		}
		return false;
	}
	
    public static void main(String[] args) throws IOException {	
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
    	ArrayList<int[]> startPoint = new ArrayList<>();
        Queue<ArrayList<int[]>> queue = new LinkedList<>();
        int[] sideH = {1,-1,0,0};
        int[] sideW = {0,0,1,-1};
        
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[H+1][W+1];
        visited = new boolean[H+1][W+1];
        for (int h = 1; h <= H; h++) {
            st = new StringTokenizer(bf.readLine());
        	for (int w = 1; w <= W; w++) {
        		arr[h][w] = Integer.parseInt(st.nextToken());
        	}
        }
        st = new StringTokenizer(bf.readLine());
        sqrh = Integer.parseInt(st.nextToken());
        sqrw = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int er = Integer.parseInt(st.nextToken());
        int ec = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        startPoint.add(new int[] {r, c});
        queue.add(startPoint);
        while(!queue.isEmpty()) {
        	ArrayList<int[]> q = queue.poll();
        	startPoint = new ArrayList<>();
        	for (int[] e : q) {
	        	if (e[0] == er && e[1] == ec) {
	        		System.out.print(cnt);
	        		return;
	        	}
	        	visited[e[0]][e[1]] = true;
	        	for (int i = 0; i < 4; i++) {
	        		int tmph = e[0]+sideH[i];
	        		int tmpw = e[1]+sideW[i];
	        		if (tmph >= 1 && tmph <= H && tmpw >=1 && tmpw <= W && visited[tmph][tmpw] == false) {
	        			visited[tmph][tmpw] = true;
	        			if (checkIfWallExist(tmph, tmpw) == false) {
	        				startPoint.add(new int[] {tmph, tmpw});
	        			}
	        		}
	        	}
        	}
        	if (!startPoint.isEmpty()) {
        		queue.add(startPoint);
        	}
        	cnt++;
        }
        System.out.print(-1);
    }
}