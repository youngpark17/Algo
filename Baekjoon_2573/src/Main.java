import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static boolean[][] visited;
	static boolean[][] visited2;
	static int[][] map;
	static int[][] tmpMap;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static int total=0;
	static int count=0;
	
	static int year;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//BFS를 통해 매초 빙산을 깎고 깎고 난후 DFS를 통해 노드의 구한 노드의 수가 빙산조각의 수와 다르다면.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		tmpMap = new int[n][m];
		visited = new boolean[n][m];
		visited2 = new boolean[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) {
					total++;
				}
			}
		}
		
		while(true) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]==0&&!visited[i][j]) {
						Queue<Node> que = new LinkedList<>();
						que.add(new Node(i,j));
						visited[i][j]=true;
						while(!que.isEmpty()) {
							Node a = que.poll();
							for(int k=0; k<4; k++) {
								int nx = a.x+dx[k];
								int ny = a.y+dy[k];
								if(nx>=0 && ny>=0 && nx<n && ny<m) {
									if(!visited[nx][ny]) {
										if(map[nx][ny]>0) {
											tmpMap[nx][ny]-=1;
										}
										else {
											visited[nx][ny]=true;
											que.add(new Node(nx,ny));
										}
									}
								}
								
						
							}
							
						}
						//한 해 지나감.	
					}
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<m;j++) {
					if(map[i][j]>0) {
						map[i][j]+=tmpMap[i][j];
						if(map[i][j]<=0) {
							total--;
						}

						tmpMap[i][j]=0;
					}
				}
			}
			year++;
			loop2:for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]>0) {
						dfs(i,j);
						break loop2;
					}
				}
			}
			
			if(count!=total) {
				System.out.println(year);
				break;
			}
			else if(total==0) {
				System.out.println(0);
				break;
			}
			else {
				for(int i=0; i<n; i++) {
					for(int j=0; j<m; j++) {
						visited[i][j]=false;
						visited2[i][j]=false;
					}
				}
				count=0;
			}
			
			
		
		}
			
		
	}
	
	public static void dfs(int x, int y) {
		visited2[x][y]=true;
		count++;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx<n && ny<m) {
				if(!visited2[nx][ny] &&map[nx][ny]>0) {
					dfs(nx,ny);
				}
			}
		}
	}
	
	public static void print() {
		for(int[] mp2 : map) {
			for(int mp3 : mp2) {
				System.out.print(mp3+" ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
	

}

class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
}
