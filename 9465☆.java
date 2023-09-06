//memory error
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) { //2
			int num = sc.nextInt(); //5, 7
			int[][] arr = new int[num][num];
			int even = 0;
			int odd = 0;
			for (int n = 0; n < 2; n++) {
				for (int m = 0; m < num; m++) {
					arr[n][m] = sc.nextInt();
					if (n == 0 && m < num-2) {
						if (m % 2 == 0)
							even += arr[n][m];
						else
							odd += arr[n][m];
					}
					else if (n == 1 && m < num-2) {
						if (m % 2 == 1)
							even += arr[n][m];
						else
							odd += arr[n][m];
					}	
					
				}
			}
			if (num % 2 == 1) {
				int evenMax = even + Math.max(arr[1][num-1], arr[1][num-2]+arr[0][num-1]);
				int oddMax = odd + Math.max(arr[0][num-1], arr[0][num-2]+arr[1][num-1]);
				System.out.println(Math.max(evenMax, oddMax));
			}
			else {
				int evenMax = even + Math.max(arr[0][num-1], arr[1][num-1]+arr[0][num-2]);
				int oddMax = odd + Math.max(arr[0][num-1]+arr[1][num-2], arr[1][num-1]);
				System.out.println(Math.max(evenMax, oddMax));
			}
		}
		sc.close();
	}
}