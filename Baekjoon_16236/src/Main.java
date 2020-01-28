import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n;
	static int sharkSize;
	static int sharkFull;
	static int sx;
	static int sy;
	static int timer;
	static int count=0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean[][] visited;


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		timer=0;
		sharkSize=2;
		sharkFull=0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					sx=i;
					sy=j;
				}
				else if(map[i][j]!=0) {
					count++; //물고기의 개수
				}
			}
		}
		//지나갈수 있는 곳에 위치한 샤크 전부 리스트에 담고.
		while(count!=0) {
			Queue<Node> que = new LinkedList<>();
			que.add(new Node(sx,sy,0)); //샤크의 위치부터 시작.
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			boolean[][] visited = new boolean[n][n];
			visited[sx][sy]=true;
			map[sx][sy]=0;
			while(!que.isEmpty()) {
				Node t = que.poll();
				for(int i=0; i<4; i++) {
					int nx = t.x+dx[i];
					int ny = t.y+dy[i];
					int d = t.d+1;
					if(nx<0 || ny<0 ||nx>n-1 || ny>n-1 || map[nx][ny]>sharkSize) { //못가는 길.
						continue;
					}
					if(!visited[nx][ny]) {//방문한 곳이 아니면
						visited[nx][ny] = true;
						que.add(new Node(nx,ny,d));
						if(map[nx][ny]<sharkSize && map[nx][ny]!=0) { //이동 가능한데 먹을 수도 있는 상어가 존재
							pq.add(new Node(nx,ny,d));
						}
					}
				}

			}
			Node t = pq.poll();
			if(t==null) {
				System.out.println(timer);
				System.exit(0);
			}
			else {
				timer+=t.d;
				count-=1; //하나 먹음.
				sx = t.x;
				sy = t.y; //샤크 이동함.
				sharkFull+=1;
				map[sx][sy]=0;
				if(sharkSize==sharkFull) {
					sharkSize+=1;
					sharkFull=0;
				}
			}
			

		}
		System.out.println(timer);
		
	}

}



class Node implements Comparable<Node>{
	int x;
	int y;
	int d;
	Node(int x, int y, int d){
		this.x=x;
		this.y=y;
		this.d=d;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if(this.d==o.d) { //거리가 같으면... 높이 있고 왼쪽에 있는거
			if(this.x==o.x) { //높이가 같고으면... 더 왼쪽에잇는거 즉 y값이 작은거가 우선순위 가짐.
				return this.y-o.y;
			}
			else {
				return this.x-o.x;
			}
		}
		return this.d-o.d;

	}
}

