import java.util.*;
public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int i;
		int smallest = (n1 > n2 ? n2 : n1);
		for (i = smallest; i > 0; i--)
			if (n1 % i == 0 && n2 % i == 0) {
				System.out.println(i);
				break;
			}
		System.out.print(i*(n1/i)*(n2/i));
    	
        sc.close();
    }
}