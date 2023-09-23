import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Queue<int[]> q = new LinkedList<>();
		int[] sideX = {1,-1,0,0};
		int[] sideY = {0,0,-1,1};
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int cntOne = 0;
		int cntMinus = 0;
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1) {
					q.add(new int[] {i,j});
					cntOne++;
				}
				else if (arr[i][j] == -1)
					cntMinus++;
			}
		}
		if (cntMinus == M*N || cntOne == M*N || cntMinus+cntOne == M*N) {
			System.out.print("0");
			return;
		}
		q.add(new int[] {-100,-100});
		int cntDay = 0;
		B:
		while (!q.isEmpty()) {
			int[] element = q.poll();
			int x = element[0];
			int y = element[1];
			if (x == -100) {
				q.add(new int[] {-100,-100});
				cntDay++;
				element = q.poll();
				if (element == null || element[0] == -100)
					break B;
				if (cntOne == M*N || cntMinus+cntOne == M*N) {
					System.out.println(cntDay);
					return;
				}
				x = element[0];
				y = element[1];
			}
			for (int i = 0; i < 4; i++) {
				int tmpX = x+sideX[i];
				int tmpY = y+sideY[i];
				if (tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < M && arr[tmpX][tmpY] == 0) {
					arr[tmpX][tmpY] = 1;
					cntOne++;
					q.add(new int[] {tmpX, tmpY});
				}
			}
		}
		System.out.print("-1");

	}
}





