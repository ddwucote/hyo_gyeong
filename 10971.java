import java.util.*;

class Main {
	private static int N;
	private static int ANSWER = Integer.MAX_VALUE;
	private static int[][] arr;
	private static int[][] visited;
    public static void main(String[] args) {	
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        arr = new int[N+1][N+1];
        visited = new int[N+1][N+1];
        List<Integer> nodes = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= N; j++) {
        		arr[i][j] = sc.nextInt(); 
        	}
        }
        for (int i = 1; i <= N; i++) {
        	nodes.add(i);
        	visitCity(i, nodes);
            nodes.clear();
        }      
        System.out.print(ANSWER);
        sc.close();
    }
    public static void visitCity(int start, List<Integer> nodes) {
    	if (nodes.size() == N && arr[nodes.get(N-1)][nodes.get(0)] != 0) { // 모든 노드를 방문했을 때
            int sum = 0;
    		for (int i = 0; i < N-1; i++) {
    			sum += arr[nodes.get(i)][nodes.get(i+1)];
    		}
    		sum += arr[nodes.get(N-1)][nodes.get(0)];
    		ANSWER = Math.min(ANSWER, sum);
    		return;
    	}
        for (int j = 1; j <= N; j++) {
			if (start == j || arr[start][j] == 0) {
			    continue;
			}
			if (!nodes.contains(j)) {
				nodes.add(j);
				visitCity(j, nodes);
				nodes.remove(nodes.size()-1);
		    }
        }
    }
}