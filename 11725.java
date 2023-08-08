import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		TreeMap<Integer, ArrayList<Integer>> tree = new TreeMap<>();
		
		int n = sc.nextInt(); //노드의 개수
		sc.nextLine();

		for (int i = 1; i <= n; i++) //트리구조를 표현할 그래프 초기화
			tree.put(i, new ArrayList<>());

		for (int i = 0; i < n-1; i++) { //그래프 입력 n-1번
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			//해당노드 각각에 연관성 넣어줌
			tree.get(n1).add(n2); //해당 노드 array에 추가
			tree.get(n2).add(n1);
		}
		
		int[] visited = new int[n+1]; // 방문여부 확인, 가지 array에서 부모 노드 제거
		int[] parentNode = new int[n+1]; // 부모 노드 저장

		// BFS : 너비 우선 탐색
		Queue<Integer> queue = new LinkedList<>(); // 노드 직은 순서대로 해당 부모를 구해야하니까
		queue.add(1); //루트 노드 넣기
		visited[1] = 1;
		while (!queue.isEmpty()) {
			int v = queue.remove(); //부모 노드 
			for (int node : tree.get(v)) //해당 노드와 연결된 모든 노드 가져옴
				if (visited[node] != 1) { //방문한 적 없는 해당 노드의 자식 노드
					visited[node] = 1;
					queue.add(node); //방문한 노드(자식노드) 순서대로 넣기
					parentNode[node] = v; // 부모 노드 찾은 후 저장
				}
		}

		// 루트 노드를 제외한 나머지 노드의 부모 노드 출력
		for (int i = 2; i <= n; i++)
			sb.append(parentNode[i]).append("\n");
		System.out.print(sb);
		sc.close();
	}

}