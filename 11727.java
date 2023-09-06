import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		
		int n = sc.nextInt();
		arr.add(1);
		for (int i = 1; i < n; i++) {
			if (i % 2 == 1)
				arr.add((arr.get(i-1)*2 + 1)%10007);
			else
				arr.add((arr.get(i-1)*2 - 1)%10007);
		}
		System.out.print(arr.get(n-1));
		sc.close();
	}
}