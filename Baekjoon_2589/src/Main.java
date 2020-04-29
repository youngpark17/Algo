import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int maxDepth=0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				map[i][j] = tmp[j];
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]=='L') {
					visited[i][j] = true;
					bfs(i,j);
					init();
				}
			}
		}

		System.out.println(maxDepth);

	}

	public static void init() {
		for(int i=0; i<n; i++) {
			Arrays.fill(visited[i], false);
		}
	}

	public static void bfs(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(x,y,0));
		while(!que.isEmpty()) {
			Node t = que.poll();
			maxDepth = Math.max(maxDepth, t.time);
			for(int i=0; i<4; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(!visited[nx][ny] && map[nx][ny] == 'L') {
						visited[nx][ny] = true;
						que.add(new Node(nx,ny,t.time+1));
					}
				}

			}


		}

	}

}

class Node{
	int x;
	int y;
	int time;
	Node(int x, int y, int time){
		this.x=x;
		this.y=y;
		this.time=time;
	}
}
