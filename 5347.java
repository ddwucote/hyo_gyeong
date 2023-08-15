import java.util.*;
public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	StringBuilder sb = new StringBuilder();
    	
    	int cnt = sc.nextInt();
    	
    	for (int k = 0; k < cnt; k++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			sc.nextLine();
			int i;
			int smallest = (n1 > n2 ? n2 : n1);
			for (i = smallest; i > 0; i--)
				if (n1 % i == 0 && n2 % i == 0) {
					break;
				}
			// int의 곱이 int범위를 벗어나기 때문에 long으로 형변환 해줘야함. 아님 음수 들어감
			sb.append((long)i*(n1/i)*(n2/i)).append("\n");
    	}
    	System.out.print(sb);
        sc.close();
    }
}