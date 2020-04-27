import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w;
	static int h;
	static char[][] map;
	static int sx=0;
	static int sy=0;
	static List<Node> list;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int[][] valueTable;
	static boolean[] perV;
	static int[] output;
	static int ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		loop:while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0) {
				break;
			}
			int dirty=0;
			list = new ArrayList<>();
			map = new char[h][w];
			for(int i=0; i<h; i++) {
				char[] tmp = br.readLine().toCharArray();
				for(int j=0; j<w; j++) {
					map[i][j] = tmp[j];
					if(map[i][j]=='o') {
						list.add(0,new Node(i,j,0));
						sx=i;
						sy=j;
					}
					if(map[i][j]=='*') {
						list.add(new Node(i,j,0));
						dirty++;
					}
				}
			}
			//각 더러운 곳까지 가는 최단 경로를 구하고 그걸 정렬하자.
			valueTable = new int[list.size()][list.size()]; // 모든 쓰레기와 청소기들 사이의. 거리
			for(int i=0; i<list.size()-1; i++) {
				for(int j=i+1; j<list.size(); j++) {
					Node n1 = list.get(i);
					Node n2 = list.get(j);
					int k = bfs(n1.x,n1.y,n2.x,n2.y);
					if(k<0) {
						bw.append("-1\n");
						continue loop;
					}
					valueTable[i][j] = k;
					valueTable[j][i] = k;
				}
			}
			perV = new boolean[list.size()];
			output = new int[list.size()];
			//순열을 구해서. 최소값 구하자.
			per(0,list.size(), 0);
			bw.append(ans+"\n");
			ans=Integer.MAX_VALUE;
			
		}
		bw.flush();
		bw.close();
		
	}
	
	public static void per(int c,int f, int d) {
		if(c==f) {
			int tans=0;
			//output배열에 있는거에서 하나씩
			for(int i=0; i<list.size()-1; i++) {
				tans+=valueTable[output[i]][output[i+1]];
			}
			ans=Math.min(ans, tans);
			
			return;
			
		}
		if(d==0) {
			perV[0] = true;
			output[0]=0;
			per(c+1,f,d+1);
		}
		else {
			for(int i=0; i<list.size(); i++) {
				if(!perV[i]) {
					perV[i] = true;
					output[c]=i;
					per(c+1,f,d+1);
					perV[i] = false;
				}
			}
		}
	}
	
	public static int bfs(int startX, int startY, int endX, int endY) {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(startX,startY,0));
		boolean[][] visited = new boolean[h][w];
		visited[startX][startY]=true;
		while(!que.isEmpty()) {
			Node t = que.poll();
			if(t.x==endX && t.y==endY) {
				return t.c;
			}
			for(int i=0; i<4; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				if(nx>=0 && ny>=0 && nx<h && ny<w) {
					if(!visited[nx][ny] && map[nx][ny]!='x') { //방문안했고, 가구아니면.
						visited[nx][ny] = true;
						que.add(new Node(nx,ny,t.c+1));
					}
				}
			}
		}
		visited[startX][startY] = false;

		return -1;
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
