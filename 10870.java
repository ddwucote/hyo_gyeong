import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int f0 = 0;
		int f1 = 1;
		int f2 = f0 + f1;
		if (n == 0)
			System.out.print(f0);
		else if (n == 1)
			System.out.print(f1);
		else {
			while (n > 1) {
				f2 = f0 + f1;
				f0 = f1;
				f1 = f2;
				n--;
			}
			System.out.print(f2);
		}
	}

}