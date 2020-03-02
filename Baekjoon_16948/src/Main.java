import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx= {-2,-2,0,0,2,2};
	static int[] dy= {-1,1,-2,2,-1,1};
	static boolean[][] visited;
	static int n;
	static int r1;
	static int c1;
	static int r2;
	static int c2;
	static int min = 0;
	static int count=0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		r1 = Integer.parseInt(tmp[0]);
		c1 = Integer.parseInt(tmp[1]);
		r2 = Integer.parseInt(tmp[2]);
		c2 = Integer.parseInt(tmp[3]);
		visited = new boolean[n][n];
		visited[r1][c1] = true;
		Node a = new Node(r1,c1,0);
		Queue<Node> que = new LinkedList<>();
		que.add(a);
		while(!que.isEmpty()) {
			Node t = que.poll();
			if(t.x==r2 && t.y==c2) {
				if(min==0) {
					min=t.c;
					System.out.println(min);
					System.exit(0);
				}
				
			}
			
			for(int i=0; i<dx.length; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				if(nx<0 || ny<0 || nx>(n-1) ||ny>(n-1) ||visited[nx][ny]) {
					continue;
				}
				visited[nx][ny] = true;
				que.add(new Node(nx,ny,t.c+1));
				
			}
		}
		System.out.println(-1);
	}

}

class Node{
	int x;
	int y;
	int c;
	Node(int x, int y, int c){
		this.x=x;
		this.y=y;
		this.c=c;
	}
}
