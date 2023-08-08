//copy code
import java.util.*;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, Integer> vertex; //정점의 개수를 센다
        int count = 1; //case의 순서를 센다
        
        while(true) {
            vertex = new HashMap<>();
            int edge = 0; //간선의 수
            while(true) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                
                if(start == -1 && end == -1) return;
                else if(start == 0 && end == 0) break;
 
                vertex.put(start, vertex.getOrDefault(start, 0));
                vertex.put(end, vertex.getOrDefault(end, 0) + 1);
                edge++;
            }
            
            int root = 0;
            boolean isTrue = true;
            Iterator<Integer> key = vertex.keySet().iterator();
            while(key.hasNext()) {
                int num = key.next();
                if(vertex.get(num) == 0) root++;
                else if(vertex.get(num) > 1) {
                    isTrue = false;
                    break;
                }
            }
            
            if(vertex.size() == 0) {
                System.out.println("Case " + count + " is a tree.");
            }
            else if(isTrue && root == 1 && edge == vertex.size() - 1) {
                System.out.println("Case " + count + " is a tree.");
            } else {
                System.out.println("Case " + count + " is not a tree.");
            }
            count++;
        }
    }
}