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
		for(int i=0; i<n; i++) { //�� �ʱ�ȭ
			tmp = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(0,0,0)); // 00���� ����
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
				if(x1==m-1&&y1==n-1) { //gram(��)�� ã�� ���ϰ� ���ָ����߰�
					if(answer!=0) {
						answer=Math.min(c, answer);
					}
					else {
						answer=c;
					}
					
				}
				if(map[y1][x1]==2) { //���� ã�Ƽ����� �ͺ��� ���� ã�°� ���� ��������
					int k=c+(m-1-x1)+(n-1-y1); //Į�� ã���� ��� ���ֿ��� ���� ���.
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
		if(answer==0) { //������ ��츦 ��� �������� ��ΰ� ����.
			System.out.println("Fail");
		}
		else {
			if(answer>t) { //��δ� ������ �־��� �ð����� ���� ����.
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
