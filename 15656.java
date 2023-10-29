import java.util.*;
import java.io.*;

class Main {
	private static int N;
	private static int M;
	private static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws IOException {	
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> tmp = new ArrayList<>();
        N = sc.nextInt();
        M = sc.nextInt();
        int[] arr = new int[N+1];
        for (int i = 0; i < N; i++)
        	tmp.add(sc.nextInt());
        Collections.sort(tmp);
        for (int i = 0; i < N; i++)
        	 arr[i] = tmp.get(i);
        int[] answer = new int[M];
        comb(0, arr, answer);
        System.out.print(ans);
    }
    public static void comb(int cnt, int[] arr, int[] answer) {
    	if (cnt == M) {
    		StringBuilder tmp = new StringBuilder();
    		for (int i = 0; i < M; i++)
    			tmp.append(answer[i]).append(" ");
    		ans.append(tmp).append("\n");
    		return;
    	}
		for (int i = 0; i < N; i++) {
			answer[cnt] = arr[i];
			comb(cnt+1, arr, answer);
		}
    }
}