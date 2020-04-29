import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r;
	static int c;
	static char[][] map;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,1,-1};
	static Queue<Node> que;
	static int numberOfOut;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		que = new LinkedList<>();
		numberOfOut = 0;
		int startX=0;
		int startY=0;
		for(int i=0; i<r; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<c; j++) {
				map[i][j] = tmp[j];
				if((map[i][j]=='.'||map[i][j]=='F') && (i==r-1 || j == c-1 || i==0 || j==0)) {
					numberOfOut++; //Å»Ãâ±¸ °¹¼ö ÆÄ¾Ç.
				}
				if(map[i][j]=='J') {
					startX=i;
					startY=j;
				}
				if(map[i][j]=='F') {
					que.add(new Node(i,j,1,0));
				}
			}
		}
		if(startX==0 || startY==0 || startX==r-1 ||startY==c-1) {
			System.out.println("1");
			System.exit(0);
		}
		bfs(startX,startY);
		System.out.println("IMPOSSIBLE");
		
		
		
		
	}
	
	public static void print() {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void bfs(int a, int b) {
		que.add(new Node(a,b,0,1)); //ºÒºÎÅÍ ½ÃÀÛ.
		while(!que.isEmpty()) {
			Node t = que.poll();
			//print();
			if(t.type==1) { //ºÒÀÏ¶§ 
				if(t.x==r-1 || t.y==c-1 || t.x ==0 || t.y==0) {
					numberOfOut--;
					if(numberOfOut==0) {
						System.out.println("IMPOSSIBLE");
						System.exit(0);
					}
				}
				for(int i=0; i<4; i++) {
					int nx = t.x+dx[i];
					int ny = t.y+dy[i];
					if(nx>=0 && ny>=0 && nx<r && ny<c) {
						if(map[nx][ny]!='#' && map[nx][ny]!='F') {
							que.add(new Node(nx,ny,1,0));
							map[nx][ny] = 'F';
						}
					}
					
				}
			}
			else if(t.type==0) { //ÁöÈÆÀÌÀÏ¶§
				
				if(t.x==r-1 || t.y==c-1 || t.x==0 || t.y==0) {
					System.out.println(t.time);
					System.exit(0);
				}
				for(int i=0; i<4; i++) {
					int nx = t.x+dx[i];
					int ny = t.y+dy[i];
					if(nx>=0 && ny>=0 && nx<r && ny<c) {
						if(map[nx][ny]=='.') {
							que.add(new Node(nx,ny,0,t.time+1));
							map[nx][ny] = 'J';
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
	int type;
	int time;
	Node(int x, int y, int type, int time){
		this.x=x;
		this.y=y;
		this.type=type;
		this.time=time;
	}
}
