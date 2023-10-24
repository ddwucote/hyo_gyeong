import java.util.*;
import java.io.*;

class Main {
	private static int N;
	private static int M;
	private static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws IOException {	
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[] visited = new int[N+1];
        int[] arr = new int[N+1];
        comb(visited, 0, arr);
        System.out.print(ans);
    }
    public static void comb(int[] visited, int cnt, int[] arr) {
    	if (cnt == M) {
    		StringBuilder tmp = new StringBuilder();
    		for (int i = 0; i < M; i++)
    			tmp.append(arr[i]).append(" ");
    		ans.append(tmp).append("\n");
    		return;
    	}
		for (int i = 1; i <= N; i++) {
			arr[cnt] = i;
			comb(visited, cnt+1, arr);
		}
    }
}