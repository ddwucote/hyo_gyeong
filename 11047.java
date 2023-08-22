import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		
		int n = sc.nextInt();
		int money = sc.nextInt();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		Collections.reverse(arr);
		for (int i = 0; i < arr.size(); i++) {
			ans += money/arr.get(i);
			money %= arr.get(i);
		}
		
		System.out.print(ans);
	}

}
