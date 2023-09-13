import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		long[][] dp = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
				dp[i][j] = 0;
			}
		}
		dp[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 아래
				if (i == n-1 && j == n-1) {
					continue;
				}
				int value = arr[i][j];
				if (i+value < n) {
					dp[i+value][j] += dp[i][j];
				}
				// 오른쪽
				if (j+value < n) {
					dp[i][j+value] += dp[i][j];
				}
			}
		}
		System.out.print(dp[n-1][n-1]);
		sc.close();
	}
}


