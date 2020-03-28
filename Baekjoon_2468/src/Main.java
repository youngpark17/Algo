import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[][] visited;
	static int[][] map;
	static int h=-1;
	static int l;
	static int[] dx= {-1,0,0,1};
	static int[] dy= {0,1,-1,0};
	static int answer=0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		visited = new boolean[n][n];
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				h = Math.max(h, map[i][j]);
			}
		}
		l=0;
		int cnt=0;
		while(l<=h) {
			//l이하 인거 다 침몰시키자.
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]<=l) {
						visited[i][j]=true;
					}
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]>l && !visited[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			answer = Math.max(cnt, answer);
			cnt=0;
			for(boolean[] b : visited) {
				Arrays.fill(b, false);
			}
			l++;
			
		}
		System.out.println(answer);
	}
	
	public static void dfs(int x,int y) {
		visited[x][y]=true;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx<n && ny<n) {
				if(!visited[nx][ny] &&map[nx][ny]>l) {
					dfs(nx,ny);
				}
			}
			
		}
	}

}
