import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int from;
	static int to;
	static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		from = sc.nextInt();
		to = sc.nextInt();
		
		visited = new boolean[100_001];
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(from,0));
		while(!que.isEmpty()) {
			Node t = que.poll();
			if(t.x==to) {
				System.out.println(t.c);
				break;
			}
			if(t.x-1>=0) {
				if(!visited[t.x-1]) {
					visited[t.x-1]=true;
					que.add(new Node(t.x-1, t.c+1));
				}
			}
			if(t.x+1<=100_000) {
				if(!visited[t.x+1]) {
					visited[t.x+1]=true;
					que.add(new Node(t.x+1, t.c+1));
				}
			}
			if(t.x*2<=100_000) {
				if(!visited[t.x*2]) {
					visited[t.x*2]=true;
					que.add(new Node(t.x*2, t.c+1));
				}
			}
		}
	}

}

class Node{
	int x;
	int c;
	public Node(int x, int c) {
		this.x=x;
		this.c=c;
	}
}
