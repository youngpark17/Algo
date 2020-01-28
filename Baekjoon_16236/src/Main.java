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
					count++; //������� ����
				}
			}
		}
		//�������� �ִ� ���� ��ġ�� ��ũ ���� ����Ʈ�� ���.
		while(count!=0) {
			Queue<Node> que = new LinkedList<>();
			que.add(new Node(sx,sy,0)); //��ũ�� ��ġ���� ����.
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
					if(nx<0 || ny<0 ||nx>n-1 || ny>n-1 || map[nx][ny]>sharkSize) { //������ ��.
						continue;
					}
					if(!visited[nx][ny]) {//�湮�� ���� �ƴϸ�
						visited[nx][ny] = true;
						que.add(new Node(nx,ny,d));
						if(map[nx][ny]<sharkSize && map[nx][ny]!=0) { //�̵� �����ѵ� ���� ���� �ִ� �� ����
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
				count-=1; //�ϳ� ����.
				sx = t.x;
				sy = t.y; //��ũ �̵���.
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
		if(this.d==o.d) { //�Ÿ��� ������... ���� �ְ� ���ʿ� �ִ°�
			if(this.x==o.x) { //���̰� ��������... �� ���ʿ��մ°� �� y���� �����Ű� �켱���� ����.
				return this.y-o.y;
			}
			else {
				return this.x-o.x;
			}
		}
		return this.d-o.d;

	}
}

