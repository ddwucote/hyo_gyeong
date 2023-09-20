import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<String> queue = new LinkedList<>();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String input = sc.next();
			String[] str = input.split("");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		queue.add("0,0");
		String map = queue.poll();
		while (map != null) {
			int k = Integer.parseInt(map.split(",")[0]);
			int v = Integer.parseInt(map.split(",")[1]);
			if (k == n-1 && v == m-1) {
				System.out.print(arr[n-1][m-1]);
				break;
			}
			TreeMap<Integer, Integer> tmp = new TreeMap<>();
			if (k+1 < n && arr[k+1][v] == 1) { // 아래				
				tmp.put(k+1, v);
				arr[k+1][v] = arr[k][v]+1;
				queue.add((k+1)+","+v);
			}
			if (v+1 < m && arr[k][v+1] == 1) { // 오른쪽			
				tmp.put(k, v+1);
				arr[k][v+1] = arr[k][v]+1;
				queue.add(k+","+(v+1));
			}
            // 왼쪽도 생각하자...
            if (v-1 >= 0 && arr[k][v-1] == 1) { // 왼쪽			
				tmp.put(k, v-1);
				arr[k][v-1] = arr[k][v]+1;
				queue.add(k+","+(v-1));
			}
			if (k-1 >= 0 && arr[k-1][v] == 1 && k != 0 && v != 0) {	// 위			
				tmp.put(k-1, v);
				arr[k-1][v] = arr[k][v]+1;
				queue.add((k-1)+","+v);
			}
			map = queue.poll();
		}
	}

}