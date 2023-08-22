import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Long> arr = new ArrayList<>();
		
		long max = 0;
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextLong());
		}
		Collections.sort(arr);
		if (n%2 == 1) {
			max = arr.get(n-1);
			arr.remove(n-1);
		}
		for (int i = 0; i < arr.size()/2; i++) {
			if (arr.get(i)+arr.get(arr.size()-1-i) > max)
				max = arr.get(i)+arr.get(arr.size()-1-i);
		}
		System.out.print(max);
		sc.close();
	}

}