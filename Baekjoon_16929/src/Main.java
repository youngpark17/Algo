import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r,c;
	static char[][] map;
	static int[][] visited;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];

		//dfs 돌리면서 dfs가 아직 끝나지 않았다면 
		for(int i=0; i<r; i++) {
			char[] tmp = br.readLine().toCharArray();
			map[i] = tmp;
		}
		visited = new int[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(visited[i][j]==0) {
					dfs(map[i][j],i,j,0);
				}
			}
		}
		System.out.println("No");
	}
	public static void dfs(char c1,int x, int y,int cnt) {
		if(visited[x][y]!=0) {//방문했던거 재방문했는데 구간크기 4보다 큰거확인.
			if(cnt-visited[x][y]>=4) {
				System.out.println("Yes");
				System.exit(0);
				return;
			}
			else {
				return;
			}
		}
		visited[x][y] = cnt;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx<r && ny<c) {
				if(map[nx][ny]==c1) {
					dfs(c1,nx,ny,cnt+1);
				}
			}
		}
	}

}
