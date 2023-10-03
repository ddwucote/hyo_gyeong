import java.util.*;
import java.io.*;
public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int[] visited;
    static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] answer = new int[n+1];
        
		int biggest = Integer.MIN_VALUE;
		for (int i = 0; i <= n; i++) {
			arrayList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			if (c1 != c2) {
				arrayList.get(c2).add(c1);
			}
		}
		for (int i = 1; i <= n; i++) {
			visited = new int[n+1];
            result = 0;
			visited[i] = 1;
			bfs(i);	
			answer[i] = result;
			biggest = Math.max(biggest, result);
		}
        for (int i = 1; i <= n; i++)
            if (answer[i] == biggest)
            	sb.append(i+" ");
		System.out.print(sb);
	}
	
	public static void bfs(int i) {
		queue.add(i);
		while(!queue.isEmpty()) {
			int k = queue.poll();
			result++;
			for (Integer a : arrayList.get(k)) {
				if (visited[a] == 0) {
					visited[a] = 1;
					result++;
					queue.add(a);
				}
			}
		}
	}
}

