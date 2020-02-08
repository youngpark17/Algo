import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static boolean[][] visited;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt=2; //섬은 2번부터
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1) {
					dfs(i,j,cnt++);
				}
			}
		}
		//다른 번호인 섬을 만날때까지... dfs돌리고 길이는 depth로 가자..
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]!=0 ) { //섬과 붙어있는 0을 기준으로...
					for(int t=0; t<4; t++) {
						int nx = i+dx[t];
						int ny = j+dy[t];
						if(nx>=0 && ny>=0 && nx<=n-1 && ny<=n-1) {
							if(map[nx][ny]==0&& !visited[nx][ny]) {
								visited[nx][ny] = true;
								bfs(nx,ny,0,map[i][j]);
							}
						}
					}
					for(int r=0; r<n; r++) {
						Arrays.fill(visited[r], false);
					}
					
				}
			}
		}
		System.out.println(min);
		
		
	}
	
	public static void dfs(int x, int y, int num) {
		map[x][y] = num;
		for(int i=0; i<4; i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			if(nx<0 || ny<0 ||nx>n-1 ||ny>n-1 || map[nx][ny]!=1) {
				continue;
			}
			dfs(nx,ny,num);
		}
		
	}
	public static void bfs(int x, int y, int depth, int num) {
		Node z = new Node(x,y,0);
		Queue<Node> que = new LinkedList<>();
		que.add(z);
		while(!que.isEmpty()) {
			Node t = que.poll();
			if(map[t.x][t.y]!=num &&map[t.x][t.y]!=0) {
				min = Math.min(t.d, min);
				return;
			}
			for(int i=0; i<4; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				if(nx>=0 &&ny>=0 && nx<=(n-1) && ny<=n-1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					que.add(new Node(nx,ny,t.d+1));
				}
			}
		}
	}

}

class Node{
	int x;
	int y;
	int d;
	Node(int x, int y, int d){
		this.x=x;
		this.y=y;
		this.d=d;
	}
}
