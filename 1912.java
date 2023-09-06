import java.util.*;
// 검색함

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> maxArr = new ArrayList<>();
		
		int n = sc.nextInt();
		arr.add(sc.nextInt());
		int max = arr.get(0);
		maxArr.add(max);
		for (int i = 1; i < n; i++) {
			int t1 = sc.nextInt(); // 나 자신
			arr.add(t1);
			int t2 = arr.get(i-1)+t1; // 나와 나의 앞의 값들의 합
			int t3 = max+t1;
			max = Math.max(Math.max(t1, t2), t3);
			maxArr.add(max);
		}
		Collections.sort(maxArr);
		System.out.print(maxArr.get(maxArr.size()-1));
		
		sc.close();
	}
}