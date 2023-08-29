import java.util.*;

public class Main {
	
	public static long calc(int r, int n, ArrayList<Integer> nlist) {
		long ans = 1;
		for (int i = 0; i < n; i++) {
			ans *= r--;
			for (int k = 0; k < nlist.size(); k++) {
				if (ans % nlist.get(k) == 0) {
					ans /= nlist.get(k);
					nlist.remove(k);
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			int n = sc.nextInt(); //13
			int r = sc.nextInt(); //29
			if (n == 1)
				sb.append(r+"\n");
			else {
				for (int j = 0; j < n; j++)
					list.add(j+1);
				long ans = calc(r, n, list);
				sb.append(ans+"\n");
			}
		}
		System.out.print(sb);
	}

}