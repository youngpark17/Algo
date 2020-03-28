import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int t;
	static int n;
	static int hx;
	static int hy;
	static int fx;
	static int fy;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		for(int tt=0; tt<t; tt++) {
			n = Integer.parseInt(br.readLine());
			List<Node> list = new ArrayList<>();
			boolean[] visited = new boolean[n+2];
			for(int i=0; i<n+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				if(i==0) {
					hx= x1;
					hy =x2;
				}
				if(i==n+1) {
					fx=x1;
					fy=x2;
				}
				list.add(new Node(x1, x2));
				
				
			}
			Queue<Node> que = new LinkedList<>();
			que.add(new Node(hx,hy));
			boolean flag=false;
			while(!que.isEmpty()) {
				Node a = que.poll();
				if(a.x==fx && a.y==fy) {
					bw.append("happy\n");
					flag=true;
					break;
				}
				for(int i=1; i<n+2; i++) {
					if(!visited[i]) {
						int d = getDistance(a, list.get(i));
						if(d<=1000) {
							visited[i] = true;
							que.add(list.get(i));
						}
					}
					
				}
			}
			if(!flag) {
				bw.append("sad\n");
			}
			Arrays.fill(visited, false);

			
		}

		bw.flush();
		bw.close();
	}
	
	public static int getDistance(Node a1,Node a2) {
		return Math.abs(a1.x-a2.x)+Math.abs(a1.y-a2.y);
	}

}

class Node{
	int x;
	int y;
	int c;
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Integer.hashCode(x+y);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Node t = (Node)obj;
		return this.x==t.x && this.y==t.y;
	}
}
