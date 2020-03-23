import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static Queue<Node> que;
	static Queue<Node> que2;
	static int total;
	static int total2;
	static int currentTime;
	static int[] dx= {-1,0,0,1};
	static int[] dy= {0,1,-1,0};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		total=0;
		total2=0;
		currentTime=-1;
		que = new LinkedList<>();
		que2 = new LinkedList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					total++;
				}
			}
		}
		//print();
		que.add(new Node(0,0));
		while(!que.isEmpty()) {
			Node a = que.poll();
			for(int i=0; i<4; i++) {
				int nx = a.x+dx[i];
				int ny = a.y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(map[nx][ny]==0) {
						map[nx][ny]=3;
						que.add(new Node(nx,ny));
					}
					else if(map[nx][ny]==1) {
						map[nx][ny]=2;
						
						que2.add(new Node(nx,ny));
					}
				}
				
			}
		}
		total2=total;

		if(total-que2.size()==0) { //넣은 갯수만큼 이미 큐에 들어가있다면... 1초컷
			if(total2==0) { //치즈가 아예 없었음.
				System.out.println(0);
			}
			else {
				System.out.println(1);
			}
			System.out.println(total2);
			System.exit(0);
		}
		
		while(!que2.isEmpty()) {
			Node a = que2.poll();
			map[a.x][a.y]=3;
			if(currentTime!=a.t) { //한시간 흘렀을 경우...
				currentTime=a.t; //시간 갱신
				total2=total;
			}
			total--;
			for(int i=0; i<4; i++) {
				int nx = a.x+dx[i];
				int ny = a.y+dy[i];
				if(map[nx][ny]==1) { //공기 전파
					map[nx][ny]=2;
					que2.add(new Node(nx,ny,a.t+1));

				}
				else if(map[nx][ny]==0) { //치즈를 뚫고 치즈 가운데에 공기 넣을 경우
					//nx,ny 주위의 0을 3으로 바꾸고 1이 있을 경우 2로 바꾸고 que2에 넣자.
					Queue<Node> que3 = new LinkedList<>();
					map[nx][ny]=3;
					que3.add(new Node(nx,ny,a.t));
					while(!que3.isEmpty()) {
						Node a1 = que3.poll();
						for(int ii=0; ii<4; ii++) {
							int nnx = a1.x+dx[ii];
							int nny = a1.y+dy[ii];
							if(nnx>=0 && nny>=0 && nnx<n && nny<m) {
								if(map[nnx][nny]==0) {
									map[nnx][nny]=3;
									que3.add(new Node(nnx,nny,a1.t));
								}
								else if(map[nnx][nny]==1) {
									map[nnx][nny]=2;
									que2.add(new Node(nnx,nny,a1.t+1));
								}
							}
						}
					}
				}
			}
		}
		System.out.println(currentTime);
		System.out.println(total2);
		
		
	
		
	}
	
	

}

class Node{
	int x;
	int y;
	int t;

	
	public Node(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		this.t=1;

	}
	public Node(int x, int y,int t) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		this.t=t;

	}
}