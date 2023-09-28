import java.util.*;
import java.io.*;
public class Main {
	
	private static Queue<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt();
		int h = sc.nextInt();
		while (w != 0 && h != 0) {
			int[][] map = new int[h][w];
			for (int j = 0; j < h; j++) {
				for (int k = 0; k < w; k++) {
					map[j][k] = sc.nextInt();
				}
			}
			int ans = 0;
			for (int j = 0; j < h; j++) {
				for (int k = 0; k < w; k++) {
					if (map[j][k] == 1) {
						queue.add(new int[] {j, k});
						ans += countIsland(map, w, h);
					}
				}
			}
			System.out.println(ans);
			w = sc.nextInt();
			h = sc.nextInt();
		}
	}
	
	public static int countIsland(int[][] map, int w, int h) {
		int[] sideX = {1,-1,0,0,1,1,-1,-1};
		int[] sideY = {0,0,-1,1,1,-1,1,-1};
		
		while (!queue.isEmpty()) {
			int[] element = queue.poll();
			int x = element[0];
			int y = element[1];
			for (int i = 0; i < 8; i++) {
				int tmpX = x+sideX[i];
				int tmpY = y+sideY[i];
				if (tmpX >= 0 && tmpX < h && tmpY >= 0 && tmpY < w && map[tmpX][tmpY] == 1) {
					map[tmpX][tmpY] = 0;
					queue.add(new int[] {tmpX, tmpY});
				}
			}
		}
		return 1;
	}
}





