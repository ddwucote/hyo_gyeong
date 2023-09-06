//searched
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		int[] arr = new int[n+1];
		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();
			arr[i] = input;
			dp[i] = 1;
			for (int k = 0; k < i; k++) {
				if (arr[i] > arr[k] && dp[i] <= dp[k])
					dp[i] = dp[k]+1;
			}
		}
		int ans = 0;
		for (Integer i : dp) {
			ans = Math.max(ans, i);
		}

		System.out.println(ans);
		sc.close();
	}
}