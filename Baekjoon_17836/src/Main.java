import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static int[][] map;
	static boolean[][] visited;
	static int answer;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		int t = Integer.parseInt(tmp[2]);
		map = new int[n][m];
		answer=0;
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) { //값 초기화
			tmp = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(0,0,0)); // 00에서 시작
		visited[0][0]=true;
		while(!que.isEmpty()) {
			Node p = que.poll();
			for(int i=0; i<4; i++) {
				int x1 = p.x+dx[i];
				int y1 = p.y+dy[i];
				int c = p.c+1;
				if(x1<0||y1<0||x1>=m||y1>=n) {
					continue;
				}
				if(visited[y1][x1]||map[y1][x1]==1) {
					continue;
				}
				if(x1==m-1&&y1==n-1) { //gram(검)을 찾지 못하고 공주먼저발견
					if(answer!=0) {
						answer=Math.min(c, answer);
					}
					else {
						answer=c;
					}
					
				}
				if(map[y1][x1]==2) { //검을 찾아서가는 것보다 공주 찾는게 먼저 빠를수도
					int k=c+(m-1-x1)+(n-1-y1); //칼을 찾았을 경우 공주에게 가는 비용.
					if(answer!=0) {
						answer=Math.min(k, answer);
					}
					else {
						answer=k;
					}
					
				}
				que.add(new Node(x1,y1,c));
				visited[y1][x1]=true;
			}
		}
		if(answer==0) { //가능한 경우를 모두 돌았지만 경로가 없음.
			System.out.println("Fail");
		}
		else {
			if(answer>t) { //경로는 있지만 주어진 시간내에 갈수 없음.
				System.out.println("Fail");
			}
			else {
				System.out.println(answer);
			}
			
		}

	}

}

class Node{
	int x;
	int y;
	int c;
	public Node(int x, int y, int c) {
		this.x=x;
		this.y=y;
		this.c=c;
	}
}
