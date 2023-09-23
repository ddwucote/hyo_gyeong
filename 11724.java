import java.util.*;
import java.io.*;
public class Main {
	
	private static Queue<Integer> queue = new LinkedList<>();
	private static int[] visited;
	private static TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map.put(u, map.getOrDefault(u, new ArrayList<Integer>()));
			map.get(u).add(v);
			map.put(v, map.getOrDefault(v, new ArrayList<Integer>()));
			map.get(v).add(u);
		}
		int ans = 0;
		for (int i = 1; i < visited.length; i++) {
			if (visited[i] == 0) {
				queue.add(i);
				bfs(map, visited);
				ans++;
			}
		}
		System.out.print(ans);
	}
	public static void bfs(TreeMap<Integer, ArrayList<Integer>> map, int[] visited) {
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			ArrayList<Integer> arr = map.get(tmp);
			if (arr != null) {
				for (Integer i : arr) {
					if (visited[i] == 0) {
						visited[i] = 1;
						queue.add(i);
					}
				}
			}
		}
		
	}
}





