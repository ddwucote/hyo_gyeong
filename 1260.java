import java.util.*;

public class Main {
	private static ArrayList<Integer> ans = new ArrayList<>();
	private static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int node = sc.nextInt();
		for (int i = 0; i < node; i++) {
			map.put(i+1, new ArrayList<Integer>());
		}
		int num = sc.nextInt();
		int root = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int k = sc.nextInt();
			int v = sc.nextInt();
			map.get(k).add(v);
			map.get(v).add(k);
		}
		ans.add(root);
		Collections.sort(map.get(root));
		DFS(map.get(root));
		for (Integer i : ans)
			sb.append(i+" ");
		System.out.println(sb);
		
		sb = new StringBuilder();
		ans.clear();
		ans.add(root);
		Collections.sort(map.get(root));
		BFS(map.get(root));
		for (Integer i : ans)
			sb.append(i+" ");
		System.out.println(sb);
		sc.close();
	}
	public static void DFS(ArrayList<Integer> list) {
		Collections.sort(list);
		for (Integer i : list) {
			if (!ans.contains(i)) {
				ans.add(i);
				DFS(map.get(i));
			}			
		}
	}
	public static void BFS(ArrayList<Integer> list) {
		int size = ans.size();
		for (Integer i : list)
			if (!ans.contains(i)) {
				ans.add(i);
			}
		if (size != ans.size()) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for (Integer i : list) {
				ArrayList<Integer> t = map.get(i);
				Collections.sort(t);
				tmp.addAll(t);		
			}
			BFS(tmp);
		}
	}
}


