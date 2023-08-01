import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder answer = new StringBuilder();
		
		int cnt = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < cnt; i++) {
			StringBuilder sb = new StringBuilder();
			ArrayList<Integer> arr = new ArrayList<>();
			int num = sc.nextInt();
			sc.nextLine();
			sb.append((num+1)/2+"\n");
			int c = 0;
			for (int k = 0; k < num; k++) {
				int temp = sc.nextInt();
				arr.add(temp);
				Collections.sort(arr);
				if (k % 2 == 0) {
					sb.append(arr.get(k/2));
					c++;
					if (c == 10) {
						sb.append("\n");
						c = 0;
					}
					else if (k != num-1) {
						sb.append(" ");
					}
				}
				
			}
			answer.append(sb);
			if (i != cnt-1)
				answer.append("\n");
		}
		System.out.print(answer);
		sc.close();
        
	}

}
