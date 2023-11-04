import java.util.*;

class Main {
	private static int N, M, CNT = 0;
	private static int[] arr;
	private static ArrayList<Integer> list = new ArrayList<>();
	private static Set<int[]> set = new HashSet<>();
    public static void main(String[] args) {	
        Scanner sc = new Scanner(System.in);
        
        Set<int[]> set = new HashSet<>();
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        int[] visited = new int[N];
        int[] bucket = new int[N+1];
        for (int i = 0; i < N; i++) {
        	int input = sc.nextInt();
        	arr[i] = input;
        }
        for (int cnt = 1; cnt <= N; cnt++)
        	comb(visited, 0, 0, cnt, bucket);
        System.out.print(CNT);
        sc.close();
    }
    public static void comb(int[] visited, int start, int tmpCnt, int cnt, int[] bucket) {
    	if (tmpCnt == cnt) {
    		int sum = 0;
    		for (int i = 0; i < N; i++) {
    			if (visited[i] == 1) {
    				sum += arr[i];
    			}
    		}
    		if (sum == M) {
    			CNT++;
    		}
    		return;
    	}
    	for (int i = start; i < N; i++) {
    		if (visited[i] == 0 && tmpCnt == 0) {
    			visited[i] = 1;
    			bucket[tmpCnt] = i;
    			comb(visited, start+1, tmpCnt+1, cnt, bucket);
    			visited[i] = 0;
    		}
    		else if (visited[i] == 0 && tmpCnt > 0 && bucket[tmpCnt-1] <= i) {
    			visited[i] = 1;
    			bucket[tmpCnt] = i;
    			comb(visited, start+1, tmpCnt+1, cnt, bucket);
    			visited[i] = 0;
    		}
    	}
    }
}