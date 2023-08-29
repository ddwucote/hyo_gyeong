import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(1, 1);
		map.put(2, 2);
		
		int n = sc.nextInt();
		for (int i = 3; i <= n; i++)
			map.put(i, (map.get(i-1)+map.get(i-2)) % 10007);
		
		System.out.print(map.get(n));
		sc.close();
	}

}