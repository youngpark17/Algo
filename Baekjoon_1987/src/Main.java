import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static boolean[] visited;
	static int cnt;
	static int[] dx= {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static int tmp=0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cnt=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[30];
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				map[i][j] = tmp[j]-'A';
			}
		}
		visited[map[0][0]]=true;
		dfs(0,0,1);
		System.out.println(cnt);
		

	}
	
	public static void dfs(int x,int y, int c) {
		cnt = Math.max(c, cnt);
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<n && ny<m && nx>=0 && ny>=0) {
				if(!visited[map[nx][ny]]) {
					visited[map[nx][ny]] = true;
					dfs(nx,ny,c+1);
					visited[map[nx][ny]] = false;
				}
			}
		}
	}

	




}
