import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Queue<ArrayList<BigInteger>> queue = new LinkedList<>();
		
		int ans = 0;
		int A = sc.nextInt();
		int B = sc.nextInt();
		ArrayList<BigInteger> tempArr = new ArrayList<>();
		tempArr.add(BigInteger.valueOf(A));
		queue.add(tempArr);
		while (!queue.peek().isEmpty()) {
			ArrayList<BigInteger> q = queue.poll();
			tempArr = new ArrayList<>();
			for (BigInteger i : q) {
				if (i.equals(BigInteger.valueOf(B))) {
					System.out.print(ans+1);
					return;
				}
				for (int j = 0; j < 2; j++) {
					BigInteger tmp;
					if (j % 2 == 0) {
						tmp = i.multiply(BigInteger.TWO);
					}
					else {
						tmp = i.multiply(BigInteger.TEN).add(BigInteger.ONE);
					}
					if (tmp.compareTo(BigInteger.valueOf(B)) <= 0) {
						tempArr.add(tmp);
					}
				}
			}
			queue.add(tempArr);
			ans++;
		}
		System.out.print("-1");
	}
}