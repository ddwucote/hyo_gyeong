import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
		
		int num = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < num; i++) {
			int input = sc.nextInt();
			if (input == 0 && priorityQueueHighest.isEmpty())
				sb.append(0).append("\n");
			else if (input == 0)
				sb.append(priorityQueueHighest.poll()).append("\n");
			else
				priorityQueueHighest.add(input);
		}
		System.out.print(sb);
		sc.close();
        
	}

}
