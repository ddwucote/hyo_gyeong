import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Queue<int[]> q = new LinkedList<>();
		int[] sideH = {0,0,0,0,-1,1};
		int[] sideX = {1,-1,0,0,0,0};
		int[] sideY = {0,0,-1,1,0,0};
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();
		int cntOne = 0;
		int cntMinus = 0;
		int[][][] arr = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[h][i][j] = sc.nextInt();
					if (arr[h][i][j] == 1) {
						q.add(new int[] {h,i,j});
						cntOne++;
					}
					else if (arr[h][i][j] == -1)
						cntMinus++;
				}
			}
		}
		if (cntMinus == M*N*H || cntOne == M*N*H || cntMinus+cntOne == M*N*H) {
			System.out.print("0");
			return;
		}
		q.add(new int[] {-100});
		int cntDay = 0;
		B:
		while (!q.isEmpty()) {
			int[] element = q.poll();
			int h = element[0];
			int x, y;
			if (h == -100) {
				q.add(new int[] {-100});
				cntDay++;
				element = q.poll();
				if (element == null || element[0] == -100)
					break B;
				if (cntOne == M*N*H || cntMinus+cntOne == M*N*H) {
					System.out.println(cntDay);
					return;
				}
				h = element[0];
				x = element[1];
				y = element[2];
			}
			x = element[1];
			y = element[2];
			for (int i = 0; i < 6; i++) {
				int tmpH = h+sideH[i];
				int tmpX = x+sideX[i];
				int tmpY = y+sideY[i];
				if (tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < M &&
						tmpH >= 0 && tmpH < H && arr[tmpH][tmpX][tmpY] == 0) {
					arr[tmpH][tmpX][tmpY] = 1;
					cntOne++;
					q.add(new int[] {tmpH, tmpX, tmpY});
				}
			}
		}
		System.out.print("-1");
		sc.close();
	}
}





