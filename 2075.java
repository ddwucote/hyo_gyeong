import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeMap<Integer, Integer> arr = new TreeMap<>(Collections.reverseOrder());
		
		int num = sc.nextInt();
		sc.nextLine();
        for (int i = 0; i < num; i++)
            arr.put(sc.nextInt(), i);
        //메모리 초과를 방치하기 위해서 N개의 데이터만 남기고 보지 않을 데이터는 삭제
		for (int i = num; i < num*num; i++) {
			arr.put(sc.nextInt(), i);
		    arr.pollLastEntry();
		}
		for (int i = 0; i < num-1; i++)
			arr.pollFirstEntry();
		
		System.out.print(arr.firstKey());
		sc.close();
        
	}

}
