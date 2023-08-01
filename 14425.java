import java.util.*;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<>();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int rslt = 0;
		sc.nextLine();
		for (int i = 0; i < N; i++)
			map.put(sc.nextLine(), "0");
		for (int i = 0; i < M; i++) {
			String str = sc.nextLine();
			if (map.containsKey(str)) {
				rslt++;
			}
		}
		System.out.print(rslt);
		sc.close();
        
	}

}
