import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>(); //Integer stack생성
		List<Integer> input_list = new ArrayList<>();
		List<Integer> origin_list = new ArrayList<>();
		
		int count = sc.nextInt(); //전체 입력 개수
		StringBuilder rslt = new StringBuilder();
		int flag = 1;
		
		
		for (int i = 0; i < count; i++) {
			origin_list.add(i+1); //1 2 3 4 5 6 7 8
			input_list.add(sc.nextInt()); //4 3 6 8 7 5 2 1
		}
		int input_index = 0;
		for(int want_to_find : input_list) {
			if (input_index == input_list.size())
				break;
			//stack가서 먼저찾음
			if (stack.search(want_to_find) != -1) {//stack에 있음
				rslt.append("-\n");
				stack.pop();
			}
			//origin_list를 stack에 담으면서 찾음
			else if (origin_list.contains(want_to_find)) {
				int index = 0;
				while(index < origin_list.size() &&
						want_to_find != origin_list.get(index)) {
					stack.push(origin_list.get(index));
					origin_list.remove(index);
					rslt.append("+\n");
				}
				rslt.append("+\n-\n");
				origin_list.remove(index);
			}
			else {
				System.out.println("NO");
				flag = 0;
				break;
			}	
			input_index++;
		}
		if (flag == 1)
            System.out.println(rslt);
		sc.close();
	}
}