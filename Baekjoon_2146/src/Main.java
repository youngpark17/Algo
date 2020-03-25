import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static boolean[][] visited;
	static List<Node>[] list;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int islandCount=2;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1) {
					bfs(i,j,islandCount++);
				}
			}
		}
		list = new List[islandCount-2];
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		loop:for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==0) {
					bfs2(i,j);
				}
			}
		}
		//섬에 번호를 메기고 섬의 바깥쪽에 있는 것들의 좌표를 전부 구하고.. 
		// -1은 바다 
		int dst = Integer.MAX_VALUE;
		for(int i=0; i<islandCount-3; i++) { //i번째 list원소와 모든 리스트의 원소와 비교.
			for(int j=i+1; j<islandCount-2; j++) {
				
				for(int k=0; k<list[i].size(); k++) {
					Node t1 = list[i].get(k);
					for(int k2=0; k2<list[j].size(); k2++) {
						Node t2 = list[j].get(k2);
						int distance = Math.abs(t1.x-t2.x)+Math.abs(t1.y-t2.y);
						dst = Math.min(dst, distance);
					}
				}
				
				
			}
		}
		
		System.out.println(dst-1);
	}
	
	public static void bfs(int x, int y, int num) {
		Node a = new Node(x,y);
		Queue<Node> que = new LinkedList<>();
		que.add(a);
		map[x][y]=num;
		while(!que.isEmpty()) {
			Node t = que.poll();
			for(int i=0; i<4; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					if(map[nx][ny]==1) {
						map[nx][ny]=num;
						que.add(new Node(nx,ny));
					}
				}
			}
		}
	}
	
	public static void bfs2(int x, int y) {
		Node a = new Node(x,y);
		Queue<Node> que = new LinkedList<>();
		que.add(a);
		map[x][y]=-1;
		while(!que.isEmpty()) {
			Node t = que.poll();
			for(int i=0; i<4; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					if(map[nx][ny]==0) {
						map[nx][ny]=-1;
						que.add(new Node(nx,ny));
					}
					else if(map[nx][ny]>0 &&map[nx][ny]!=1) {
						list[map[nx][ny]-2].add(new Node(nx,ny));
						map[nx][ny]=1;
					}
				}
			}
		}
	}
	
	public static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
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