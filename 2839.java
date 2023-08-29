import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int five = n/5;
		while (five > 0) {
			if ((n - five*5) % 3 == 0) {
				System.out.print(five+(n - five*5) / 3);
				return;
			}
			else
				five--;
		}
		if (five == 0 && n % 3 == 0)
			System.out.print(n/3);
		else
			System.out.print("-1");
	}

}