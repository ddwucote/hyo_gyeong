package test;
import java.util.*;
//21939
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		TreeMap<String, String> map = new TreeMap<>(Collections.reverseOrder());
		TreeMap<String, String> history = new TreeMap<>();
		
		int num = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < num; i++) {
			String q_num = sc.next();
			String level = sc.next();
			sc.nextLine();
			map.put(level+" "+q_num, q_num);
			history.put(q_num, level);
		}
		num = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < num; i++) {
			String s = sc.next();
			if (s.equals("add")) {
				String q = sc.next();
				String level = sc.next();
				sc.nextLine();
				map.put(level+" "+q, q);
			}
			if (s.equals("recommend")) {
				int x = sc.nextInt();
				sc.nextLine();
				if (x == -1)
					sb.append(map.lastKey().split(" ")[1]).append("\n");
				else
					sb.append(map.firstKey().split(" ")[1]).append("\n");
			}
			if (s.equals("solved")) {
				String q = sc.next();
				q = history.get(q)+" "+q;
				sc.nextLine();
				map.remove(q);
			}
		}
		System.out.print(sb);
		sc.close();
        
	}

}
