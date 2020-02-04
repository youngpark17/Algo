import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int t;
	static int[] dx= {-1,0,0,1};
	static int[] dy= {0,1,-1,0};
	static int[][] map;
	static int answer=0;


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[n+1][m];
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for(int j=x; j<n+1; j+=x) {
				for(int z=0; z<k; z++) {
					rotate(j,d);
				}
			}
			int cnt=0;
			boolean[][] check = new boolean[n+1][m];
			for(int r=1; r<n+1; r++) {
				if(map[r][0]==map[r][m-1]) {
					check[r][m-1] = true;
					check[r][0] = true;
				}
				for(int c=0; c<m; c++) {
					for(int q=0; q<4; q++) {
						int nx = r+dx[q];
						int ny = c+dy[q];
						if(nx>=1 && ny>=0 && nx<n+1 && ny<m) {
							if(map[nx][ny]==map[r][c] && map[r][c]!=0) {
								check[nx][ny] = true;
								check[r][c] = true;
								cnt++;
							}
						}
					}
				}
			}
			if(cnt==0) {  //인접한게 하나도 없었다면.
				float ave=0;
				float counter=0;
				for(int r1=1; r1<n+1; r1++) {
					for(int c1=0; c1<m; c1++) {
						if(map[r1][c1]!=0) {
							ave+=map[r1][c1];
							counter++;
						}
					}
				}
				ave=(float)ave/counter;
				for(int r1=1; r1<n+1; r1++) {
					for(int c1=0; c1<m; c1++) {
						if(map[r1][c1]!=0) {
							if(map[r1][c1]>ave) {
								map[r1][c1]-=1;
							}
							else if(map[r1][c1]<ave){
								map[r1][c1]+=1;
							}
						}
					}
				}
			}
			else { //인접해둔거 체크해둔거 뺴자.
				for(int r1 = 1; r1 < n+1; r1++) {
					for(int c1 = 0; c1<m; c1++) {
						if(check[r1][c1]){
							map[r1][c1]=0;
						}
					}
				}
			}
		}

		for(int r=1; r<n+1; r++) {
			for(int c=0; c<m; c++) {
				answer+=map[r][c];
			}
		}
		System.out.println(answer);


	}

	public static void rotate(int x, int d) {
		if(d==0) { //시계방향.
			int tmp = map[x][m-1];
			for(int i=m-1; i>0; i--) {
				map[x][i] = map[x][i-1];
			}
			map[x][0]=tmp;
		}
		else {
			int tmp = map[x][0];
			for(int i=0; i<m-1; i++) {
				map[x][i] = map[x][i+1];
			}
			map[x][m-1] = tmp;
		}
	}

}
