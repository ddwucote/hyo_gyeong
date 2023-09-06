//copy code
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[n];
		int[] arr = new int[n];
		int max = 0;
		
		for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            arr[i] = input;
			dp[i] = arr[i];
			for (int k = 0; k < i; k++) {
				if (arr[i] > arr[k] && dp[i] < dp[k]+arr[i]) {
					dp[i] = dp[k]+arr[i];
				}
				max = Math.max(max, dp[i]);
			}
		}
        if (n == 1)
            System.out.print(arr[0]);
		else
            System.out.print(max);
		sc.close();
	}
}