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
		parent = new int[8]; //���� ������ 6������ �����ϹǷ�... 234567 �ε��� 7���� ���.
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
		//���� ��ȣ �� �ް���
		//���̰� 2�̻��̰� �ٸ� ���� �մ� �ٸ��� ���� ���ؼ� �켱����ť�� �ְ�, ���Ͽ� ���ε�.
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
		//���� ������ numbering-2;
		//numbering-3���� �����ߴµ� ��� ������ �ȵǾ��ٸ� -1; ������ ������ �����ǰ��� -1
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
		a = find(a); //a�� a�� �θ����� �ٲ�.
		b = find(b); //b�� b�� �θ����� �ٲ�.
		if(a!=b) {
			if(a>b) { //a�� �θ� �� ū ���̸�
				parent[b] = a; //b�� �θ� a��
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
		// TODO Auto-generated method stub //cost�� ���� �������.
		return this.c-o.c;
	}
}
