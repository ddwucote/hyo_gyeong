import java.util.*;
public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

    	int ans = 0;
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
        	int input = sc.nextInt();
        	if (input == 1)
        		continue;
        	int flag = 1;
        	for (int k = 2; k <= Math.sqrt(input); k++) {
        		if (input % k == 0) {
        			flag = 0;
        			break;
        		}
        	}
        	if (flag == 1)
        		ans++;
        }
        System.out.print(ans);
        sc.close();
    }
}