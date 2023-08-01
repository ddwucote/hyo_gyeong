import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		sb.append(1).append(" ");
		int cnt = sc.nextInt(); //5
		sc.nextLine();
		int[] hops = new int[cnt];
		for (int i = 0; i < cnt; i++)
			hops[i] = sc.nextInt(); //3 2 1-3-1
		int baloon = 0; //1번 풍선 먼저
		int hop;
		for (int i = 0; i < cnt-1; i++) {
			hop = hops[baloon]; //풍선 안에 있는 숫자
			hops[baloon] = 0; //터트림
			if (hop > 0) {
				while(hop > 0) {
					baloon++;
					if (baloon >= cnt)
						baloon = 0;
					if (hops[baloon] != 0) {
						hop--;
					}
				}
			}
			else {
				while(hop < 0) {
					baloon--;
					if (baloon < 0)
						baloon = cnt-1;
					if (hops[baloon] != 0) {
						hop++;
					}
				}
			}
			
			sb.append(baloon+1).append(" ");
		}
		System.out.print(sb);
		sc.close();
        
	}

}
