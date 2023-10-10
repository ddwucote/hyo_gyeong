import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException{
    	Scanner sc = new Scanner(System.in);
    	Queue<ArrayList<int[]>> queue = new LinkedList<>();
    	ArrayList<int[]> arr = new ArrayList<>();
    	ArrayList<Integer> cntMin = new ArrayList<>();
    	
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	
        if (n >= k) {
        	System.out.print(n-k);
        	sc.close();
        	return;
        }
        
    	for (int i = 0; i < 2*k+1; i++)  
    		cntMin.add(Integer.MAX_VALUE);
    	arr.add(new int[] {n, 0});
    	cntMin.set(n, 0);
    	queue.add(arr);
    	while(!queue.isEmpty()) {
    		ArrayList<int[]> q = queue.poll();
            if (!q.isEmpty()){
    		    for (int i = 0; i < q.size(); i++) {
                    int[] tmp = q.get(i);
    			    if (tmp[0]-1 <= k+1 && tmp[0]-1 >= 0 && cntMin.get(tmp[0]-1) > tmp[1]) {
    			    	cntMin.set(tmp[0]-1, tmp[1]+1);
    			    	arr.add(new int[] {tmp[0]-1, tmp[1]+1});
    			    }
    			    if (tmp[0]+1 <= k+1 && tmp[0]+1 >= 0 && cntMin.get(tmp[0]+1) > tmp[1]) {
    			    	cntMin.set(tmp[0]+1, tmp[1]+1);
    			    	arr.add(new int[] {tmp[0]+1, tmp[1]+1});
    			    }
    			    if (2*tmp[0] <= k+1 && 2*tmp[0] >= 0 && cntMin.get(2*tmp[0]) > tmp[1]) {
    			    	cntMin.set(2*tmp[0], tmp[1]);
    			    	arr.add(new int[] {2*tmp[0], tmp[1]});
    			    }
    		    }
            }
    		if (!arr.isEmpty()) {
    			queue.add(arr);
    			arr.clear();
    		}
    	}
    	System.out.print(cntMin.get(k));
    	sc.close();
    }
}