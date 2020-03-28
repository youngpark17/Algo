import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int answer=0;
	static List<Integer>[] list;
	static int from;
	static int to;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken())-1;
		to = Integer.parseInt(st.nextToken())-1;
		m = Integer.parseInt(br.readLine());
		list=new List[n];
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken())-1;
			int a2 = Integer.parseInt(st.nextToken())-1;
			list[a1].add(a2);
			list[a2].add(a1);
		}
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(from,0));
		while(!que.isEmpty()) {
			Node t = que.poll();
			if(t.next==to) {
				System.out.println(t.c);
				System.exit(0);
			}
			for(int a : list[t.next]) {
				if(!visited[a]) {
					visited[a] = true;
					que.add(new Node(a,t.c+1));
				}
			}
		}
		System.out.println(-1);
		
		
	}

}

class Node{
	int next;
	int c;
	
	public Node(int next, int c) {
		
		this.next=next;
		this.c=c;
	}
}
