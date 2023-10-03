import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<ArrayList<Integer>> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> change = new ArrayList<>();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] visited = new int[n+1];
		for (int i = 0; i <= n; i++) {
			change.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			change.get(t1).add(t2);
			change.get(t2).add(t1);
		}
        if (a == b){
            System.out.print("0");
            return;
        }
		ArrayList<Integer> tmp = new ArrayList<>();
		tmp.add(a);
		queue.add(tmp);
		visited[a] = 1;
		int cnt = 0;
		while (!queue.isEmpty()) {
			ArrayList<Integer> arr = queue.poll();
			tmp = new ArrayList<>();
			for (Integer i : arr) {
				visited[i] = 1;
			}
			for (Integer i : arr) {
				if (i == b) {
					System.out.print(cnt);
					return;
				}
				ArrayList<Integer> c = change.get(i);
				if (!c.isEmpty())
					for (Integer i2 : c) {
						if (visited[i2] == 0) {
							tmp.add(i2);
							visited[i2] = 1;
						}
					}
			}
            if (!tmp.isEmpty())
			    queue.add(tmp);
			cnt++;
		}
		System.out.print("-1");
	}
}