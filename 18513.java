import java.util.*;
import java.io.*;
class Main {
    
    private static Set<Integer> set = new HashSet<>();
    private static long ANS = 0;
    private static int DIST = 1;
    
    public static void main(String[] args) throws IOException{	
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
        
    	Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
    	
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
        	int input = Integer.parseInt(st.nextToken());
            set.add(input);
            tmp.add(input);
        }
        q.add(tmp);
        Loop:
	// Queue를 사용하지 않고 그냥 for문을 돌아버리면 이미 차 있는 구역에도 계속해서 for문이 돌기 때문에 시간초과가 남!!!!!
        while(!q.isEmpty()) {
        	ArrayList<Integer> arr = q.poll();
        	tmp = new ArrayList<>();
        	for (int i : arr) {
        		int left = i-1;
        		int right = i+1;
                if (!set.contains(left)){
        		    set.add(left);
        		    tmp.add(left);
        			ANS += DIST;
        			k--;
                    if (k == 0)
                        break Loop;
                }
                if (!set.contains(right)){
                    set.add(right);
                    tmp.add(right);
        		    ANS += DIST;
        			k--;
                    if (k == 0)
                        break Loop;
                }
            }
        	if (!tmp.isEmpty()){
        		q.add(tmp);
        	    DIST++;
            }
        }
        System.out.print(ANS);
    }
}