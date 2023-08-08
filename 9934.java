import java.util.*;

public class Main {
	// 다른 함수에서도 사용해야 하기때문에 전역으로 선언
	static List<ArrayList<Integer>> list = new ArrayList<>();
	static int[] arr;
	static int depth;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		depth = sc.nextInt();
		sc.nextLine();
		int size = (int)Math.pow(2, depth) - 1; //depth에 따른 완전 이진 트리의 노드의 개수
		
		arr = new int[size];
		for (int i = 0; i < size; i++) //입력값 읽고 저장
			arr[i] = sc.nextInt();
		
		for (int i = 0; i < depth; i++) //depth만큼 arraylist생성
			list.add(new ArrayList<>());
		
		//제귀로 왼쪽 오른쪽 반반씩 나눠서 해당 깊이에 맞는 중간값 list에 넣을 것
		solution(0, size-1, 0); //시작인덱스, 끝인덱스, 깊이
		
		// 출력
        for (int i = 0; i < depth; i++) {
            for (int j : list.get(i)) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
		sc.close();
	}
	
	public static void solution(int s_idx, int e_idx, int dth) {
		if (dth == depth)
			return;
		
		int mid_idx = (s_idx+e_idx)/2;
		
		list.get(dth).add(arr[mid_idx]);
		solution(s_idx, mid_idx-1, dth+1);
		solution(mid_idx+1, e_idx, dth+1);
	}

}