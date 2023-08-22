import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static int addLetter(int xSize) {
		int A = xSize / 4;
    	int B;
    	while(A >= 0) {
    		int tmpSize = (xSize - A*4) % 2;
    		B = (xSize - A*4) / 2;
    		if (tmpSize == 0) {
    			for(int k = 0; k < A; k++)
    				sb.append("AAAA");
    			for(int k = 0; k < B; k++)
    				sb.append("BB");
    			return 1;
    		}
    		if (A == 0 && tmpSize == 1) {
    			sb.append("-1");
    			return 0;
    		}
    		A--;
    	}
    	return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        
		String str = sc.next();
		int xSize = 0;
		int rslt = 0;
		int xOnly = 1;
        for (int i = 0; i < str.length(); i++) {
        	if (str.charAt(i) == 'X') {
        		xSize++;
        		continue;
        	}
        	if (str.charAt(i) == '.') {
        		rslt = addLetter(xSize);
        		sb.append(".");
        		xSize = 0;
        	}
        	if (rslt == 0)
        		break;
        	
        }
        
        if (xSize > 0) {
        	rslt = addLetter(xSize);
        	if (rslt == 0)
        		System.out.print("-1");
        	else
            	System.out.print(sb);
        }
        else if (rslt == 0)
        	System.out.print("-1");
        else
        	System.out.print(sb);
	}

}
