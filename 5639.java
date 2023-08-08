import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int num;
		Node left;
		Node right;
		
		Node (int n){
			this.num = n;
		}
		
		void insert(int n) {
			if (n < this.num) { //root보다 작은 수가 들어오면 왼쪽으로
				if (this.left == null) //왼쪽에 넣어야 하는데 비어있으면
					this.left = new Node(n); //새로 만들어서 넣기
				else
					this.left.insert(n); //이미 차 있으면 더 왼쪽 아래로 내려가기
			}
			else { //root보다 크거나 같은 수가 들어오면 오른쪽으로
				if (this.right == null) //오른쪽에 넣어야 하는데 비어있으면
					this.right = new Node(n); //새로 만들어서 넣기
				else
					this.right.insert(n); //이미 차 있으면 더 오른쪽 아래로 내려가기
			}
		}
	}
	
	static void postOrder(Node node) { //후위
		if (node == null) //리프노드
			return;		
		postOrder(node.left); //왼쪽 노드 출력
		postOrder(node.right); //오른쪽 노드 출력
		System.out.println(node.num); //root출력
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node root = new Node(Integer.parseInt(br.readLine())); //문제상 처음 입력값은 무조건 root니까
		String input = "";
		while ((input= br.readLine())!=null) { //몇개가 입력될지 모름
			StringTokenizer st = new StringTokenizer(input," ");
            if(!st.hasMoreTokens() ){ //input == null과같이 거르면 에러나는 이유 : 우리는 인텔리제이나 이클립스 같은 외부 IDE의 콘솔을 통해 입력 즉 끝에 개행 들어감
            	//그러나 백준은 테스트케이스를 IDE의 콘솔을 통하지 않고,	파일을 통해 입력. 파일에 있는 테스트케이스를 전부 입력하면 마지막에 EOF가 입력.
            	//br.readLine()은 EOF를 입력받으면 null을 리턴. 그렇기에 1번째 코드는 런타임에러(NullPointer)가 발생.
                return;
            }
			root.insert(Integer.parseInt(input));
		}
		
		postOrder(root);
	}

}