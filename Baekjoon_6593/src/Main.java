import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	static boolean[][][] visited;
	static char[][][] map;
	static int l,r,c;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		L:while(!(l==0 && r==0 && c==0)) {
			visited = new boolean[l][r][c];
			map = new char[l][r][c];
			for(int i=0; i<l; i++) {
				for(int j=0; j<r; j++) {
					map[i][j] = br.readLine().toCharArray();
				}
				br.readLine();
			}
			int x=0;
			for(int i=0; i<l; i++) {
				for(int j=0; j<r; j++) {
					for(int k=0; k<c; k++) {
						if(map[i][j][k]=='S') {
							x = bfs(i,j,k);
							if(x==-1) {
								bw.append("Trapped!\n");
							}
							else {
								bw.append("Escaped in "+x+" minute(s).\n");
							}
							st = new StringTokenizer(br.readLine());
							l  =Integer.parseInt(st.nextToken());
							r = Integer.parseInt(st.nextToken());
							c = Integer.parseInt(st.nextToken());
							continue L;
						}
					}
				}
			}
			
			
		}
		bw.flush();
		bw.close();
		
	}
	
	public static int bfs(int x, int y, int z) {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(x,y,z,0));
		visited[x][y][z] = true;
		while(!que.isEmpty()) {
			Node t = que.poll();
			if(map[t.x][t.y][t.z]=='E') {
				return t.count;
			}
			for(int i=0; i<6; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				int nz = t.z+dz[i];
				if(nx>=0 && ny>=0 && nz>=0 && nx<l && ny<r && nz<c) {
					if(!visited[nx][ny][nz] && map[nx][ny][nz]!='#') {
						visited[nx][ny][nz] = true;
						que.add(new Node(nx,ny,nz,t.count+1));
					}
				}
			}
		}
		
		return -1;
	}

}

class Node{
	int x;
	int y;
	int z;
	int count;
	Node(int x, int y, int z, int count){
		this.x=x;
		this.y=y;
		this.z=z;
		this.count=count;
	}
}
