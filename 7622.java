import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int num = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < num; i++) {
			TreeMap <Integer, Integer> map = new TreeMap<>(); //오름차순
			
			int data_num = sc.nextInt();
			sc.nextLine();
			for (int k = 0; k < data_num; k++){
				String s = sc.next();
				int n = sc.nextInt();
				sc.nextLine();
				
				if (s.equals("I")) { //값, 알파벳 으로 값 삽입
					map.put(n, map.getOrDefault(n, 0)+1);
				}
				else {
					if (map.isEmpty()) //빈 경우 무시
						continue;
					int key = n == 1 ? map.lastKey() : map.firstKey();
					int cnt = map.get(key);
					if (cnt == 1) { //가장 작은 원소 제거
						map.remove(key);
					} 
					else { //가장 큰 원소 제거
						map.put(key, cnt-1);
					}
				}

			}
			if (map.isEmpty())
				sb.append("EMPTY\n");
			else
				sb.append(map.lastKey()+" "+map.firstKey()+"\n"); //최대, 최소
		}
		System.out.println(sb);
		sc.close();
        
	}

}
