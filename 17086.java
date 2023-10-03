import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Queue<int[]> queue = new LinkedList<>();
		int[] sideX = {0,0,1,-1,1,-1,1,-1};
		int[] sideY = {1,-1,1,-1,0,0,-1,1};
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int input = sc.nextInt();
				if (input == 1) {
					arr[i][j] = 0;
					queue.add(new int[] {i, j});
				}
				else
					arr[i][j] = -1;
			}
		}
		int max = Integer.MIN_VALUE;
		while(!queue.isEmpty()) {
			int[] element = queue.poll();
			int x = element[0];
			int y = element[1];
			for (int i = 0; i < 8; i++) {
				int tmpX = x+sideX[i];
				int tmpY = y+sideY[i];
				if (tmpX >= 0 && tmpX < n && tmpY >= 0 && tmpY < m && arr[tmpX][tmpY] < 0) {
					arr[tmpX][tmpY] = arr[x][y]+1;
					max = Math.max(max, arr[x][y]+1);
					queue.add(new int[] {tmpX, tmpY});
				}
			}
		}
		System.out.print(max);
	}
}