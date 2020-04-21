import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static int total=0;
	static int min = 500000;
	static int[] dx= {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		//visted 배열에 구역 체크해놓고
		//map 값으로 bfs 돌리자
		//기준점 x,y에서 1<=x<x+d1+d2<=n 1<=y-d1 <y <y+d2<=n
		//조건 함수 만들고 하나씩 다 돌려보자
		
		StringTokenizer st;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total+=map[i][j];
			}
		}
		for(int x=1; x<=n; x++) {
			for(int y=1; y<=n; y++) {
				for(int d1=1; d1<=n; d1++) {
					for(int d2=1; d2<=n; d2++) {
						if(check(x,y,d1,d2)) {
							solve(x,y,d1,d2);
						}
					}
				}
			}
		}
		System.out.println(min);

		
	}
	
	public static void solve(int x, int y, int d1, int d2) {
		int[][] visited=new int[n+1][n+1];
		int i=0;
//		(x, y), (x+1, y-1), ..., (x+d1, y-d1)
//		(x, y), (x+1, y+1), ..., (x+d2, y+d2)
//		(x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
//		(x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
		while(i<=d1) {
			visited[x+i][y-i]=1; //경계선 체크
			i++;
		}
		i=0;
		while(i<=d2) {
			visited[x+i][y+i]=1; //경계선 체크
			i++;
		}
		i = 0;
		while(i<=d2) {
			visited[x+d1+i][y-d1+i]=1;
			i++;
		}
		i = 0; 
		while(i<=d1) {
			visited[x+d2+i][y+d2-i] = 1;
			i++;
		}
		dfs(1,1,visited);
		int[] tmp = {0,0,0,0,0};
		// 1 ≤ r < x+d1, 1 ≤ c ≤ y	
		for(int a=1; a<x+d1; a++) {
			for(int b=1; b<=y; b++) {
				if(visited[a][b]==2) {
					tmp[0]+=map[a][b];
				}
			}
		}
		// 1 ≤ r ≤ x+d2, y < c ≤ N
		for(int a=1; a<=x+d2; a++) {
			for(int b=y+1; b<=n; b++) {
				if(visited[a][b]==2) {
					tmp[1]+=map[a][b];
				}
			}
		}
		//x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
		
		for(int a=x+d1; a<=n; a++) {
			for(int b=1; b<y-d1+d2; b++) {
				if(visited[a][b]==2) {
					tmp[2]+=map[a][b];
				}
			}
		}
		//x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
		for(int a=x+d2+1; a<=n; a++) {
			for(int b=y-d1+d2; b<=n; b++) {
				if(visited[a][b]==2) {
					tmp[3]+=map[a][b];
				}
			}
		}
		tmp[4] = total-tmp[0]-tmp[1]-tmp[2]-tmp[3];
		Arrays.parallelSort(tmp);
		min = Math.min(min, tmp[4]-tmp[0]);
		
	}
	
	public static void dfs(int x, int y,int[][] visited) {
		visited[x][y]=2;
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<1 || ny <1 || nx>n || ny>n) {
					continue;
				}
				if(visited[nx][ny]==0) {
					dfs(nx,ny,visited);
				}
			}
		
		
	}
	
	public static boolean check(int x, int y,int d1, int d2) {
		// (d1, d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N)
		if(d1>=1 && d2>=1 && x+d1+d2<= n && y-d1>=1 && y+d2<=n &&x>=1) {
			return true;
		}
		return false;
	}

}
