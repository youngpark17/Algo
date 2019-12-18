import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = {-1,0,0,1};
	static int[] dy= {0,-1,1,0};
	static int[][] arr;
	static boolean[][] flag;
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		
		arr= new int[n][m];
		flag= new boolean[n][m];
		
		
		for(int i=0; i<n; i++) {
			tmp = br.readLine().split("");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);

			}
		}
		
		flag[0][0]=true;
		bfs(0,0);
		System.out.println(arr[n-1][m-1]);
		

	}
	
	public static void bfs(int x, int y) {
		Node p = new Node(x,y);
		Queue<Node> que = new LinkedList<>();
		que.add(p);
		while(!que.isEmpty()) {
			Node t = que.poll();
			for(int i=0; i<4; i++) {
				int nextX = t.x+dx[i];
				int nextY = t.y+dy[i];
				if(nextX>=n||nextY>=m||nextX<0||nextY<0) {
					continue;
				}
				if(flag[nextX][nextY]||arr[nextX][nextY]==0) {
					continue;
				}
				flag[nextX][nextY]=true;
				arr[nextX][nextY]=arr[t.x][t.y]+1;
				que.add(new Node(nextX, nextY));
			}
		}
		
	}

}


