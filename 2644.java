import java.util.*;
import java.io.*;
public class Main {
		
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		TreeMap<Integer, ArrayList<Integer>> children = new TreeMap<>();
		TreeMap<Integer, Integer> parent = new TreeMap<>();
		Queue<Integer> queue = new LinkedList<>();
		
		int n = sc.nextInt();
		int t1 = sc.nextInt();
		int t2 = sc.nextInt();
		int m = sc.nextInt();
		int[] target = new int[] {t1, t2, t1};
		for (int i = 0; i < m; i++) {
			int p = sc.nextInt();
			int c = sc.nextInt();
			children.put(p, children.getOrDefault(p, new ArrayList<Integer>()));
			children.get(p).add(c);
			parent.put(c, p);
		}
		
		
		int relation = 0;
		
		// 직속
		for (int i = 0; i < 2; i++) { 
			relation = 0;
			int p = target[i];
			while (parent.get(p) != null) {
				relation++;
				if (parent.get(p) == target[i+1]) {
					System.out.print(relation);
					return;
				}
				p = parent.get(p);
			}
		}
		
		// 직속아님
		ArrayList<Integer> t1Parent = new ArrayList<>();
		ArrayList<Integer> t2Parent = new ArrayList<>();
		t1Parent.add(-1);
		t2Parent.add(-2);
		int current = t1;
		while (parent.get(current) != null) {
			t1Parent.add(parent.get(current));
			current = parent.get(current);
		}
		current = t2;
		while (parent.get(current) != null) {
			t2Parent.add(parent.get(current));
			current = parent.get(current);
		}
		for (int i = 0; i < t1Parent.size(); i++) {
			for (int j = 0; j < t2Parent.size(); j++) {
				if (t1Parent.get(i) == t2Parent.get(j)) {
					System.out.print(i+j);
					return;
				}
			}
		}
		
		System.out.print("-1");
	}
}





