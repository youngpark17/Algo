import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static int[] tree;
	static int[] tmp;
	static int cnt;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		tree = new int[20001]; //노드의 수는 10000개이하
		cnt=0;
		tmp = new int[10001];
		//입력시작
		String input = "";

		while((input = br.readLine())!=null) {
			try {
				tmp[cnt++]=Integer.parseInt(input);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				break;
			}

		}
		Node root = new Node(tmp[0]);
		for(int i=1; i<cnt; i++) {
			root.addNode(root, tmp[i]);
		}
		postorder(root);
		bw.flush();
		bw.close();
		
	


	}
	
	public static void postorder(Node n) throws IOException {
		if(n.left!=null) {
			postorder(n.left);
		}
		if(n.right!=null) {
			postorder(n.right);
		}
		bw.append(n.data+"\n");
		
	}


}

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data=data;
	}
	
	Node addNode(Node n,int var) {
		Node curN= null;
		if(n==null) {
			return new Node(var);
		}
		if(var<n.data) {
			curN = addNode(n.left,var);
			n.left=curN;
		}
		else if(var>n.data){
			curN = addNode(n.right,var);
			n.right=curN;
		}
		return n;
		
	}
}
