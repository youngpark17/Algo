import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int D;
	static int[][] map;
	static int[][] tmap;
	static boolean[] visited;
	static List<Node>[] list;
	static Node[] node;
	static int max=Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited= new boolean[m];
		list = new List[3];
		node = new Node[3];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0,0);
		System.out.println(max);

	}

	public static void comb(int d, int c) {
		if(c==3) {
			int cnt=0;
			int ans=0;
			tmap = new int[n][m];
			for(int i=0; i<m; i++) {
				if(visited[i]) {
					list[cnt++] = new LinkedList<>();
					node[cnt-1] = new Node(n,i);
					if(cnt==3) {
						break;
					}
				}
			}

			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					tmap[i][j] = map[i][j];
				}
			}
			int up=0;
			while(true) {
				for(int i=0; i<n-up; i++) {
					for(int j=0; j<m; j++) {
						if(tmap[i][j]==1) {
							if(node[0].distance(i, j)<=D) {
								list[0].add(new Node(i,j,node[0].distance(i, j)));
							}
							if(node[1].distance(i, j)<=D) {
								list[1].add(new Node(i,j,node[1].distance(i, j)));
							}
							if(node[2].distance(i, j)<=D) {
								list[2].add(new Node(i,j,node[2].distance(i, j)));
							}
						}
					}
				}

				for(int i=0; i<3; i++) {
					if(list[i].size()!=0) {
						Collections.sort(list[i]);
						Node t = list[i].remove(0);
						if(tmap[t.x][t.y]==1) {
							tmap[t.x][t.y]=0;
							ans++;
						}
					}
				}
				up++;
				if(up==n) {
					max = Math.max(ans, max);
					return; 
				}
				for(int i=0; i<3; i++) {
					list[i].clear();
				}
				node[0].x-=1;
				node[1].x-=1;
				node[2].x-=1;
			}

		}
		else {
			for(int i=d; i<m; i++) {
				if(!visited[i]) {
					visited[i] = true;
					comb(i+1,c+1);
					visited[i] = false;
				}
			}
		}
	}

}

class Node implements Comparable<Node>{
	int x;
	int y;
	int d;
	Node(int x, int y){
		this.x=x;
		this.y=y;
		d=0;
	}
	Node(int x, int y,int d){
		this.x=x;
		this.y=y;
		this.d=d;
	}

	int distance(int x, int y) {
		return Math.abs(this.x-x)+Math.abs(this.y-y);
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if(this.d==o.d) {
			return (this.y<o.y)? 1:-1;
		}
		return this.d-o.d;
	}
}
