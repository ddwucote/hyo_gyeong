import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		
		int n = sc.nextInt();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		Collections.sort(arr);
		for (int i = 0; i < n; i++) {
			for (int k = 0; k <= i; k++)
				ans += arr.get(k);
		}
		System.out.print(ans);
	}

}
