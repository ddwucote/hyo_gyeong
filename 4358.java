import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		TreeMap<String, Integer> map = new TreeMap<>();
		
		String str = " ";
		int cnt = 0;
		while(sc.hasNextLine()) {
            str = sc.nextLine();
            if (str.length() == 0)
            	break;
            map.put(str, map.getOrDefault(str, 0) + 1);
            cnt++;
        }
		for (Entry<String, Integer> temp : map.entrySet()) {
			String key = temp.getKey();
			Integer value = temp.getValue();
			sb.append(key+" "+String.format("%.4f", (double)value/cnt*100)+"\n");
		}
		System.out.print(sb);
		sc.close();
	}

}
