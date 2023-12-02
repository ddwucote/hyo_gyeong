import java.util.*;

class Main {
	private static int COUNT = 0;
	private static int N, M;

    public static void main(String[] args) {	
        Scanner sc = new Scanner(System.in);
        Queue<ArrayList<int[]>> obj = new LinkedList<>();
        int[] sideX = {0,0,1,-1};
        int[] sideY = {1,-1,0,0};
        
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] arr = new int[N][M];
        ArrayList<int[]> temp = new ArrayList<>();
        for (int i = 0; i < N; i++) {
        	String input = sc.next();
        	String[] split = input.split("");
        	for (int j = 0; j < M; j++) {
        		if (split[j].equals("#")) // 벽
        			arr[i][j] = 1;
        		else if (split[j].equals("F")) { // 불
        			arr[i][j] = 2;
        		}
        		else if (split[j].equals("J")) { // 시작점
        			arr[i][j] = 3;
        			temp.add(new int[] {i,j}); // 1. 지훈이 먼저 넣고
        		}
        		else {
        			arr[i][j] = 0; // 빈 공간
        		}
        	}
        }
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		if (arr[i][j] == 2) {
        			temp.add(new int[] {i,j});// 2. 불을 나중에 넣어줘야함
        		}
        	}
        }
        
        obj.add(temp);
        sc.close();
        if (ifJihunOnTheEdge(arr)) {
        	System.out.print(1);
        	return;
        }
    	
        // 지훈 이동
        int jihunMoveFlag = 0;
        
        while(!obj.isEmpty()) {
        	COUNT++;
        	ArrayList<int[]> list = obj.poll();
        	temp = new ArrayList<>();
        	for (int[] e : list) {
	        	int i = e[0];
	        	int j = e[1];
	        	int tx, ty;
	        	if (arr[i][j] == 3) {
		        	for (int k = 0; k < 4; k++) {
						tx = i+sideX[k];
						ty = j+sideY[k];
						if (tx >= 0 && tx < N && ty >= 0 && ty < M && arr[tx][ty] == 0) {
							arr[tx][ty] = 3;
							temp.add(new int[] {tx, ty});
							jihunMoveFlag = 1;
						}
					}
	        	}
	        	if (arr[i][j] == 2) {
					for (int k = 0; k < 4; k++) {
						tx = i+sideX[k];
						ty = j+sideY[k];
						if (tx >= 0 && tx < N && ty >= 0 && ty < M && arr[tx][ty] != 1 && arr[tx][ty] != 2) {
							arr[tx][ty] = 2;
							temp.add(new int[] {tx, ty});
						}
					}
		        }
        	}
        	if (!temp.isEmpty()) {
        		obj.add(temp);
        	}
        	// 아무것도 이동할 것이 없으면서 지훈이가 맵 끝자락에 서있지도 않을 때 - ex) 사방이 벽으로 막혀있는 경우
        	else if (!ifJihunOnTheEdge(arr)) {
            	System.out.print("IMPOSSIBLE");
            	return;
            }
        	// 맵에 지훈이가 존재하는지, 지훈이가 움직일 수는 있는지 확인
        	if (checkIfImpossible(arr) == true || jihunMoveFlag == 0) {
            	System.out.print("IMPOSSIBLE");
            	return;
            }
        	// 지훈이가 맵 끝쪽에 서 있는지 확인
            if (ifJihunOnTheEdge(arr)) {
            	System.out.print(COUNT+1);
            	return;
            }
            
        }
        System.out.print(0);
    }
    
    public static boolean ifJihunOnTheEdge(int[][] arr) {
    	for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		if (i == 0 || j == 0 || i == N-1 || j == M-1) {
        			if (arr[i][j] == 3)
        				return true;
        		}
        	}
    	}
    	return false;
    }
    
    public static boolean checkIfImpossible(int[][] arr) {
    	for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		if (arr[i][j] == 3)
        			return false;
        	}
    	}
    	return true;
    }
}