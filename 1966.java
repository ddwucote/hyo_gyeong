import java.util.*;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int cases = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < cases; i++) {
			Queue<String> q = new LinkedList<>();
			ArrayList<Integer> arr = new ArrayList<>();
			int documents = sc.nextInt();
			int idx = sc.nextInt(); 
			int count = 0;
			sc.nextLine();
			for(int k = 0; k < documents; k++) {
				int importance = sc.nextInt();
				q.offer(k+","+importance);
				arr.add(importance);
			}
			Collections.sort(arr, Collections.reverseOrder());
			while(true) {
				int k = Integer.parseInt(q.peek().split(",")[0]);
				int v = Integer.parseInt(q.peek().split(",")[1]);
				if (k == idx && arr.get(0) == v) {
					count++;
					sb.append(count).append("\n");
					break;
				}
				if (arr.get(0) == v) {
					q.poll();
					count++;
					arr.remove(0);
					continue;
				}
				q.offer(q.poll()); //뺴서 맨 뒤로
				
			}
			System.out.print(sb);
		}
		sc.close();
        
	}

}
