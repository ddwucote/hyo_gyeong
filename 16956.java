import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		String[][] arr = new String[R+1][C+1];
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			if (str.contains("SW") || str.contains("WS")) {
				System.out.print("0");
				return;
			}
			String[] strArr = str.split("");
			for (int j = 0; j < C; j++) {
				String input = strArr[j]; 
				if (input.equals("."))
					arr[i][j] = "D";
				else
					arr[i][j] = input;
			}
		}	
		for (int i = 0; i < R-1; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j].equals("S") && arr[i+1][j].equals("W") ||
						arr[i][j].equals("W") && arr[i+1][j].equals("S")) {
					System.out.print("0");
					return;
				}
			}
		}
		System.out.println("1");
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}
}





