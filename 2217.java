import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		int max = 0;
		
       int n = sc.nextInt();
       for (int i = 0; i < n; i++) {
    	   arr.add(sc.nextInt());
       }
       Collections.sort(arr, Collections.reverseOrder());
       max = arr.get(0);
       for (int i = 1; i < n; i++) {
    	   int tmp = arr.get(i)*(i+1);
    	   if (max < tmp)
    		   max = tmp;
       }
       System.out.print(max);
	}

}
