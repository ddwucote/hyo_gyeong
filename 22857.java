import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int ans = Integer.MIN_VALUE;
		
		int n = sc.nextInt();
		int pick = sc.nextInt();
		int[] arr = new int[n+1];
		int odd = 0;
		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();
			arr[i] = input;
			if (input % 2 == 1)
				odd++;
		}
		
		if (odd <= pick) {
			System.out.print(n - odd);
			return;
		}
		int start = 0;
		int end = 0;

		int even = 0;
		odd = 0;
		while (end < n) {
			if (arr[end] % 2 == 0)
				even++;
			else
				odd++;
			end++;
			if (odd > pick) {
				ans = Math.max(ans, even);
				start++;
				while(start < n) {
					if (arr[start]%2 == 0)
						break;
					else
						start++;
				}
				odd = 0;
				even = 0;
				end = start;
			}
			
		}
		ans = Math.max(ans, even);
		System.out.print(ans);
		sc.close();
	}
}
