import java.util.*;
import java.io.*;

class Main {
	private static int N;
	private static int M;
	private static StringBuilder ans = new StringBuilder();
	private static ArrayList<String> ansArr = new ArrayList<>();
	private static ArrayList<Integer> tmp = new ArrayList<>();
    public static void main(String[] args) throws IOException {	
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        int[] visited = new int[N+1];
        for (int i = 0; i < N; i++)
        	tmp.add(sc.nextInt());
        Collections.sort(tmp);
        int[] answer = new int[M];
        comb(visited, 0, answer);
        ans = new StringBuilder();
        for (int i = 0; i < ansArr.size()-1; i++)
        	ans.append(ansArr.get(i)).append("\n");
        ans.append(ansArr.get(ansArr.size()-1));
        System.out.print(ans);
        sc.close();
    }
    public static void comb(int[] visited, int cnt, int[] answer) {
    	if (cnt == M) {
    		StringBuilder tmp = new StringBuilder();
    		int i;
    		for (i = 0; i < M-1; i++)
    			tmp.append(answer[i]).append(" ");
    		tmp.append(answer[i]);
    		if (!ansArr.contains(tmp.toString()))
    			ansArr.add(tmp.toString());
    		return;
    	}
		for (int i = 0; i < N; i++) {
			if (visited[i] == 0 && cnt == 0) {
			    answer[cnt] = tmp.get(i);
			    visited[i] = 1;
			    comb(visited, cnt+1, answer);
			    visited[i] = 0;
			}
			else if (visited[i] == 0 && answer[cnt-1] <= tmp.get(i)) {
				answer[cnt] = tmp.get(i);
			    visited[i] = 1;
			    comb(visited, cnt+1, answer);
			    visited[i] = 0;
			}
		}
    }
}