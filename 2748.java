import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long f0 = 0;
		long f1 = 1;
		long f2 = f0 + f1;
        if (n == 1)
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