import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		int n = sc.nextInt();
		int[] visited = new int[n+1];
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		int start = sc.nextInt();
		queue.add(start);
		while (!queue.isEmpty()) {
			int q = queue.poll();
			if (q >= 0 && q <= n && visited[q] == 0) {
				visited[q] = 1;
				queue.add(q+arr[q]);
				queue.add(q-arr[q]);
			}
		}
		int ans = 0;
		for (int i = 1; i <= n; i++)
			if (visited[i] == 1)
				ans++;
		System.out.print(ans);
	}
}