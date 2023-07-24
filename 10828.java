import java.util.Stack;
import java.util.Scanner;

public class Main {

    public static void main(String args[]){
    
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
    
        int cnt = sc.nextInt();
        while (cnt >= 0){
            String input = sc.nextLine();
            if (input.startsWith("push")){
                stack.push(Integer.valueOf(Integer.parseInt(input.split(" ")[1])));
            }
            else if (input.startsWith("pop")){
                if (stack.empty()){
                    sb.append("-1\n");
                }
                else {
                    sb.append(stack.pop()).append("\n");
                }
            }
            else if (input.startsWith("size")){
                sb.append(stack.size()).append("\n");
            }
            else if (input.startsWith("empty")){
                if (stack.empty()){
                    sb.append("1\n");
                }
                else {
                    sb.append("0\n");
                }
            }
            else if (input.startsWith("top")){
                if (stack.empty()){
                    sb.append("-1\n");
                }
                else {
                    sb.append(stack.peek()).append("\n");
                }
            }
            cnt--;
        }
        System.out.print(sb);
        sc.close();
    }
        

}