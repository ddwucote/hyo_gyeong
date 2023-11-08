import java.util.*;

class Main {
	private static int N;
	private static int MAX = Integer.MIN_VALUE;
	private static int MIN = Integer.MAX_VALUE;
	private static int[] NUMBERS;
	private static String[] OPRT = new String[]{"+","-","*","/"};
    public static void main(String[] args) {	
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        NUMBERS = new int[N];
        List<Integer> pickOperator = new ArrayList<>();
        int[] operator = new int[N-1];
        int[] visited = new int[N-1];
        for (int i = 0; i < N; i++) {
        	NUMBERS[i] = sc.nextInt();
        }
        int index = 0;
        for (int op = 0; op < 4; op++) {
        	int cnt = sc.nextInt();
        	for (int j = 0; j < cnt; j++) {
        		operator[index++] = op; // 연산자 인덱스를 개수만큼 담기 ex)+가 2개, -가 1개면 0,0 ,1이렇게
        	}
        }
        calculate(visited, operator, pickOperator);
        System.out.print(MAX+"\n"+MIN);
        sc.close();
    }
    public static void calculate(int[] visited, int[] operator, List<Integer> pickOperator) {
    	if (pickOperator.size() == N-1) {
    		int sum = NUMBERS[0];
    		for (int i = 0; i < N-1; i++) {
    			if (OPRT[pickOperator.get(i)].equals("+")) {
    				sum += NUMBERS[i+1];
    			}
    			else if (OPRT[pickOperator.get(i)].equals("-")) {
    				sum -= NUMBERS[i+1];
    			}
    			else if (OPRT[pickOperator.get(i)].equals("*")) {
    				sum *= NUMBERS[i+1];
    			}
    			else if (OPRT[pickOperator.get(i)].equals("/")) {
    				sum /= NUMBERS[i+1];
    			}
    		}
    		MAX = Math.max(MAX, sum);
    		MIN = Math.min(MIN, sum);
    		return;
    	}
    	for (int i = 0; i < N-1; i++) {
    		if (visited[i] == 0) {
    			visited[i] = 1;
	    		pickOperator.add(operator[i]);
	    		calculate(visited, operator, pickOperator);
	    		pickOperator.remove(pickOperator.size()-1);
	    		visited[i] = 0;
    		}
    	}
    }
}