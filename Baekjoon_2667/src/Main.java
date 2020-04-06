import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<n; j++) {
				map[i][j] = tmp[j]-'0';
			}
		}
		int cnt=1;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] &&map[i][j]!=0) {
					dfs(i,j,cnt++);
				}
			}
		}
		Integer[] arr = new Integer[cnt];
		for(int i=0; i<arr.length;i++) {
			arr[i] = 0;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]!=0) {
					arr[map[i][j]]++;
				}
			}
		}
		Arrays.sort(arr);
		System.out.println(arr.length-1);
		for(int i=1; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		
		
		
	}
	
	public static void dfs(int x, int y, int num) {
		visited[x][y] = true;
		map[x][y]=num;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx<n&&ny<n) {
				if(!visited[nx][ny] && map[nx][ny]!=0) {
					dfs(nx,ny,num);
				}
			}
		}
	}

}

