import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[][] visited;
	static int[] dx = {1,0,1};
	static int[] dy = {1,1,0};
	static int cnt;


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[101][101];
		cnt=0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int rotation = Integer.parseInt(st.nextToken());
			int depth = Integer.parseInt(st.nextToken());
			dfs(x,y,rotation,depth,-1);

		}

		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(visited[i][j]) {
					for(int k=0; k<3; k++) {
						if(!visited[i+dx[k]][j+dy[k]]) {
							break;
						}
						if(k==2) {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}

	public static void dfs(int x, int y, int rotation, int d, int c) {
		if(d==c || x<0 || y<0 || x>100 || y >100) {
			return;
		}
		else {
			visited[x][y] = true;
			int nx=0;
			int ny=0;
			switch (rotation) {
			case 0:
				nx = x+1;
				ny = y;
				break;
			case 1:
				nx = x;
				ny = y-1;
				break;
			case 2:
				nx = x-1;
				ny = y;
				break;
			case 3:
				nx = x;
				ny = y+1;
				break;
			}
			int nr = rotation-1;
			if(nr<0) {
				nr=3;
			}
			dfs(nx,ny,nr,d,c+1);
		}
	}

}
