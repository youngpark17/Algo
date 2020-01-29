import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int k;
	static int[][] map;
	static Ground[][] ground;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static Set<Node> set;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//�� ������ �ڽ��� ���̸�ŭ ����� �԰� ���̰� 1����. ����̺��� ��и԰�, ���� ����� �����ؼ� �������� ���.
		//�������� ������ ���� ������ ����/2 ���� ������� �߰�
		//�������� 8�������� ���� ����
		//�ܿ￡�� �κ��� ��� �־��� ����ŭ �߰�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		ground = new Ground[n][n];
		set = new HashSet<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				ground[i][j] = new Ground(5); //ó���� 5�� ����ְ�. ������ ����.
			}
		}

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int tx = Integer.parseInt(st.nextToken());
			int ty = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			ground[tx-1][ty-1].tree.add(age); // ���� �߰�.
			set.add(new Node(tx-1, ty-1));
		}

		for(int i=0; i<k; i++) { //k�� ���� �ùķ��̼� �غ���.
			//������ ����.
			Iterator<Node> it = set.iterator();
			while(it.hasNext()) {
				Node q = it.next();
				int r =q.x;
				int c =q.y;
				Collections.sort(ground[r][c].tree); //���� �� ��
				int b=0;
				for(int t : ground[r][c].tree) {
					if(ground[r][c].nutrition>=t) {
						ground[r][c].nutrition-=t;
						b++;
					}
					else {
						break;
					}
				}
				for(int z=b; z<ground[r][c].tree.size(); z++) {
					ground[r][c].nutrition+=(ground[r][c].tree.get(z)/2); //������ ��翡 ����.
				}
				ground[r][c].tree = ground[r][c].tree.subList(0, b);
				for(int z=0; z<ground[r][c].tree.size();z++) { 
					ground[r][c].tree.set(z, ground[r][c].tree.get(z)+1);
				}
				if(ground[r][c].tree.size()==0) {
					set.remove(new Node(r,c));
				}

			}

			Iterator<Node> it2 = set.iterator();
			while(it2.hasNext()) {
				Node q = it2.next();
				int r = q.x;
				int c = q.y;
				for(int t : ground[r][c].tree) {
					if(t%5==0) {
						for(int z=0; z<8; z++) {
							int nextX = r+dx[z];
							int nextY = c+dy[z];
							if(nextX<0||nextY<0 ||nextX>n-1 || nextY>n-1) {
								continue;
							}
							ground[r+dx[z]][c+dy[z]].tree.add(1);
							set.add(new Node(r+dx[z],c+dy[z]));
						}
					}
				}
			}

			//�������� ��.


			//�������� ��
			for(int r=0; r<n; r++) {
				for(int c=0; c<n; c++) {
					ground[r][c].nutrition+=map[r][c];
				}
			}

		}

		int answer=0;
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				answer+=ground[r][c].tree.size();
			}
		}
		System.out.println(answer);




	}

}

class Node{
	int x;
	int y;

	Node(int x, int y){
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
		if(this.x!=t.x) {
			return false;
		}
		if(this.y!=t.y) {
			return false;
		}
		return true;
	}


}

class Ground{
	List<Integer> tree; //integer�� ������ ����
	int nutrition; // ���

	Ground(int nu){
		this.nutrition=nu;
		tree = new ArrayList<>();
	}

}
