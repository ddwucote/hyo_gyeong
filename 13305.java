import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Long> road = new ArrayList<>();
		ArrayList<Long> city = new ArrayList<>();
		long ans = 0;
		
		int n = sc.nextInt();
		for (int i = 0; i < n-1; i++) {
			road.add(sc.nextLong());
		}
		for (int i = 0; i < n; i++) {
			long input = sc.nextLong();
			if (i == 0 || input < city.get(i-1))
				city.add(input);
			else
				city.add(city.get(i-1));
		}
		for (int i = 0; i < n-1; i++) {
			ans += road.get(i)*city.get(i);
		}
		System.out.print(ans);
		sc.close();
	}

}