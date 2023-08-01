import java.util.*;

public class Main {
	
	public static boolean isInteger(String strValue) {
		try {
			Integer.parseInt(strValue);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		HashMap<String, String> findIdx = new HashMap<>();
		HashMap<String, String> findName = new HashMap<>();
		
		int cnt = sc.nextInt();
		int q = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= cnt; i++) {
			String s = sc.nextLine();
			findIdx.put(s, String.valueOf(i));
			findName.put(String.valueOf(i), s);
		}
		for (int i = 0; i < q; i++) {
			String s = sc.nextLine();
			if (isInteger(s))
				sb.append(findName.get(s)).append("\n");
			else
				sb.append(findIdx.get(s)).append("\n");
			
		}
		System.out.print(sb);
		sc.close();
        
	}

}
