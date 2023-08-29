import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		TreeMap<Integer, Integer> tree = new TreeMap<>();
		tree.put(1,1);
		tree.put(2,2);
		tree.put(3,4);
		
		for (int i = 4; i < 11; i++) {
			tree.put(i, tree.get(i-1) + tree.get(i-2) + tree.get(i-3));
		}
		
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			sb.append(tree.get(sc.nextInt()) + "\n");
		}
		
		System.out.print(sb);
		sc.close();
	}

}