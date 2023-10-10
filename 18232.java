import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Queue<ArrayList<Integer>> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> port = new ArrayList<>();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		int e = sc.nextInt();
		
		int[] visited = new int[n+1];
		for (int i = 0; i <= n; i++) { //init
			port.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
			port.get(x).add(y);
            port.get(y).add(x);
		}
		ArrayList<Integer> tmp = new ArrayList<>();
		tmp.add(s);
		queue.add(tmp);
		visited[s] = 1;
		int cnt = 0;
		while(!queue.isEmpty()) {
			ArrayList<Integer> arr = queue.poll();
			tmp = new ArrayList<>();
			for (Integer i : arr) {
				if (i == e) {
					System.out.print(cnt);
					sc.close();
					return;
				}
				if (i-1 > 0 && visited[i-1] == 0) { // 왼쪽
					tmp.add(i-1);
					visited[i-1] = 1;
				}
				if (i+1 <= n && visited[i+1] == 0) { //오른쪽
					tmp.add(i+1);
					visited[i+1] = 1;
				}
				ArrayList<Integer> p = port.get(i); //텔레포트
				if (!p.isEmpty()) {
					for (Integer i2 : p) {
						if (visited[i2] == 0) {
							tmp.add(i2);
							visited[i2] = 1;
						}
					}
				}
			}
            if (!tmp.isEmpty())
			    queue.add(tmp);
			cnt++;
		}
		sc.close();
	}
}