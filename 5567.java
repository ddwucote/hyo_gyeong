import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Set<Integer>> friends = new ArrayList<>();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] visited = new int[n+1];
		for (int i = 0; i <= n; i++)
			friends.add(new HashSet<Integer>());
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
            friends.get(b).add(a);
			friends.get(a).add(b);
			if (a == 1) {
				visited[1] = 1;
                if (visited[b] == 0){
				    queue.add(b);
				    visited[b] = 1;
                }
			}
		}
		if (friends.get(1).size() == 0) {
			System.out.print("0");
			return;
		}
        
		int ans = friends.get(1).size();
		while(!queue.isEmpty()) {
			int q = queue.poll();
			for (Integer i : friends.get(q)) {
				if (visited[i] == 0) {
					visited[i] = 1;
					ans++;
				}
			}
		}
		System.out.print(ans);
	}
}