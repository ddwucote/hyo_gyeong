import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		
		arr.add(0);
		arr.add(1);
		
		int num = sc.nextInt();
		int min;
		for (int i = 2; i <= num; i++) {
			min = Integer.MAX_VALUE;
			for (int j = 1; j <= Math.sqrt(i); j++) {
				min = Math.min(min, arr.get(i-j*j));
			}
			arr.add(min+1);
		}
		System.out.print(arr.get(num));
	}

}