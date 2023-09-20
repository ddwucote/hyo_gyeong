import java.util.*;
public class Main {
	private static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> ansArr = new ArrayList<>();
		int total = 0;
		
		int n = sc.nextInt();
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String input = sc.next();
			String[] str = input.split("");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] > 0) {
					arr[i][j] = -1;
					ansArr.add(calc(arr, i, j, n));
					total++;
				}
			}
		}
		Collections.sort(ansArr);
		System.out.println(total);
        if (total == 0)
            System.out.println("0");
		for (Integer i : ansArr)
			System.out.println(i);
	}
	
	public static void print(int[][] arr, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	public static int calc(int[][] arr, int i, int j, int n) {
		int x, y;
		int cnt = 1;
		Queue<String> queue = new LinkedList<>();
		queue.add(i+","+j);
		while (!queue.isEmpty()) {
			String[] str = queue.poll().split(",");
			x = Integer.parseInt(str[0]);
			y = Integer.parseInt(str[1]);
			if (x-1 >= 0) {
				if (arr[x-1][y] > 0) {
					cnt++;
					arr[x-1][y] = -1;
					queue.add((x-1)+","+y);
				}
				
			}
			if (y+1 < n) {
				if (arr[x][y+1] > 0) {
					cnt++;
					arr[x][y+1] = -1;
					queue.add(x+","+(y+1));
				}
				
			}
			if (x+1 < n) {
				if (arr[x+1][y] > 0) {
					cnt++;
					arr[x+1][y] = -1;
					queue.add((x+1)+","+y);
				}
				
			}
			if (y-1 >= 0) {
				if (arr[x][y-1] > 0) {
					cnt++;
					arr[x][y-1] = -1;
					queue.add(x+","+(y-1));
				}
				
			}
		}
		return cnt;
	}
}


