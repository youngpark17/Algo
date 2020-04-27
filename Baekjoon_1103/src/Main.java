import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static char[][] map;
	static int[][] dp;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static int[][] visited;
	static int ans;




	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		map = new char[n][m];
		visited = new int[n][m];
		dp = new int[n][m];
		ans=0;
		for(int i=0; i<n; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				map[i][j] = temp[j];
				visited[i][j] = -1;
			}
		}
		//사이클 판별하자. dfs 를 통해... dfs가 끝나지않은 node인데 dfs 를 통해 방문된다? 사이클.
		//-1이면 아직 방문 안함. 0이면 도는중 1이면 끝.
		if(dfs(0,0)) {
			System.out.println(-1);
			System.exit(0);
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				visited[i][j] = 0;
			}
		}
		visited[0][0]=1;
		move(0,0);
		System.out.println(dp[0][0]+1);

	}

	public static int move(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x+dx[i]*(map[x][y]-'0');
			int ny = y+dy[i]*(map[x][y]-'0');
			if(nx<n && ny<m && nx>=0 && ny>=0 && map[nx][ny]!='H') {

				if(dp[nx][ny]!=0) {
					dp[x][y] = Math.max(dp[x][y], dp[nx][ny]+1);
				}
				else if(visited[nx][ny]==0) {
					visited[nx][ny]=1;
					dp[x][y] = Math.max(dp[x][y], move(nx,ny)+1);
					visited[nx][ny]=0;
				}
			}
		}
		return dp[x][y];

	}


	public static boolean dfs(int x, int y) { //사이클 판별
		if(visited[x][y]==0) {
			return true;
		}
		if(map[x][y]=='H') {
			return false;
		}
		visited[x][y] = 0;

		for(int i=0; i<4; i++) {
			int nx = x+dx[i]*(map[x][y]-'0');
			int ny = y+dy[i]*(map[x][y]-'0');
			if(nx<n && ny<m && nx>=0 && ny>=0 && visited[nx][ny]!=1) {
				if(dfs(nx,ny)) {
					return true;
				}
			}
		}
		visited[x][y] = 1;
		return false;
	}



}
