import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static int max = Integer.MIN_VALUE;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		visited = new boolean[n][m];
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dfs(i,j,0,0);
				rec(i,j);
			}
		}
		System.out.println(max);
		
	}
	
	public static void rec(int x, int y) {
		int x1 = x;
		int y1 = y+1;
		int x2 = x;
		int y2 = y+2;
		int x3 = x+1;
		int y3 = y+1;
		if(x1>=0&&x2>=0&&x3>=0&&y1>=0&&y2>=0&&y3>=0) {
			if(x1<n && x2<n && x3<n && y1<m && y2<m && y3<m) {
				int sum=0;
				sum+=map[x][y];
				sum+=map[x1][y1];
				sum+=map[x2][y2];
				sum+=map[x3][y3];
				max=Math.max(sum, max);
			}
		}
		
		x1 = x+1;
		y1 = y;
		x2 = x+2;
		y2 = y;
		x3 = x+1;
		y3 = y-1;
		if(x1>=0&&x2>=0&&x3>=0&&y1>=0&&y2>=0&&y3>=0) {
			if(x1<n && x2<n && x3<n && y1<m && y2<m && y3<m) {
				int sum=0;
				sum+=map[x][y];
				sum+=map[x1][y1];
				sum+=map[x2][y2];
				sum+=map[x3][y3];
				max=Math.max(sum, max);
			}
		}
		
		x1 = x;
		y1 = y-1;
		x2 = x;
		y2 = y-2;
		x3 = x-1;
		y3 = y-1;
		if(x1>=0&&x2>=0&&x3>=0&&y1>=0&&y2>=0&&y3>=0) {
			if(x1<n && x2<n && x3<n && y1<m && y2<m && y3<m) {
				int sum=0;
				sum+=map[x][y];
				sum+=map[x1][y1];
				sum+=map[x2][y2];
				sum+=map[x3][y3];
				max=Math.max(sum, max);
			}
		}
		
		x1 = x-1;
		y1 = y;
		x2 = x-2;
		y2 = y;
		x3 = x-1;
		y3 = y+1;
		if(x1>=0&&x2>=0&&x3>=0&&y1>=0&&y2>=0&&y3>=0) {
			if(x1<n && x2<n && x3<n && y1<m && y2<m && y3<m) {
				int sum=0;
				sum+=map[x][y];
				sum+=map[x1][y1];
				sum+=map[x2][y2];
				sum+=map[x3][y3];
				max=Math.max(sum, max);
			}
		}
		
		
	}
	
	public static void dfs(int x, int y,int d, int sum) {
		if(d==4) {
			max = Math.max(sum, max);
			return;
		}
		else {
			sum +=map[x][y];
			visited[x][y]= true;
			for(int i=0; i<4; i++) {
				int nextX=x+dx[i];
				int nextY=y+dy[i];
				if(nextX<0 || nextY<0 || nextX>n-1 || nextY>m-1 ||visited[nextX][nextY]) {
					continue;
				}
				dfs(nextX,nextY,d+1,sum);
			}
			sum-=map[x][y];
			visited[x][y]=false;
		}
	}

}
