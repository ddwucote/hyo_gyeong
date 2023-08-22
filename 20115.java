import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		
		int n = sc.nextInt();
		int max = 0;
		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();
			arr.add(input);
			if (max < input)
				max = input;
		}
		double ans = max;
		arr.remove(Integer.valueOf(max));
		for (int i = 0; i < arr.size(); i++) {
			ans += arr.get(i)/(double)2;
		}
		sc.close();
		System.out.print(ans);
	}

}


