import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static char[][] map;
	static int r;
	static int c;
	static Node root;
	static int fx;
	static int fy;
	static boolean[][] visited;
	static int cnt;
	static Queue<Node> water;
	static Queue<Node> que;


	//≈ª√‚

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		r = Integer.parseInt(tmp[0]);
		c = Integer.parseInt(tmp[1]);
		visited= new boolean[r][c];
		map = new char[r][c];
		cnt=0;
		water= new LinkedList<>();
		que = new LinkedList<>();
		for(int i=0; i<r; i++) {
			char[] tmp2 = br.readLine().toCharArray();
			for(int j=0; j<tmp2.length; j++) {
				map[i][j] = tmp2[j];
				if(tmp2[j]=='S') {
					que.add(new Node(i,j));
				}
				if(tmp2[j]=='*') {
					water.add(new Node(i,j));
				}
			}
		}

		bfs();
		System.out.println(cnt);


	}

	public static void bfs() {


		while(true) {
			cnt++;
			int size2 = water.size();

			for(int i=0; i<size2; i++) {
				Node water_n = water.poll();


				for(int j=0; j<4; j++) {
					int wX=water_n.x+dx[j];
					int wY=water_n.y+dy[j];
					if(wX>=0&&wY>=0&&wY<c&&wX<r) {
						if(map[wX][wY]=='.') {
							map[wX][wY]='*';
							water.add(new Node(wX,wY));
						}
					}


				}
			}
			if(que.isEmpty()) {
				System.out.println("KAKTUS");
				System.exit(0);
			}
			int size1 = que.size();

			for(int j=0;j<size1; j++) {
				Node n = que.poll();

				for(int i=0; i<4; i++) {
					int nextX = n.x+dx[i];
					int nextY = n.y+dy[i];


					if(nextX>=0&&nextY>=0&&nextX<r&&nextY<c) {
						if(map[nextX][nextY]=='D') {
							return;
						}
						if(map[nextX][nextY]=='.') {
							map[nextX][nextY]='S';
							que.add(new Node(nextX, nextY));
						}
					}


				}
			}

		}

	}
}

class Node{
	int x;
	int y;


	public Node(int x, int y){
		this.x=x;
		this.y=y;

	}
}
