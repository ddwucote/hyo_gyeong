import java.util.*;

class Main {
	private static int COUNT = 0;
	private static int N;
    public static void main(String[] args) {	
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        String number = "0";
        calculate(number, 1);
        sc.close();
    }
    
    public static void calculate(String number, int cnt) {
    	if (ifOutOfRange(number)) {
    		System.out.print(-1);
    		return;
    	}
    	else if (ifDecreaseNumber(number)) {
    		if (cnt == N) {
    			System.out.print(number);
    			return;
    		}
    		else {
    			String newNumber = nextNumber(number);
        		calculate(newNumber, cnt+1);
    		}
    	}
    	else {
    		String newNumber = nextNumber(number);
    		calculate(newNumber, cnt);
    	}
    }
    
    public static boolean ifDecreaseNumber(String number) {
    	String[] numberSplit = number.split("");
    	for (int i = 0; i < numberSplit.length-1; i++) {
    		if (Integer.parseInt(numberSplit[i]) <= Integer.parseInt(numberSplit[i+1]))
    			return false;
    	}
    	return true;
    }
    
    public static String nextNumber(String number) {
    	String[] numberSplit = number.split(""); // 9999
    	int len = numberSplit.length;
    	// 한 자리 수
    	if (len == 1) {
    		return String.valueOf(Integer.parseInt(numberSplit[0])+1);
    	}
    	//41, 542처럼 1을 더 더해도 되면 더하기
    	if (Integer.parseInt(numberSplit[len-1])+1 < Integer.parseInt(numberSplit[len-2])) {
    		numberSplit[len-1] = String.valueOf(Integer.parseInt(numberSplit[len-1])+1);
    		return String.join("", numberSplit);
    	}
    	//43->50, 310->320 처럼 꽉 찼지만 다음수와 자릿수가 같으면
    	else if (!numberSplit[0].equals("9") || (numberSplit[0].equals("9") && ifFullNumber(number) == false)) {
    		for (int i = len-1; i > 0; i--) {
    			if (Integer.parseInt(numberSplit[i])+1 < Integer.parseInt(numberSplit[i-1])) {
    				numberSplit[i] = String.valueOf(Integer.parseInt(numberSplit[i])+1);
    				String newStr = "";
    				for (int k = 0; k <= i; k++) {
    					newStr += numberSplit[k];
    				}
    				for (int k = len-i-2; k >= 0; k--){
    	    			newStr += String.valueOf(k);
    	    		}
    				return newStr;
    			}
    		}
    		String newStr = String.valueOf(Integer.parseInt(numberSplit[0])+1);
    		for (int i = len-2; i >= 0; i--) {
    			newStr += String.valueOf(i);
    		}
    		return newStr;
    	} 
    	// 98, 987처럼 꽉 차서 다음 수의 자릿수가 달라지면 n자리였으니까 n+1자리의 시작수로 시작
    	else {
    		String newStr = "";
    		for (int i = len; i >= 0; i--) {
    			newStr += String.valueOf(i);
    		}
    		return newStr;
    	}
    	
    }
    
    public static boolean ifFullNumber(String number) { //98765
    	String[] numberSplit = number.split("");
    	for (int i = 0; i < numberSplit.length-2; i++) {
    		if (Integer.parseInt(numberSplit[i]) - Integer.parseInt(numberSplit[i+1]) != 1)
    			return false;
    	}
    	return true;
    }
    
    public static boolean ifOutOfRange(String number) {
    	if (number.split("").length > 10)
    		return true;
    	else
    		return false;
    }
}