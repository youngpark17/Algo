import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static int m;
	static int[][] arr;
	static int[][] visited;
	static int[][] distance;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//���� �μ��� �̵��� ���� �ְ� �Ⱥμ��� �̵��� ���� �ִ�. 01
		//										   00 ���� 1,1���� ���� ���.. �׷��� ���� �Ⱥμ��� �̵��ϴ°�찡 �켱������ ����.
		//���� �μ��� �̵��� ���� �湮�� 1�� üũ �Ⱥμ��� �̵��� ���� 2�� üũ.
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		arr = new int[n][m];
		visited = new int[n][m];
		distance = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		distance[0][0]=0;
		for(int i=0; i<n; i++) {
			char[] tmp2 = br.readLine().toCharArray();
			for(int j=0; j<m;j++) {
				arr[i][j] = tmp2[j]-'0';
			}
		}
		
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(0,0,false,1));
		while(!que.isEmpty()) {
			Node t = que.poll();
			if(t.x==n-1 && t.y==m-1) {
				System.out.println(t.d);
				System.exit(0);
			}
			for(int i=0; i<4; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				//�� �μ��� �湮�Ҷ��� ���� ���� �ȵȰ͸� ó��, �Ⱥμ��� �湮�Ҷ��� ���ŵȰ͵� ó��.
				//�ѹ��� �湮 ���Ѱ�, �μ��� �湮������ 1ó�� �ƴϸ� 2ó�� 
				if(nx>=0 && ny>=0 && nx<n &&ny<m) {//�湮 ����
					if(visited[nx][ny]==0) { //�ѹ��� �湮 ���Ѱ�.
						if(arr[nx][ny]==0 &&!t.flag) {//�Ⱥμ��� �湮����. 2 ó��
							visited[nx][ny]=2;
							que.add(new Node(nx,ny,false,t.d+1));
						}
						else if(arr[nx][ny]==0 &&t.flag) {//�Ⱥμ��� �湮����. 2 ó��
							visited[nx][ny]=1;
							que.add(new Node(nx,ny,true,t.d+1));
						}
						else if(arr[nx][ny]==1 &&!t.flag) {
							visited[nx][ny]=1;
							que.add(new Node(nx,ny,true,t.d+1));
						}
					}
					else if(visited[nx][ny]==1) {//������ �Ǿ�������, �� �μ��� �湮�� ���̹Ƿ� �Ⱥμ��� �湮�Ѱ͵� ����.
						if(!t.flag) {
							if(arr[nx][ny]==0) {
								que.add(new Node(nx,ny,false,t.d+1));
								visited[nx][ny]=2;
							}
						}
					}
					
				}
			}
		}
		System.out.println(-1);
		
		

	}

}

class Node{
	int x;
	int y;
	boolean flag;
	int d;
	public Node(int x, int y, boolean flag, int d) {
		this.x = x;
		this.y = y;
		this.flag = flag;
		this.d = d;
	}
	
	
}