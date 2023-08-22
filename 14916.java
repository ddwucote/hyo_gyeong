import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int num = n;
        int five = n / 5;
        int two;
        while(five >= 0) {
        	int tmp = (num - five*5) % 2;
        	two = (num - five*5) / 2;
        	if (tmp == 0) {
        		System.out.print(five+two);
        		break;
        	}
        	if (tmp == 1 && five == 0) {
        		System.out.print("-1");
        		break;
        	}
        	five--;
        }
	}

}
