import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> stair = new ArrayList<>();
		ArrayList<Integer> maxSum = new ArrayList<>();
		
		int cnt = sc.nextInt();
		stair.add(0); // index = 0값 채워줌
		for (int i = 0; i < cnt; i++)
			stair.add(sc.nextInt());
		
		if (cnt == 1) {
			System.out.print(stair.get(1));
			sc.close();
			return;
		}
		if (cnt == 2) {
			System.out.print(stair.get(1)+stair.get(2));
			sc.close();
			return;
		}
		
		maxSum.add(0); // 시작점
		maxSum.add(stair.get(1)); // 계단 1개
		maxSum.add(stair.get(1) + stair.get(2)); // 계단 2개
		for (int i = 3; i <= cnt; i++)	
			maxSum.add(Math.max(stair.get(i-1)+maxSum.get(i-3), maxSum.get(i-2)) + stair.get(i));
		System.out.print(maxSum.get(cnt));
		sc.close();
	}

}