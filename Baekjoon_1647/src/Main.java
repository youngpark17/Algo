import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] parents;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		int ans=0;
		for(int i=1; i<n+1; i++) {
			parents[i] = i;
		}
		while(!pq.isEmpty()) {
			Node t = pq.poll();
			int a = t.x;
			int b = t.y;
			if(find(a)!=find(b)) {
				n--;
				union(a,b);
				ans+=t.c;
				if(n==2) {
					break;
				}
			}
		}
		System.out.println(ans);
		
	}
	
	public static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) {
			return;
		}
		if(a>b) {
			parents[b] = a;
		}
		else {
			parents[a] = b;
		}
	}

}

class Node implements Comparable<Node>{
	int x;
	int y;
	int c;
	
	Node(int x, int y, int c){
		this.x=x;
		this.y=y;
		this.c=c;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.c-o.c;
	}
}
