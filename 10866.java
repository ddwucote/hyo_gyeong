import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deq = new LinkedList<>();
       
        int num = sc.nextInt();
        while(num >= 0){
            String str = sc.nextLine();
            String front_str = str.split(" ")[0];
            if (front_str.startsWith("push_back")){
                deq.addLast(Integer.valueOf(str.split(" ")[1]));
            }
            if (front_str.startsWith("push_front")){
                deq.addFirst(Integer.valueOf(str.split(" ")[1]));
            }
            if (front_str.startsWith("front")){
                if (deq.size() == 0)
                    sb.append("-1\n");
                else
                    sb.append(deq.peekFirst()).append("\n");
            }
            if (front_str.startsWith("pop_front")){
            	if (deq.size() == 0)
            		sb.append("-1\n");
            	else{
            		sb.append(deq.peekFirst()).append("\n");
            		deq.pollFirst();
            	}
            }
            if (front_str.startsWith("pop_back")){
            	if (deq.size() == 0)
            		sb.append("-1\n");
            	else{
            		sb.append(deq.peekLast()).append("\n");
            		deq.pollLast();
            	}
            }
            if (front_str.startsWith("size")){
            	sb.append(deq.size()).append("\n");
            }
            if (front_str.startsWith("empty")){
            	if (deq.size() == 0)
            		sb.append("1\n");
            	else
            		sb.append("0\n");
            }
            if (front_str.startsWith("back")){
            	if (deq.size() == 0)
            		sb.append("-1\n");
            	else
            		sb.append(deq.peekLast()).append("\n");
            }
            num--;
        }
        System.out.print(sb);
    }
    
}