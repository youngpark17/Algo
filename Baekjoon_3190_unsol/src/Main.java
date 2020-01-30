import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static int n;
	static int k;
	static int[][] map;
	static Map<Integer, Character> mp;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n =Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1]; //�⺻��  0, ���� 1,����� 2
		mp = new HashMap<>();
		for(int i=0; i<k; i++) {
			String[] tmp = br.readLine().split(" ");
			int r = Integer.parseInt(tmp[0]);
			int c = Integer.parseInt(tmp[1]);
			map[r][c] = 2;
		}
		int  l = Integer.parseInt(br.readLine());
		for(int i=0; i<l; i++) {
			String[] tmp = br.readLine().split(" ");
			mp.put(Integer.parseInt(tmp[0]), tmp[1].charAt(0));
		}
		dfs(1,1,0,1,0); //1234 ������ ���� �� �Ʒ�


	}

	public static void dfs(int x, int y, int flag, int head, int timer) {
		if(x<1 || y<1 || x>n || y>n) {
			System.out.println(timer);
			return;
		}

		if(map[x][y]==1) { //���� �ε���
			System.out.println(timer);
			return;
		}
		if(map[x][y]!=2) {//�Դµ� ����� ������ �� ������. ���� Ž������ 1�ΰ� ���� 0���� �ٲ���.
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(map[i][j]==1) {
						map[i][j]=0;
					}
				}
			}
		}

		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("\n");


		if(mp.containsKey(timer)) { //���� ��ȯ
			char c = mp.get(timer);
			if(c=='L') {
				if(head==1) {//�������� �ٶ󺸰� �־����� ���� �ٶ󺸰���.
					head=3;
				}
				else if(head==2) {
					head=4;
				}
				else if(head==3) {
					head=2;
				}
				else {
					head=1;
				}
			}
			else if(c=='D') {
				if(head==1) {
					head=4;
				}
				else if(head==2) {
					head=3;
				}
				else if(head==3) {
					head=1;
				}
				else {
					head=2;
				}
			}
		}
		if(map[x][y]==2) {//����� �԰� ���� ������ �� ����
			map[x][y]=1; //�Ծ��ٰ� ���� ǥ��.
			if(head==1) {
				dfs(x,y+1,1,head,timer+1);
			}
			if(head==2) {
				dfs(x,y-1,1,head,timer+1);
			}
			if(head==3) {
				dfs(x-1,y,1,head,timer+1);
			}
			if(head==4) {
				dfs(x+1,y,1,head,timer+1);
			}
		}
		else { //����� �ȸ԰� ���� ���ʷ� �� ����
			map[x][y] = 5; //�ȸ����� ������ ����.
			if(head==1) {
				dfs(x,y+1,0,head,timer+1);
			}
			if(head==2) {
				dfs(x,y-1,0,head,timer+1);
			}
			if(head==3) {
				dfs(x-1,y,0,head,timer+1);
			}
			if(head==4) {
				dfs(x+1,y,0,head,timer+1);
			}

		}


	}
	
}






