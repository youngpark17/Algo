import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static int n;
	static int l;
	static int r;
	static Node[][] node;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[] parent;
	static int sum=0;
	static int cnt=0;
	static int answer=0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		l = Integer.parseInt(tmp[1]);
		r = Integer.parseInt(tmp[2]);
		parent=new int[n*n];
		node = new Node[n][n];
		for(int i=0; i<n; i++) {
			tmp = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				node[i][j] = new Node(Integer.parseInt(tmp[j]));
			}
		}
		answer=0;
		while(true) {
			boolean answerflag=false;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					for(int k=0; k<4; k++) {
						int nextX = i+dx[k];
						int nextY = j+dy[k];
						if(nextX<0 || nextY<0 || nextX>n-1 || nextY>n-1) {
							continue;
						}
						node[i][j].flag[k] = false;
					}
				}
			}
			for(int i=0; i<n; i++) { //±¹°æ ¿°.
				for(int j=0; j<n; j++) {
					for(int k=0; k<4; k++) {
						int nextX = i+dx[k];
						int nextY = j+dy[k];
						if(nextX<0 || nextY<0 || nextX>n-1 || nextY>n-1) {
							continue;
						}
						int diff = Math.abs(node[nextX][nextY].numbers-node[i][j].numbers);
						if(diff>=l && diff<=r) {
							node[i][j].flag[k] = true;
							answerflag=true;
						}
					}
				}
			}
			if(!answerflag) {
				System.out.println(answer);
				System.exit(0);
			}
			answer++;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					node[i][j].visited=false;
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!node[i][j].visited) {
						List<map> list = new LinkedList<>();
						dfs(i,j,list);
						cnt = list.size();
						for(map t : list) {
							sum+=node[t.x][t.y].numbers;
						}
						for(map t : list) {
							node[t.x][t.y].numbers = sum/cnt;
						}
						sum=0;
						cnt=0;
					}
				}
			}
		
		}
		
		
		
		
	}

	
	public static void dfs(int a, int b, List<map> list) {
		node[a][b].visited=true;
		list.add(new map(a,b));
		for(int i=0; i<4; i++) {
			int nx = a+dx[i];
			int ny = b+dy[i];
			if(nx<0 ||ny<0 ||nx>n-1 ||ny>n-1||!node[a][b].flag[i]) {
				continue;
			}
			if(!node[nx][ny].visited) {
				node[a][b].flag[i] = false;
				dfs(nx,ny,list);
			}
		}
	}
	
}
class map{
	int x;
	int y;
	map(int x, int y){
		this.x=x;
		this.y=y;
	}
}
class Node{
	boolean visited;
	int numbers;
	boolean[] flag;
	int parent;
	
	public Node(int numbers) {
		this.numbers=numbers;
		flag = new boolean[4];
		parent=0;
		visited = false;
	}
}
