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
		Collections.sort(arr, Collections.reverseOrder());
		while (arr.size() > 2) {
			ans += arr.get(0) + arr.get(1);
			arr.remove(0);
			arr.remove(0);
			arr.remove(0);
		}
		if (!arr.isEmpty()) {
			for (Integer i : arr) {
				ans += i;
			}
		}
		sc.close();
		System.out.print(ans);
	}

}


