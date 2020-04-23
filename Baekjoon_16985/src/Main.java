import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] map;
	static int[] dx = {1,-1,0,0,0,0};
	static int[] dy = {0,0,1,-1,0,0};
	static int[] dz = {0,-0,0,0,1,-1};
	static int[][][] calcMap;
	static boolean[][][] visited;
	static int ans=Integer.MAX_VALUE;
	static int[] output;
	static boolean[] v;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5][5];
		StringTokenizer st;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<5; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		output = new int[5];
		v = new boolean[5];
		
		visited = new boolean[5][5][5];
		//4번씩 전부 돌려보자
		//4번째칸 4번돌리고 3번째칸 4번돌리고 
		//아 판을 쌓는 순서도 마음대로 정할수 있다...
		per(0);
		
		if(ans==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}


	}
	
	public static void per(int c) {
		if(c==5) {
			//output이 층수 저장하고있음.
			calcMap = new int[5][5][5];
			for(int i=0; i<5; i++) {
				for(int r=0; r<5; r++) {
					for(int b=0; b<5; b++) {
						calcMap[i][r][b] = map[output[i]][r][b];
					}
				}
			}
			//층수 저장.
			calc();
		}
		else{
			for(int i=0; i<5; i++) {
				if(!v[i]) {
					v[i] = true;
					output[c]=i;
					per(c+1);
					v[i] = false;
				}
			}
		}
	}
	public static void calc() {
		for(int a=0; a<4; a++) {
			rotate(0);
			if(calcMap[0][0][0]==1) {
				for(int b=0; b<4; b++) {
					rotate(1);
					for(int c=0; c<4; c++) {
						rotate(2);
						for(int d=0; d<4; d++) {
							rotate(3);
							for(int e=0; e<4; e++) {
								rotate(4);
								if(calcMap[4][4][4]==1) {
									bfs();
								}
							}
						}
					}
				}
			}
			
		}
	}

	public static void bfs() {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(0,0,0,0));
		visited[0][0][0] = true;
		while(!que.isEmpty()) {
			Node t = que.poll();
			if(t.x==4 && t.y==4 && t.z==4) { //회전 가능하니까 무조건 0,0에서 시작해도 상관없지않나?
				ans = Math.min(ans, t.c);
				for(int r=0; r<5; r++) {
					for(int c=0; c<5; c++){
						Arrays.fill(visited[r][c],false);
					}
				}
				return;
			}
			for(int i=0; i<6; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				int nz = t.z+dz[i];
				if(nx<5 && ny<5 && nz<5 && nx>=0 && ny>=0 && nz>=0) {
					if(!visited[nx][ny][nz] &&calcMap[nx][ny][nz]==1) {
						visited[nx][ny][nz]=true;
						que.add(new Node(nx,ny,nz,t.c+1));
					}

				}
			}
		}
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++){
				Arrays.fill(visited[r][c],false);
			}
		}
	}

	public static void rotate(int i) { //i번째 칸을 시계회전.
		int[][] tmap = new int[5][5];
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				tmap[r][c] = calcMap[i][r][c];
			}

		}
		//(2,0) (1,0) (0,0)
		//(2,1) (1,1) (0,1)
		//(2,2) (1,2) (0,2)
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				//행은 54321 열은 0
				//행은 54321 열은 1
				//행은 54321 열은 2

				calcMap[i][r][c] = tmap[4-c][r];
			}

		}
	
		tmap= null;

	}



}

class Node{
	int x;
	int y;
	int z;
	int c;
	Node(int x, int y, int z, int c){
		this.x=x;
		this.y=y;
		this.z=z;
		this.c=c;
	}
}
