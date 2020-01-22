import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static int d;
	static int cx;
	static int cy;
	static int answer;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		answer=0;
		st = new StringTokenizer(br.readLine());
		cx = Integer.parseInt(st.nextToken());
		cy = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken()); // 0123 �ϵ�����
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(cx,cy,d,0);
		System.out.println(answer);
	}
	
	public static void dfs(int cx, int cy, int d, int count) {
		if(count==4) {
			//��ĭ ���� �Ǵ� �۵� ����
			int nx2, ny2;
			if(d==0) {
				nx2 = cx+1;
				ny2 = cy;
			}
			else if(d==1) {
				nx2=cx;
				ny2 = cy-1;
			}
			else if(d==2) {
				nx2=cx-1;
				ny2=cy;
			}
			else {
				nx2 = cx;
				ny2 = cy+1;
			}
			if(map[nx2][ny2]!=1) { //���� �����ϸ�.
				dfs(nx2,ny2,d,0);
			}
			else { //���� �Ұ����ϸ� ����.
				return;
			}
		}
		else {
			if(map[cx][cy]==0){
				map[cx][cy]=2; //���� ��ġ�� û������.
				answer+=1;
			}
			int nx, ny=0;
			if(d==0) {
				nx = cx;
				ny = cy-1;
			}
			else if(d==1){
				nx = cx-1;
				ny = cy;
			}
			else if(d==2){
				nx = cx;
				ny = cy+1;
			}
			else {
				nx = cx+1;
				ny = cy;
			}
//			
//			if(nx<0||ny<0||nx>n-1||ny>m-1) {
//				dfs(cx,cy,d,count+1); ����� ��� �ܰ��� ��.
//			}
			if(map[nx][ny]==0) { //Ž�� �� �̵�
				d=d-1;
				if(d<0) {
					d=3;
				}
				dfs(nx,ny,d,0);
			}
			else { //û�� �Ǿ������� ��ġ �״�� ȸ����....
				d=d-1;
				if(d<0) {
					d=3;
				}
				dfs(cx,cy,d,count+1);
			}
		}
		
	}
	
}


