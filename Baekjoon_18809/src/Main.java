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
				//0,1,2 ȣ�� ���׸��Ѹ��¶�, �Ѹ����մ¶�
				map[i][j] =Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					list.add(new Node(i,j,0,0));
				}
			}
		}
		visited = new boolean[list.size()];
		//list���� r+g���� ����. �� �� �������� r���� �̰� ���� g���� ������ �װſ� ���ؼ� ����.
		comb(0,0);
		System.out.println(answer);
	}
	public static void comb(int c, int d) {
		if(c==r+g) {
			//���տ��� ������ �迭�� ��� �װſ� ���ؼ� �ٽ� ����.
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
			//���� �湮���߰� time[a.x][a.y]�� a.t+1�̶� ���ų� ������ ����.
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
			//output�� ���� �տ��� r, �ڿ��� g. 0~+r-1���� r r���� r+g-1���� g����� ġ��
			//�̷����ϸ� �Ȱ��� ��� �Ǽ�. 12/345�� 21/345�� ��������ε� �Ǽ��Եȴ�.
			//r���� �̰� �������� g����� ��������.
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
			//���Ľ��Ѻ���
			move(red,blue);
			
		}
		if(idx==r+g) {
			return;
		}
		visited2[idx]=true;
		per(idx+1,c+1); //�����ϰ� �Ѿ��
		visited2[idx] = false;
		per(idx+1,c); //���þ��ϰ� �Ѿ��
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
