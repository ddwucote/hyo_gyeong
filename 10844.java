package test;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		BigInteger[] dp = new BigInteger[(n-1)*10];
		
		if (n == 1) {
			System.out.print("9");
			sc.close();
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				dp[i] = new BigInteger("1");
			}
			else if (i == 9) {
				dp[i] = new BigInteger("1");
			}
			else {
				dp[i] = new BigInteger("2");
			}
		}
		for (int i = 10; i < 10*(n-1); i++) { 
			if (i % 10 == 0) {
				dp[i] = dp[i-9];
			}
			else if (i % 10 == 9) {
				dp[i] = dp[i-11];
			}
			else {
				dp[i] = dp[i-11].add(dp[i-9]);
			}
		}
		BigInteger answer = new BigInteger("0");
		for (int i = 10*(n-2); i < 10*(n-1); i++)
			if (i % 10 != 0) {
				answer = answer.add(dp[i]);
			}
		System.out.print(answer.remainder(new BigInteger("1000000000")));
		
		sc.close();
	}
}