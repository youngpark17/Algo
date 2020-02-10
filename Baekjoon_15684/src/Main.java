import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int h;
	static boolean[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 각 가로선에 대한 순열을 구하자. 이때 연속하는건 pass
		//0,1,2,3 까지.. 3초과하면 -1
		// 순열을 구한 후 dfs로 탐색.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new boolean[h][n-1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a-1][b-1] = true;
		}
		//이 전체 2차원 배열에 대한 순열을 구하자. 미리 true체크해 놓은 거 제외
		
		for(int i=0; i<=3; i++) {
			com(0,i,0);
		}
		System.out.println(-1);
		
		
		
	}
	public static int dfs(int col, int dep,boolean flag) { //flag가 true이면 무조건 밑으로만 내려가자.
		if(dep==h) {
			return col;
		}
		else if(flag) {
			return dfs(col,dep+1,false);
		}
		else {
			if(col==n-1) { 
				if(map[dep][col-1]) {
					return dfs(col-1,dep,true);
				}
				else {
					return dfs(col,dep+1,false);
				}
			}
			else if(col==0) {
				if(map[dep][col]) {
					return dfs(col+1, dep,true);
				}
				else {
					return dfs(col,dep+1,false);
				}
			}
			else {
				if(map[dep][col]) {
					return dfs(col+1,dep,true);
				}
				else if(map[dep][col-1]) {
					return dfs(col-1,dep,true);
				}
				else {
					return dfs(col,dep+1,false);
				}
			}
		}
	}
	public static void com(int c, int r, int d) {
		if(c==r) {
			for(int i=0; i<=n-1; i++) {
				int j = dfs(i,0,false);
				if(i!=j) {
					return;
				}
		}
			System.out.println(r);
			System.exit(0);
		}
		else {
			for(int i=d; i<(n-1)*h; i++) {
				if(!map[i/(n-1)][i%(n-1)]) {
					int R = i/(n-1);
					int C = i%(n-1);
					if(C==0) {
						if(C!=n-2) {
							if(map[R][C+1]) {
								continue;
							}
						}
						
					}
					else if(C==n-2) {
						if(map[R][C-1]) {
							continue;
						}
					}
					else {
						if(map[R][C+1] || map[R][C-1]) {
							continue;
						}
					}
					map[R][C] = true;
					com(c+1,r,d+1);
					map[R][C] = false;
						
						
						
				}
			}
		}
	}

	
}

