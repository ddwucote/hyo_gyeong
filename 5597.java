import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int i = 0; i <= 30; i++)
			arr.add(i);
		
		for (int i = 0; i < 28; i++) {
			arr.set(sc.nextInt(), 0);
		}
		for (int i = 0; i <= 30; i++)
			if (arr.get(i) != 0)
				System.out.println(arr.get(i));
		sc.close();
	}
}