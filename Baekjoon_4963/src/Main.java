import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1,1,1,-1,-1,-1,0,0};
	static int[] dy = {-1,0,1,-1,0,1,-1,1};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if(m==0 && n==0) {
				bw.flush();
				System.exit(0);
			}
			map = new int[n][m];
			visited = new boolean[n][m];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(!visited[i][j] && map[i][j]==1) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			bw.append(cnt+"\n");
			
		}
		
		
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<dx.length; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx<n && ny<m &&!visited[nx][ny] && map[nx][ny]==1) {
				dfs(nx,ny);
			}
		}
	}

}
