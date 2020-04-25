import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx= {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static int cnt;
	static int depthCount=0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[12][6];
		for(int i=0; i<12; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<6; j++) {
				if(tmp[j]=='R') { //0
					map[i][j]=0;
				}
				if(tmp[j]=='G') { //1
					map[i][j]=1;
				}
				if(tmp[j]=='B') { //2
					map[i][j]=2;
				}
				if(tmp[j]=='P') { //3
					map[i][j]=3;
				}
				if(tmp[j]=='Y') { //4
					map[i][j]=4;
				}
				if(tmp[j]=='.') {
					map[i][j]=5;
				}
			}
		}
		
		visited = new boolean[12][6];
		cnt=-1;
		while(true) {
			cnt++;
			boolean flag2=true;
			for(int i=11; i>=0; i--) {
				for(int j=0; j<6; j++) {
					if(map[i][j]!=5) {
						int k=0;
						visited[i][j] = true;
						dfs(i,j,map[i][j],0);
						init();
						if(depthCount>=4) {
							visited[i][j] = true;
							dfs2(i,j,map[i][j]);
							flag2=false;
							init();
						
						}
						depthCount=0;
					}

				}
			}
			
			for(int a=0; a<6; a++) {
				down(a);
			}
		
			if(flag2) {
				break;
			}
			
		}
		System.out.println(cnt);

	}

	public static void init() {
		for(int i=0; i<12; i++) {
			Arrays.fill(visited[i], false);
		}
	}

	public static void dfs2(int x, int y, int num) {
		if(map[x][y]!=num) {
			return;
		}
		if(map[x][y]==num) {
			map[x][y]=5;
		}
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx<12 && ny<6) {
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					dfs2(nx,ny,num);
				}
			}
		}

	}

	public static void dfs(int x, int y, int num, int c) {
		if(map[x][y]==num) {
			depthCount++;
		}
		if(map[x][y]!=num) {
			return;
		}
		else {
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && ny>=0 && nx<12 && ny<6) {
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						dfs(nx,ny,num,c+1);
					}
				}
			}
		}

	}



	public static void down(int col) {
		for(int i=11; i>=0; i--) {
			if(map[i][col]==5) {
				for(int j=i-1; j>=0; j--) {
					if(map[j][col]!=5) {
						map[i][col] = map[j][col];
						map[j][col]=5;
						break;
					}
				}

			}
		}
	}

}
