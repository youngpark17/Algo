import java.io.BufferedReader;
import java.io.IOException;
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
	static int[][] tmap;
	static List<Node> arr;
	static Node[] output;
	static boolean[] visited;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static int count=0;
	static int minTime=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//조합을 통해 바이러스가 들어갈 수 있는 자리 중에 서 m개를 뽑아서 bfs 돌리자.
		//비활성화된 바이러스 지나갈수는 있되 마지막에 위치한 비활성 바이러스는 시간에 포함 안시켜도된다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		output = new Node[m];
		map = new int[n][n];
		tmap = new int[n][n];
		int k=0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					map[i][j]=-1; // 바이러스가능한위치 -1;
					arr.add(new Node(i,j,0));
				}
				if(map[i][j]==1) {
					map[i][j] = -3; //벽은 -3;
				}
				if(map[i][j]==0) {
					map[i][j]=-2;
					count++; //빈칸의 개수
				}
			}
		}

		visited = new boolean[arr.size()];
		if(count==0) {
			System.out.println(0);
			System.exit(0);
		}
		comb(0,0);
		if(minTime==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {

			System.out.println(minTime);
		}

	}
	public static void comb(int d, int c) {
		if(c==m) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					tmap[i][j] = map[i][j];
				}
			}
			Queue<Node> que = new LinkedList<>();
			int cnt=count;
			for(Node t : output) {
				que.add(t); // 선택된 활성바이러스부터 시작하자.
			}
			while(!que.isEmpty()) {
				Node t = que.poll();
				if(cnt==0) {
					int max = 0;
					for(int i=0; i<n; i++) {
						for(int j=0; j<n; j++) {
							max = Math.max(max, tmap[i][j]);
						}
					}
					minTime = Math.min(max, minTime);
					return;
				}
			


			for(int i=0; i<4; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					if(tmap[nx][ny]==-2) {
						cnt--;
						tmap[nx][ny]=t.t+1;
						que.add(new Node(nx,ny,t.t+1));
					}
					else if(tmap[nx][ny]==-1) {
						tmap[nx][ny]=t.t+1;
						que.add(new Node(nx,ny,t.t+1));
					}


				}
			}
		}
	}
	else {
		for(int i=d; i<arr.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[c] = arr.get(i);
				comb(i+1,c+1);
				visited[i] = false;
			}
		}
	}
}
}

class Node{
	int x;
	int y;
	int t;
	Node(int x, int y, int t) {
		this.x=x;
		this.y=y;
		this.t=t;
	}
}
