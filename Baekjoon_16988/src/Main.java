import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int n;
	static int m;
	static int[][] map;
	static List<Node> list;
	static Node[] output;
	static boolean[] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static int ans=0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		output = new Node[2];
		list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					list.add(new Node(i,j));
				}
			}
		}
		visited = new boolean[list.size()];
		//빈칸에서 2개 뽑고 //1이 나의돌 2가 상대돌
		//1로 뽑힌칸 체크하고 모든 2가 있는 좌표에 대해 bfs 돌려서 0을 안만나고 끝난다면 유효한값.
		//놓은 위치가 1로 둘러 쌓여져 있다면? bfs를 통해 갯수 파악하자.(탐색하는 공간의 칸과 2가 차있는 칸이 같아야한다.)
		comb(0,0);
		System.out.println(ans);

	}

	public static int bfs(int x, int y,boolean[][] v) {
		int width=0; //2인 너비
		int width2=0; //bfs로 훑은 너비.
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(x,y));
		v[x][y] = true;
		width++;
		width2++;
		while(!que.isEmpty()) {
			Node t = que.poll();
			for(int i=0; i<4; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				if(nx<n && ny<m && nx>=0 && ny>=0) {
					if(!v[nx][ny] && (map[nx][ny]==0 || map[nx][ny]==2)) {
						if(map[nx][ny]==2) {
							width++;
						}
						width2++;
						v[nx][ny] = true;
						que.add(new Node(nx,ny));
					}
				}
			}
			
		}
		if(width==width2) {
			return width;
		}
		return 0;

	}

	public static void comb(int c, int d) {
		if(c==2) {
			//output에 저장된 값 체크하고
			for(Node k : output) {
				map[k.x][k.y] = 1;
			}
			boolean[][] v = new boolean[n][m];
			int tans=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]==2 &&!v[i][j]) {
						tans+=bfs(i,j,v);
					}
				}
			}
			ans = Math.max(ans,tans);
			for(boolean[] k : v) {
				Arrays.fill(k, false);
			}
			for(Node k : output) {
				map[k.x][k.y] = 0;
			}
			return;
			
		}
		else {
			for(int i=d; i<list.size(); i++) {
				if(!visited[i]) {
					visited[i] = true;
					output[c] = new Node(list.get(i).x,list.get(i).y);
					comb(c+1,i+1);
					visited[i] = false;
				}
			}
		}
		
		
		
	}

}

class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
}
