import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static List<Node> list;
	static List<Node> list2;
	static boolean[] visited;
	static int[][] map2;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static int max;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		map = new int[n][m];
		list = new ArrayList<>();
		list2 = new ArrayList<>();
		map2 = new int[n][m];
		max=0;
		for(int i=0; i<n; i++) {
			tmp = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				if(map[i][j]==2) {
					list.add(new Node(i,j)); //바이러스가 퍼지기 시작 하는 좌표 저장.
				}
				if(map[i][j]==0) {
					list2.add(new Node(i,j));//벽 세울 수 있는 좌표 저장.
				}
			}
		}
		visited = new boolean[list2.size()];
		comb(0,0);
		System.out.println(max);
	}

	public static void comb(int d, int c) { //d는 몇개까지 확인했나 comb호출된 횟수 , c는 뽑은 개수
		if(c==3) {
			for(int i=0; i<n;i++) {
				for(int j=0; j<m; j++) {
					map2[i][j] = map[i][j];
				}
			}
			for(int i=0; i<list2.size(); i++) {
				if(visited[i]) {
					Node n = list2.get(i);
					map2[n.x][n.y]=1; //벽으로 선택된 개수
				}
			}
			//2인 곳부터 바이러스 퍼트리자....
			Queue<Node> que = new LinkedList<>();
			for(int i=0; i<list.size(); i++) {
				que.add(list.get(i));
			}

			while(!que.isEmpty()) {
				Node t = que.poll();
				map2[t.x][t.y]=2;
				for(int i=0; i<4; i++) {
					int nx = t.x+dx[i];
					int ny = t.y+dy[i];
					if(nx<0 || ny<0 || nx>n-1 || ny >m-1) {
						continue;
					}
					if(map2[nx][ny]==1 || map2[nx][ny]==2) { //다음에 갈 곳이 벽이라면...
						continue;
					}
					que.add(new Node(nx,ny));
				}
			}

			int cnt=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map2[i][j]==0) {
						cnt++;
					}
				}
			}
			max = Math.max(cnt, max);
		}
		else {
			d+=1;
			for(int i=d-1; i<list2.size(); i++) {
				if(!visited[i]) {
					visited[i] = true;
					comb(d,c+1);
					visited[i] = false;
				}
			}
		}


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
