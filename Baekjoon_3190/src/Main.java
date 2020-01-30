import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	static int n;
	static int k;
	static int l;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			String[] tmp = br.readLine().split(" ");
			int x = Integer.parseInt(tmp[0])-1;
			int y = Integer.parseInt(tmp[1])-1;
			map[x][y] =1; //����� �����ִ� ��ġ.
		}
		l = Integer.parseInt(br.readLine());
		Map<Integer, Character> mp = new HashMap<>();
		for(int i=0; i<l; i++) {
			String[] tmp = br.readLine().split(" ");
			mp.put(Integer.parseInt(tmp[0]), tmp[1].charAt(0));
		}
		int timer=0;
		int ro = 1; //ó���� ���������� �ð�������� 1234
		int x=0;
		int y=0;
		int nextX=0;
		int nextY=0;
		int tailx=0;
		int taily=0;
		List<Node> list = new LinkedList<>();
		while(true) {
			if(ro==1) {
				nextY=y+1;
			}
			else if(ro==2) {
				nextX = x+1;
			}
			else if(ro==3) {
				nextY=y-1;
			}
			else if(ro==4) {
				nextX=x-1;
			}
			if(nextX<0 || nextY<0 || nextX>n-1 || nextY>n-1||map[nextX][nextY]==2) {//���̳� ����.
				System.out.println(timer+1);
				break;
			}
			if(list.contains(new Node(nextX, nextY))) { //�̹� ���� �ִ°��� �� ������ �ϸ�
				System.out.println(timer+1);
				break;
			}
			list.add(new Node(nextX, nextY)); //���� �̵� ��� ������� ���.
			if(map[nextX][nextY]==1) { //����� �ִٸ�.... 
				map[tailx][taily]=2; //������ ��������.
				map[nextX][nextY]=0;
			}
			else { //����� ���ٸ�
				Node t = list.remove(0);
				map[tailx][taily] = 0;
				tailx=t.x;
				taily=t.y;
				map[tailx][taily]=2;
			}
			timer++;
////			for(int i=0; i<n; i++) {
////				for(int j=0; j<n; j++) {
////					System.out.print(map[i][j]+" ");
////				}
////				System.out.println();
////			}
//			System.out.println();
			if(mp.containsKey(timer)) {
				char c = mp.get(timer);
				if(c=='L') {//���� ȸ��
					ro-=1;
					if(ro==0) {
						ro=4;
					}
				}
				else {
					ro+=1;
					if(ro==5) {
						ro=1;
					}
				}
			}
			x=nextX;
			y=nextY;
			
		}
		
		
		
		
		
		
	}

}



class Node{ //���� ������ �����ִ� ��ġ....
	int x;
	int y;
	public Node(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Integer.hashCode(x+y);
		}
	
	@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
		Node t = (Node)obj;
			if(this.x==t.x  && this.y==t.y) {
				return true;
			}
			else {
				return false;
			}
		}
}
