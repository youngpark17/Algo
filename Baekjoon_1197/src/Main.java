import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int v;
	static int e;
	static PriorityQueue<Node> pq;
	static int[] parents;
	static int ans;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<Node>();
		ans=0;
		parents = new int[v+1];
		while(e-->0) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Node(v1,v2,c));
		}
		for(int i=1; i<v+1; i++) {
			parents[i] = i;
		}
		while(!pq.isEmpty()) {
			Node t = pq.poll();
			int a = find(t.v1);
			int b = find(t.v2);
			if(a!=b) {
				union(a, b);
				ans+=t.c;
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
			parents[b] =a; //더 큰 값이 부모
		}
		else {
			parents[a] = b;
		}
	}

}

class Node implements Comparable<Node>{
	int v1;
	int v2;
	int c;

	Node(int v1, int v2, int c) {
		this.v1=v1;
		this.v2=v2;
		this.c=c;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.c-o.c;
	}
}
