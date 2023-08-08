import java.util.*;

public class Main {
	
	static class Node{
		char data;
		Node left;
		Node right;
		
		Node (char d, Node l, Node r){
			this.data = d;
			this.left = l;
			this.right = r;
		}
	}
	
	static Node rootNode = new Node('A', null, null);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			char root = sc.next().charAt(0);
			char left = sc.next().charAt(0);
			char right = sc.next().charAt(0);
			sc.nextLine();
			insertNode(rootNode, root, left, right);
		}
		preOrder(rootNode);
		System.out.println();
		inOrder(rootNode);
		System.out.println();
		postOrder(rootNode);
		
		sc.close();
	}
	
	public static void insertNode(Node rootNode, char root, char left, char right) {
		if (rootNode.data == root) {//root값과 일치하는 부모 노드를 만났을 때, String type은 주소를 비교하기 때문에 char형으로 바꿔야함
			rootNode.left = (left == '.' ? null : new Node(left, null, null));
			rootNode.right = (right == '.' ? null : new Node(right, null, null));
		}
		else { //root부터 아래로 찾아가면서 부모노드가 일치할 때까지 내려감
			if (rootNode.left != null) //리프노드가 아닐 때
				insertNode(rootNode.left, root, left, right); //왼쪽으로 가보기
			if (rootNode.right != null)
				insertNode(rootNode.right, root, left, right); //오른쪽으로 가보기
		}
	}
	
	public static void preOrder(Node node) { //전위
		if (node == null) //리프노드
			return;
		System.out.print(node.data); //root출력
		preOrder(node.left); //왼쪽 노드 출력
		preOrder(node.right); //오른쪽 노드 출력
	}
	
	public static void inOrder(Node node) { //중위
		if (node == null) //리프노드
			return;
		inOrder(node.left); //왼쪽 노드 출력
		System.out.print(node.data); //root출력
		inOrder(node.right); //오른쪽 노드 출력
	}
	
	public static void postOrder(Node node) { //후위
		if (node == null) //리프노드
			return;		
		postOrder(node.left); //왼쪽 노드 출력
		postOrder(node.right); //오른쪽 노드 출력
		System.out.print(node.data); //root출력
	}

}