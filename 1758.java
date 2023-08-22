import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		
		int n = sc.nextInt();
		long ans = 0;
		for (int i = 0; i < n; i++)
			arr.add(sc.nextInt());
		Collections.sort(arr, Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			if (arr.get(i)-i > 0) 
				ans += arr.get(i)-i;
		}
		System.out.print(ans);
		sc.close();
	}

}


