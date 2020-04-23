import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int n;
	static int m;
	static int[][] map;
	static List<Node> list;
	static Node[] output;
	static boolean[] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static int ans=0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		output = new Node[2];
		list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					list.add(new Node(i,j));
				}
			}
		}
		visited = new boolean[list.size()];
		//��ĭ���� 2�� �̰� //1�� ���ǵ� 2�� ��뵹
		//1�� ����ĭ üũ�ϰ� ��� 2�� �ִ� ��ǥ�� ���� bfs ������ 0�� �ȸ����� �����ٸ� ��ȿ�Ѱ�.
		//���� ��ġ�� 1�� �ѷ� �׿��� �ִٸ�? bfs�� ���� ���� �ľ�����.(Ž���ϴ� ������ ĭ�� 2�� ���ִ� ĭ�� ���ƾ��Ѵ�.)
		comb(0,0);
		System.out.println(ans);

	}

	public static int bfs(int x, int y,boolean[][] v) {
		int width=0; //2�� �ʺ�
		int width2=0; //bfs�� ���� �ʺ�.
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(x,y));
		v[x][y] = true;
		width++;
		width2++;
		while(!que.isEmpty()) {
			Node t = que.poll();
			for(int i=0; i<4; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				if(nx<n && ny<m && nx>=0 && ny>=0) {
					if(!v[nx][ny] && (map[nx][ny]==0 || map[nx][ny]==2)) {
						if(map[nx][ny]==2) {
							width++;
						}
						width2++;
						v[nx][ny] = true;
						que.add(new Node(nx,ny));
					}
				}
			}
			
		}
		if(width==width2) {
			return width;
		}
		return 0;

	}

	public static void comb(int c, int d) {
		if(c==2) {
			//output�� ����� �� üũ�ϰ�
			for(Node k : output) {
				map[k.x][k.y] = 1;
			}
			boolean[][] v = new boolean[n][m];
			int tans=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]==2 &&!v[i][j]) {
						tans+=bfs(i,j,v);
					}
				}
			}
			ans = Math.max(ans,tans);
			for(boolean[] k : v) {
				Arrays.fill(k, false);
			}
			for(Node k : output) {
				map[k.x][k.y] = 0;
			}
			return;
			
		}
		else {
			for(int i=d; i<list.size(); i++) {
				if(!visited[i]) {
					visited[i] = true;
					output[c] = new Node(list.get(i).x,list.get(i).y);
					comb(c+1,i+1);
					visited[i] = false;
				}
			}
		}
		
		
		
	}

}

class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
}
