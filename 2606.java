import java.util.*;

public class Main {
	private static HashSet<Integer> ans = new HashSet<>();
	private static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int computer = sc.nextInt();
		for (int i = 0; i < computer; i++) {
			map.put(i+1, new ArrayList<Integer>());
		}
		int n = sc.nextInt();
        if (n == 0){
            System.out.print("0");
            return;
        }
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			int v = sc.nextInt();
			map.get(k).add(v);
			map.get(v).add(k);
		}
		cnt(map.get(1));
		System.out.print(ans.size()-1);
		sc.close();
	}
	public static void cnt(ArrayList<Integer> list) {
		for (Integer i : list) {
			if (!ans.contains(i)) {
				ans.add(i);
				cnt(map.get(i));
			}			
		}
	}
}


