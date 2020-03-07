import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static int m;
	static int[][] arr;
	static int[][] visited;
	static int[][] distance;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//벽을 부수고 이동할 수도 있고 안부수고 이동할 수도 있다. 01
		//										   00 에서 1,1까지 가는 경우.. 그러면 벽을 안부수고 이동하는경우가 우선순위가 높지.
		//벽을 부수고 이동한 경우는 방문시 1로 체크 안부수고 이동한 경우는 2로 체크.
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		arr = new int[n][m];
		visited = new int[n][m];
		distance = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		distance[0][0]=0;
		for(int i=0; i<n; i++) {
			char[] tmp2 = br.readLine().toCharArray();
			for(int j=0; j<m;j++) {
				arr[i][j] = tmp2[j]-'0';
			}
		}
		
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(0,0,false,1));
		while(!que.isEmpty()) {
			Node t = que.poll();
			if(t.x==n-1 && t.y==m-1) {
				System.out.println(t.d);
				System.exit(0);
			}
			for(int i=0; i<4; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				//벽 부수고 방문할때는 아직 갱신 안된것만 처리, 안부수고 방문할때는 갱신된것도 처리.
				//한번도 방문 안한거, 부수고 방문했으면 1처리 아니면 2처리 
				if(nx>=0 && ny>=0 && nx<n &&ny<m) {//방문 가능
					if(visited[nx][ny]==0) { //한번도 방문 안한거.
						if(arr[nx][ny]==0 &&!t.flag) {//안부수고 방문했음. 2 처리
							visited[nx][ny]=2;
							que.add(new Node(nx,ny,false,t.d+1));
						}
						else if(arr[nx][ny]==0 &&t.flag) {//안부수고 방문했음. 2 처리
							visited[nx][ny]=1;
							que.add(new Node(nx,ny,true,t.d+1));
						}
						else if(arr[nx][ny]==1 &&!t.flag) {
							visited[nx][ny]=1;
							que.add(new Node(nx,ny,true,t.d+1));
						}
					}
					else if(visited[nx][ny]==1) {//갱신이 되어있지만, 벽 부수고 방문한 것이므로 안부수고 방문한것도 넣자.
						if(!t.flag) {
							if(arr[nx][ny]==0) {
								que.add(new Node(nx,ny,false,t.d+1));
								visited[nx][ny]=2;
							}
						}
					}
					
				}
			}
		}
		System.out.println(-1);
		
		

	}

}

class Node{
	int x;
	int y;
	boolean flag;
	int d;
	public Node(int x, int y, boolean flag, int d) {
		this.x = x;
		this.y = y;
		this.flag = flag;
		this.d = d;
	}
	
	
}