import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,-1,-1,0,0,0,1,1,1};
	static int[] dy = {1,0,-1,1,0,-1,1,0,-1};
	static Set<Node> st;


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[8][8];
		visited = new boolean[8][8];
		st = new HashSet<>();
		for(int i=0; i<8; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<8; j++) {
				map[i][j] = tmp[j];
				if(map[i][j]=='#') {
					st.add(new Node(i,j,0)); //���� ó���� �� 0��
				}
			}
		}
		// ���� �����µ� ���� �ִ� �ڸ��δ� �Ȱ��� ���� ������ ���� �������� ����...
		Queue<Node> que = new LinkedList<>();
		int count=0; //���� ����.
		//���ʿ� �� ������ ����
		int tcount=0;
		int icount=0;
		que.add(new Node(7,0,0)); //0�ʺ��� ����.
		tcount=1;
		while(!que.isEmpty()) {
			Node t= que.poll();
			tcount-=1;
			if(t.x==0 && t.y==7 || st.size()==0	) { //���� ���̻� ���ٸ� ����...
				System.out.println(1);
				System.exit(0);
				break;
			}
			for(int i=0; i<9; i++) {
				int nx = t.x+dx[i];
				int ny = t.y+dy[i];
				if(nx>=0 && ny>=0 && nx<8 && ny<8) {
					if(!st.contains(new Node(nx,ny,t.c))) { //���� ��ġ�� nx ny�� ���� ���ٸ�
						if(nx>0) {
							if(!st.contains(new Node(nx-1,ny,t.c))) {
								que.add(new Node(nx,ny,t.c+1)); //���� �ķ��͵� ����
								icount+=1;
							}
						}
						else {
							que.add(new Node(nx,ny,t.c+1));
							icount+=1;
						}
					}
				}
			}
			
			if(tcount==0) { //que�� c���� count�ΰ� ����� �� �����ؾ���.
				Iterator it = st.iterator();
				Set<Node> st2 = new HashSet<>();
				while(it.hasNext()) {
					Node d = (Node)it.next();
					d.down();
					if(d.x<8) {
						st2.add(d);
					}
				}
				st=st2;
				tcount=icount;
				icount=0;
			}
			
		
			

		}
		System.out.println(0);

	}
}

class Node{
	int x;
	int y;
	int c;
	public Node(int x, int y, int c) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		this.c=c;
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
		if(t.x==this.x && t.y== this.y) {
			return true;
		}
		return false;

	}

	public void down() {
		this.x+=1;
	}
}
