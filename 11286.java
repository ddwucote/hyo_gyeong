//copy code
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        	//오름차순이 기본 즉, 작은 수 부터 내보냄
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() { //우선순위큐 내부의 정렬 로직 수정
			@Override
			public int compare(Integer o1, Integer o2) {
				//절대값 기준으로 앞 값이 더 크다면 자리를 바꿔준다. -> 절대값이 작은 값이 우선
				if(Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				//절대값 기준으로 두 값이 같다면 음수를 앞으로 보내준다.
                		// 1, -1 -> 2:자리 바꿈, -1, 1 -> -2:자리안바꿈 -> 음수가 우선
				}else if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}else { //음수 : 두 원소 위치 바꾸지 않음
					return -1;
				}
			}
		});
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) sb.append("0").append("\n");
				else sb.append(pq.poll()).append("\n");
			}else {
				pq.offer(x);
			}
		}
		System.out.println(sb);
	}

}
