import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int r;
	static int g;
	static int[][] map;
	static boolean[] visited;
	static boolean[] visited2;
	static List<Node> list;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static int answer=-1;
	static Node[] arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited2 = new boolean[r+g];
		list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				//0,1,2 호수 배양액못뿌리는땅, 뿌릴수잇는땅
				map[i][j] =Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					list.add(new Node(i,j,0,0));
				}
			}
		}
		visited = new boolean[list.size()];
		//list에서 r+g개를 뽑자. 그 후 순열에서 r개를 뽑고 남는 g개가 있으니 그거에 대해서 순열.
		comb(0,0);
		System.out.println(answer);
	}
	public static void comb(int c, int d) {
		if(c==r+g) {
			//조합에서 뽑힌걸 배열에 담고 그거에 대해서 다시 조합.
			arr = new Node[r+g];
			int idx=0;
			for(int i=0; i<list.size(); i++) {
				if(visited[i]) {
					arr[idx++]=list.get(i);
				}
			}
			
			per(0,0);
			
			
		}
		else {
			for(int i=d; i<list.size(); i++) {
				if(!visited[i]) {
					visited[i] = true;
					comb(c+1,i+1);
					visited[i] = false;
				}
			}
		}
	}
	
	public static void move(List<Node> red, List<Node> blue) {
		boolean[][] v = new boolean[n][m];
		int flower = 0;
		int[][] tmap = new int[n][m];
		int[][] time = new int[n][m];
		for(int i = 0; i <n; i++) {
			tmap[i] = Arrays.copyOf(map[i], m);
		}
		
		Queue<Node> que = new LinkedList<>();
		for(Node r : red) {
			que.add(r);
			v[r.x][r.y]=true;
			time[r.x][r.y]=1;
			tmap[r.x][r.y]=r.type;
		}
		for(Node b : blue) {
			que.add(b);
			v[b.x][b.y]=true;
			time[b.x][b.y]=1;
			tmap[b.x][b.y]=b.type;
		}
		while(!que.isEmpty()) {
			Node a = que.poll();
			if(tmap[a.x][a.y]==7) {
				continue;
			}
			//아직 방문안했고 time[a.x][a.y]가 a.t+1이랑 같거나 작을때 전파.
			for(int i=0; i<4; i++) {
				int nx = a.x+dx[i];
				int ny = a.y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m && tmap[nx][ny]!=0) {
					if(v[nx][ny] && time[nx][ny]==a.t+1) {
						if((tmap[nx][ny]==8 && a.type==9)|| (tmap[nx][ny]==9 && a.type==8)) {
							flower++;
							tmap[nx][ny]=7;
						}
						
					}
					else if(!v[nx][ny]){
						v[nx][ny]=true;
						time[nx][ny]=a.t+1;
						tmap[nx][ny]=a.type;
						que.add(new Node(nx,ny,a.t+1,a.type));
					}
				}
			}
		}
			
		answer = Math.max(flower, answer);
		
	}
	
	public static void per(int idx,int c) {
		if(c==r) {
			//output에 들어간거 앞에껀 r, 뒤에껀 g. 0~+r-1까지 r r부터 r+g-1까지 g꺼라고 치자
			//이렇게하면 똑같은 경우 또셈. 12/345와 21/345는 같은경우인데 또세게된다.
			//r개만 뽑고 나머지는 g꺼라고 생각하자.
			List<Node> red  = new ArrayList<>();
			List<Node> blue = new ArrayList<>();
			for(int i=0; i<arr.length; i++) {
				if(visited2[i]) {
					red.add(new Node(arr[i].x,arr[i].y,1,8));
				}
				else {
					blue.add(new Node(arr[i].x,arr[i].y,1,9));
				}
			}
			//전파시켜보자
			move(red,blue);
			
		}
		if(idx==r+g) {
			return;
		}
		visited2[idx]=true;
		per(idx+1,c+1); //선택하고 넘어가기
		visited2[idx] = false;
		per(idx+1,c); //선택안하고 넘어가기
	}

}

class Node{
	int x;
	int y;
	int t;
	int type;
	Node(int x, int y, int t, int type){
		this.x=x;
		this.y=y;
		this.t=t;
		this.type=type;
	}

}
