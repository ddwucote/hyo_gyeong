import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException{
    	Scanner sc = new Scanner(System.in);
    	ArrayList<Integer> top = new ArrayList<>();
    	ArrayList<Integer> bottom = new ArrayList<>();
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	StringBuilder sb = new StringBuilder();
    	
    	int n = sc.nextInt();
    	for (int i = 0; i < n; i++) {
    		top.add(i+1);
    		bottom.add(sc.nextInt());
    	}
    	int flag = 1;
    	while (flag == 1) {
    		flag = 0;
    		for (int i = 0; i < n; i++) {
    			if (top.get(i) == -1)
    				continue;
    			if (!bottom.contains(top.get(i))) {
    				top.set(i, -1);
    				bottom.set(i, -1);
    				flag = 1;
    			}
    		}
    	}
    	int cnt = 0;
    	for (int i = 0; i < top.size(); i++) {
    		if (top.get(i) != -1) {
    			pq.add(top.get(i));
    			cnt++;
    		}
    	}
    	sb.append(cnt+"\n");
    	while (!pq.isEmpty()) {
    		sb.append(pq.remove()+"\n");
    	}
    	System.out.print(sb);
    }
}