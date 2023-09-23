import java.util.*;
import java.io.*;
public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			Queue<int[]> queue = new LinkedList<>();
			int[] idxX = {0,0,-1,1};
			int[] idxY = {-1,1,0,0};
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][m];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer row = new StringTokenizer(bf.readLine());
				for (int j = 0; j < m; j++) {
					int input = Integer.parseInt(row.nextToken());
					if (input == 2) {
						arr[i][j] = 0;
						queue.add(new int[] {i,j});
					}
					else if (input == 1)
						arr[i][j] = -1;
					else
						arr[i][j] = input;
				}
			}
				
			while (!queue.isEmpty()) {
				int[] q = queue.poll();
				int x = q[0];
				int y = q[1];
				for (int i = 0; i < 4; i++) {
					if (x+idxX[i] < n && x+idxX[i] >= 0 &&
						y+idxY[i] < m && y+idxY[i] >= 0) {
						if (arr[x+idxX[i]][y+idxY[i]] == -1) {
							queue.add(new int[] {x+idxX[i], y+idxY[i]});
							arr[x+idxX[i]][y+idxY[i]] = arr[x][y]+1;
						}
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}

	}

