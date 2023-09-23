import java.util.*;
import java.io.*;
public class Main {
	private static Queue<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int M = 0, N = 0;
		int[][] farm = null;
		for (int i = 0; i < T; i++) {
			M = sc.nextInt(); // 가로
			N = sc.nextInt(); // 세로
			farm = new int[N][M];
			int cabbage = sc.nextInt();
			for (int j = 0; j < cabbage; j++) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				farm[n][m] = 1;
			}
			int finalAns = 0;
			for (int k = 0; k < N; k++) {
				for (int j = 0; j < M; j++) {
					if (farm[k][j] == 1) {
						queue.add(new int[] {k,j});
						finalAns += earthWarm(farm, M, N);
					}
				}
			}
			System.out.println(finalAns);
		}
		
	}
	
	public static int earthWarm(int[][] farm, int M, int N) {
		int[] sideX = {1,-1,0,0};
		int[] sideY = {0,0,1,-1};
		
		while (!queue.isEmpty()) {
			int[] element = queue.poll();
			int x = element[0];
			int y = element[1];
			
			for (int i = 0; i < 4; i++) {
				int tmpX = x+sideX[i];
				int tmpY = y+sideY[i];
				if (tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < M) {
					if (farm[tmpX][tmpY] == 1) {
						farm[tmpX][tmpY] = -1;
						queue.add(new int[] {tmpX, tmpY});
					}
				}
			}
		}
		return 1;
	}
}