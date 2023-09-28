import java.util.*;
import java.io.*;
public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Queue<int[]> queue = new LinkedList<>();
		int[] sideX = {0,0,1,-1};
		int[] sideY = {1,-1,0,0};
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			String[] strArr = str.split("");
			for (int j = 0; j < M; j++) {
				int input = Integer.parseInt(strArr[j]);
				if (i == 0 && input == 0)
					queue.add(new int[] {i, j});
				arr[i][j] = input;
			}
		}
		while (!queue.isEmpty()) {
			int[] element = queue.poll();
			int x = element[0];
			int y = element[1];
			arr[x][y] = 2;
			for (int i = 0; i < 4; i++) {
				int tmpX = x+sideX[i];
				int tmpY = y+sideY[i];
				if (tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < M && arr[tmpX][tmpY] == 0) {
					queue.add(new int[] {tmpX, tmpY});
					arr[tmpX][tmpY] = 2;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			if (arr[N-1][i] == 2) {
				System.out.print("YES");
				return;
			}
		}
		System.out.print("NO");
	}
}





