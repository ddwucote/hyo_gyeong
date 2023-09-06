import java.math.BigInteger;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		BigInteger ans = new BigInteger("1");
		for (int i = 0; i < m; i++) {
			BigInteger tmp = BigInteger.valueOf(n-i);
			ans = ans.multiply(tmp);
		}
		for (int i = 1; i <= m; i++) {
			BigInteger tmp = BigInteger.valueOf(i);
			ans = ans.divide(tmp);
		}
		System.out.print(ans);
		sc.close();
	}
}