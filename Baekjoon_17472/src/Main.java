import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx= {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	static int[] parent;
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		parent = new int[8]; //섬의 개수가 6개까지 가능하므로... 234567 인덱스 7까지 사용.
		int numbering=2;
//		5 5
//		1 1 1 1 1
//		0 0 0 0 0
//		0 0 0 0 0
//		1 1 0 0 0
//		0 0 0 1 1
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j] && map[i][j]!=0) {
					dfs(i,j,numbering++);
				}
			}
		}
		for(int i=2; i<numbering; i++) {
			parent[i] = i;
		}
		//섬에 번호 다 메겼음
		//길이가 2이상이고 다른 섬을 잇는 다리를 전부 구해서 우선순위큐에 넣고, 유니온 파인드.
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]!=0) {
					int ny=j+1;
					int nx=i+1;
					int num = map[i][j];
					while(ny<m) {
						if(map[i][ny]==num) {
							break;
						}
						if(map[i][ny]!=0 && map[i][ny]!=num) {
							if(ny-j>=3) {
								pq.add(new Edge(num,map[i][ny],ny-j-1));
								break;
							}
							else {
								break;
							}
						}
						ny++;
					}
					while(nx<n) {
						if(map[nx][j]==num) {
							break;
						}
						if(map[nx][j]!=0 && map[nx][j]!=num) {
							if(nx-i>=3) {
								pq.add(new Edge(num, map[nx][j], nx-i-1));
								break;
							}
							else {
								break;
							}
						}
						nx++;
					}
				}
			}
		}
		int sum=0;
		int count=0;
		//섬의 개수는 numbering-2;
		//numbering-3개를 연결했는데 모두 연결이 안되었다면 -1; 간선의 개수는 섬ㅁ의개수 -1
		while(!pq.isEmpty()) {
			Edge t = pq.poll();
			if(find(t.p1)!=find(t.p2)) {
				union(t.p1, t.p2);
				sum+=t.c;
				count++;
			}
			if(count==numbering-3) {
				break;
			}
			
		}
		for(int i=3; i<numbering; i++) {
			if(find(parent[i])!=find(parent[i-1])) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		System.out.println(sum);
		
		
	}
	
	public static int find(int a) {
		if(a==parent[a]) {
			return a;
		}
		else {
			return parent[a] = find(parent[a]);
		}
	}
	public static void union(int a, int b) {
		a = find(a); //a는 a의 부모값으로 바꿈.
		b = find(b); //b는 b의 부모값으로 바꿈.
		if(a!=b) {
			if(a>b) { //a의 부모가 더 큰 값이면
				parent[b] = a; //b의 부모를 a로
			}
			else {
				parent[a] = b;
			}
		}
	
	}
	
	public static void dfs(int x, int y, int num) {
		map[x][y] = num;
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx<n && ny<m) {
				if(!visited[nx][ny]&& map[nx][ny]!=0) {
					dfs(nx,ny,num);
				}
			}
		}
	}

}

class Edge implements Comparable<Edge>{
	int p1;
	int p2;
	int c;
	Edge(int p1, int p2, int c){
		this.p1=p1;
		this.p2=p2;
		this.c=c;
	}
	
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub //cost가 작은 순서대로.
		return this.c-o.c;
	}
}
