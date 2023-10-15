import java.util.*;
class Main {
	
	private static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	private static int N = 0;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int n = sc.nextInt();
        N = n;
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
        	arr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	arr.get(a).add(b);
        	arr.get(b).add(a);
        }
                
        for (int i = 0; i < n; i++) {
        	int[] visited = new int[n];
        	visited[i] = 1;
        	if (dfs(i, visited, 1)) {
        		System.out.print(1);
        		return;
        	}
        }
        System.out.print(0);
        sc.close();
        	
    }
    
    public static boolean dfs(int s, int[] visited, int cnt) {
    	if (cnt == 5)
    		return true;
    	
    	if (!arr.get(s).isEmpty()) {
    		for (Integer i : arr.get(s)) {
    			if (visited[i] == 0) {
    				int[] tmpVisited = visited;
                    int tmpCnt = cnt;
    				visited[i] = 1;
    				boolean rslt = dfs(i, visited, cnt+1);
    				if (rslt == true)
    					return true;
    				else {
    					visited = tmpVisited;
                        cnt = tmpCnt;
    				}
    			}
    		}
    	}
    	visited[s] = 0;
    	return false;    	
    }
}