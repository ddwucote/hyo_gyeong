import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	TreeMap<String, Integer> map = new TreeMap<>();
    	long ans = 0;
   	
    	for (int i = 0; i < 10; i++)
    		map.put(String.valueOf(i), i);
    	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	int num = 10;
    	for (int i = 0; i < 26; i++)
    		map.put(String.valueOf(alphabet.charAt(i)), num++);
    	
        String s = sc.next();
        int arithmetic = sc.nextInt();
        String[] arr = s.split("");
        int exponent = 0;
        for (int i = arr.length-1; i >= 0; i--)
        	ans += map.get(arr[i]) * Math.pow(arithmetic, exponent++);
        	
        System.out.print(ans);
    	
        sc.close();
    }
}