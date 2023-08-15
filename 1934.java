import java.util.*;
public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	StringBuilder sb = new StringBuilder();

    	int cnt = sc.nextInt();
    	sc.nextLine();
		for (int k = 0; k < cnt; k++) {
			int i;
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			sc.nextLine();
			int smallest = (n1 > n2 ? n2 : n1);
			for (i = smallest; i > 0; i--)
				if (n1 % i == 0 && n2 % i == 0) {
					sb.append(i*(n1/i)*(n2/i)).append("\n");
					break;
				}
		}
		System.out.print(sb);
    	
        sc.close();
    }
}