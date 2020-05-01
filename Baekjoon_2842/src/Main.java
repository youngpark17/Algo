import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n;
	static char[][] map;
	static int[][] height;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static long ans = Long.MAX_VALUE;
	static Set<Integer> set;
	static int[] arr;
	static boolean[][] visited;
	static int sx,sy,kCount;
	static int s;
	static int e;
	static int t;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		height = new int[n][n];
		set = new TreeSet<Integer>();
		kCount=0;

		for(int i=0; i<n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<n; j++) {
				map[i][j] = tmp[j];
				if(map[i][j]=='P') {
					sx=i;
					sy=j;
				}
				else if(map[i][j]=='K') {
					kCount++;
				}
			}
		}
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
				set.add(height[i][j]);
			}
		}
		//SET�� ������������ �ߺ����� �Ǿ��ִ�.
		arr = new int[set.size()];
		int z=0;
		visited = new boolean[n][n];
		for(int k : set) {
			arr[z++] = k;
		}
		//2�����ͷ� �湮�Ѱ��� ���� �۰�, �������� ���̰� ��������? ����Ž�������ұ�? �����̴ϱ� 2������.
		int currentPiro = arr[set.size()-1]-arr[0];
		int fp=0;
		int bp=0;
		while(fp<arr.length) {
			s=arr[fp];
			e=arr[bp];
			init();
			boolean flag = dfs(sx,sy);
			if(flag) {
				fp++;
				currentPiro = Math.min(currentPiro, e-s);
			}
			else if(bp+1<arr.length){
				bp++;
			}
			else{
				break;
			}
		}
		System.out.println(currentPiro);



	}

	public static boolean dfs(int x, int y) {
		if(height[x][y]<s || height[x][y]>e) {//���۽� ó��.
			return false;
		}
		if(t==kCount) {
			return true;
		}

		for(int i=0; i<8; i++) {
			int nx= x+dx[i];
			int ny =y+dy[i];
			if(nx>=0 && ny>=0 && nx<n && ny<n) {
				if(!visited[nx][ny]&&height[nx][ny]>=s && height[nx][ny]<=e) {
					visited[nx][ny] = true;
					if(map[nx][ny]=='K') {
						t++;
					}
					boolean flag=dfs(nx,ny);
					if(flag) {
						return true;
					}
				}
			}

		}

		return false;


	}



	public static void init() {
		t=0;
		for(int i=0; i<n; i++) {
			Arrays.fill(visited[i], false);
		}
	}



}