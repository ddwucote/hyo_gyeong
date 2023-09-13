import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			int smallest = Integer.MAX_VALUE;
			int biggest = Integer.MIN_VALUE;
			for (int j = 0; j < m; j++) {
				int input = sc.nextInt();
				if (smallest > input)
					smallest = input;
				if (biggest < input)
					biggest = input;
			}
			sb.append(smallest).append(" ").append(biggest).append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
}