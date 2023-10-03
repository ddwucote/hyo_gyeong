import java.util.*;
import java.io.*;
public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
		for (int i = 0; i <= n; i++) {
			arrayList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			arrayList.get(c1).add(c2);
		}
		visited = new int[n+1];
		bfs(x, k);	
		visited[x] = 0;
		for (int i = 1; i <= n; i++)
			if (visited[i] == k)
				sb.append(i+"\n");
        if (sb.length() == 0)
            System.out.print("-1");
        else
		    System.out.println(sb);
	}
	
	public static void bfs(int x, int k) {
		queue.add(x);
		while(!queue.isEmpty()) {
			int q = queue.poll();
			for (Integer a : arrayList.get(q)) {
				if (visited[a] == 0) {
					visited[a] = visited[q]+1;
					queue.add(a);
				}
			}
		}
	}
}

