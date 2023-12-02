import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class Main {	
	private static int[][] arr;
	private static int N;
	private static LinkedHashMap<Integer, ArrayList<Integer>> MAP = new LinkedHashMap<>();
	private static int[] sideX = {0,0,1,-1};
	private static int[] sideY = {1,-1,0,0};
	
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);  
        
        N = sc.nextInt();
        arr = new int[N+1][N+1];
       
        for (int i = 1; i <= N*N; i++) {
        	int num = sc.nextInt();
        	if (i == 1) {
        		arr[2][2] = num;
        	}
        	MAP.put(num, new ArrayList<>());
        	for (int j = 0; j < 4; j++) {
        		MAP.get(num).add(sc.nextInt());
        	}
        }
        for (Entry<Integer, ArrayList<Integer>> m : MAP.entrySet()) {
        	int key = m.getKey();
        	if (key == arr[2][2])
        		continue;
        	placeNumber(key);
        }
        System.out.print(calculateSatisfaction());
        sc.close();
    }
    
    public static int calculateSatisfaction() {
    	int[][] satifaction = new int[N+1][N+1];
    	int sum = 0;
    	for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 0; k < 4; k++) {
					int tx = i+sideX[k];
					int ty = j+sideY[k];
					if (tx >= 1 && tx <= N && ty >= 1 && ty <= N && MAP.get(arr[i][j]).contains(arr[tx][ty])) {
						satifaction[i][j]++;
					}
				}
			}
    	}
    	for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (satifaction[i][j] > 0) {
					sum += Math.pow(10, satifaction[i][j]-1);
				}
			}
    	}
    	return sum;
    }
    
    public static void placeNumber(int n) {
    	int[][] like = new int[N+1][N+1];
    	int max = -1;
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			if (arr[i][j] == 0) {
    				for (int k = 0; k < 4; k++) {
    					int tx = i+sideX[k];
    					int ty = j+sideY[k];
    					if (tx >= 1 && tx <= N && ty >= 1 && ty <= N && MAP.get(n).contains(arr[tx][ty])) {
    						like[i][j]++;
    						max = Math.max(max, like[i][j]);
    					}
    				}
    			}
    		}
    	}
    	Queue<int[]> q = new LinkedList<>();
    	if (max == -1) { // 좋아하는 학생이 하나도 앉지 않은 경우도 생각해야함!!
    		for (int i = 1; i <= N; i++) {
        		for (int j = 1; j <= N; j++) {
        			if (arr[i][j] == 0) {
        				q.add(new int[] {i,j});
        			}
        		}
    		}
    		placeMostEmptyPlace(q, n);
    	}
    	else {
	    	for (int i = 1; i <= N; i++) {
	    		for (int j = 1; j <= N; j++) {
	    			if (like[i][j] == max) {
	    				q.add(new int[] {i,j});
	    			}
	    		}
	    	}
	    	if (q.size() == 1) {
	    		int[] position = q.poll();
	    		int x = position[0];
	    		int y = position[1];
	    		arr[x][y] = n;
	    		return;
	    	}
	    	else {
	    		placeMostEmptyPlace(q, n);
	    	}
    	}
    }
    
    public static void placeMostEmptyPlace(Queue<int[]> q, int number) {
    	Queue<int[]> copyQ = new LinkedList<>();
    	for (int i = 0; i < q.size(); i++) {
    		int[] e = q.poll();
    		copyQ.add(e);
    		q.add(e);
    	}
    	int[][] empty = new int[N+1][N+1];
    	int max = -1;    	
    	while(!q.isEmpty()) {
    		int[] e = q.poll();
    		int i = e[0];
    		int j = e[1];
    		if (arr[i][j] == 0) {
	    		for (int k = 0; k < 4; k++) {
					int tx = i+sideX[k];
					int ty = j+sideY[k];
					if (tx >= 1 && tx <= N && ty >= 1 && ty <= N && arr[tx][ty] == 0) {
						empty[i][j]++;
						max = Math.max(max, empty[i][j]);
					}
				}
    		}
    	}
    	if (max == -1) { // 넘어온 큐의 주변이 전부 꽉찬 경우도 생각해야함!
    		placeByRC(copyQ, number); // 큐 그대로 넘겨주고 행,렬로 찾아야 함
    		return;
    	}
    	Queue<int[]> nq = new LinkedList<>();
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			if (empty[i][j] == max) {
    				nq.add(new int[] {i,j});
    			}
    		}
    	}
    	if (nq.size() == 1) {
    		int[] position = nq.poll();
    		int x = position[0];
    		int y = position[1];
    		arr[x][y] = number;
    		return;
    	}
    	else {
    		placeByRC(nq, number);
    	}
    }
    
    public static void placeByRC(Queue<int[]> q, int number) {
    	int[] temp = q.poll();
    	while(!q.isEmpty()) {
    		int[] e = q.poll();
    		if (temp[0] > e[0]) {
    			temp = e;
    		}
    		if (temp[0] == e[0] && temp[1] > e[1]) {
    			temp = e;
    		}
    	}
    	arr[temp[0]][temp[1]] = number;
    }
}