import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeMap<Integer,Integer> map = new TreeMap<>();
		
		int num = sc.nextInt();
		map.put(1,0); // !!! 이미 1이니까 계산 안하지~..

		for (int i = 2; i <= num; i++) {
			map.put(i, map.get(i-1)+1); // 우선 직전의 값 + 1 을 넣음
			if (i % 3 == 0) { // 3의 배수일 때
				if (map.get(i/3)+1 < map.get(i)) // 이미 들어가 있는 값, 즉 직전값+1 보다 작으면
					map.put(i, map.get(i/3)+1); // 바꿔주기
			}
			if (i % 2 == 0) { // 2의 배수일 때, 6의 배수일 때 3,2 모두 봐야 하니까 else if안씀
				if (map.get(i/2)+1 < map.get(i)) // 이미 들어가 있는 값, 즉 직전값+1 보다 작으면
					map.put(i, map.get(i/2)+1); // 바꿔주기
			}
		}
		System.out.print(map.get(num));
        sc.close();
	}

}