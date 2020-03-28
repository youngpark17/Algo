import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int f;
	static int s;
	static int g;
	static int u;
	static int d;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		Queue<Node> que = new LinkedList<>();
		visited = new boolean[f+2];//รั fรþ
		que.add(new Node(s,0));
		visited[s] = true;
		while(!que.isEmpty()) {
			Node t = que.poll();
			if(t.x==g) {
				System.out.println(t.c);
				System.exit(0);
			}
			if(t.x+u<=f+1) {
				if(!visited[t.x+u]) {
					visited[t.x+u] = true;
					que.add(new Node(t.x+u,t.c+1));
				}
			}
			
			if(t.x-d>=1) {
				if(!visited[t.x-d]) {
					visited[t.x-d] = true;
					que.add(new Node(t.x-d,t.c+1));
				}
			}
			
		}
		System.out.println("use the stairs");
		
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
