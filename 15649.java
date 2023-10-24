import java.util.*;
import java.io.*;

class Main {
	private static int N;
	private static int M;
    public static void main(String[] args) throws IOException {	
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[] visited = new int[N+1];
        int[] arr = new int[N+1];
        permutation(visited, 0, 0, arr);
    }
    public static void permutation(int[] visited, int cnt, int start, int[] arr) {
    	if (cnt == M) {
    		StringBuilder sb = new StringBuilder();
    		for (int i = 0; i < cnt; i++)
    			sb.append(arr[i]+" ");
    		System.out.println(sb);
    		return;
    	}
		for (int i = 1; i <= N; i++) {
    		if (visited[i] == 0) {
    			visited[i] = 1;
    			arr[start] = i;
    			permutation(visited, cnt+1, start+1, arr);
    			visited[i] = 0;
    		}
		}
    }
}