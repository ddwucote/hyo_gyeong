import java.util.Scanner;
import java.util.Stack;

class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack<>(); //String stack생성
        StringBuilder sb = new StringBuilder();
		
		int count = sc.nextInt(); //전체 입력 개수
		
		int index = 0; //배열의 index
		for (int i = 0; i < count; i++) { //전체 입력 개수번 반복
			String str = sc.next(); //문자열 읽고
			int k = 0;
			while(k < str.length()) { //문자열을 앞에서부터 하나씩 가져옴
				String tmp = Character.toString(str.charAt(k)); //가져온 char형을 String으로 변환
				if (stack.empty() == false){ //stack이 비어있지 않으면
					if (stack.peek().equals("(") && tmp.equals(")")) //짝 맞는지 비교 후
						stack.pop(); //pop 또는
					else stack.push(tmp); //push
				}
				else stack.push(tmp); //비어있으면 push
				k++; //다름 문자열 받기
			}
			if (stack.empty() == true) //모두 짝이 맞으면
				sb.append("YES\n"); //YES문자열 붙이고
			else {
				sb.append("NO\n"); //아니면 NO문자열 붙이고
				stack.clear(); //stack 초기화
			} 
		}
        System.out.println(sb); //최종 결과 출력
		sc.close(); //Scanner 닫기
	}
}