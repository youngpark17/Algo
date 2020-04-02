import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int r;
	static int c;
	static int m;
	static boolean[] live;
	static Column[] column;
	static PriorityQueue<Shark>[][] map;
	static Shark[] shark;
	static int man;
	static int total=0;
	static int numberOfShark;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st=new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		numberOfShark=m;
		live = new boolean[m]; //false�� �������
		column=new Column[c];
		for(int i=0; i<c; i++) {
			column[i] = new Column(-1,Integer.MAX_VALUE);
		}
		man=-1;
		shark = new Shark[m];
		map = new PriorityQueue[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				map[i][j]=new PriorityQueue<Shark>();
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int r_ = Integer.parseInt(st.nextToken())-1;
			int c_ = Integer.parseInt(st.nextToken())-1;
			int s  =Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			shark[i] = new Shark(i,r_,c_,s,d,z);
			if(column[c_].r>r_) {
				column[c_].number=i;
				column[c_].r=r_;
			}
		}
		
		while(man!=c-1) {
			man+=1;
			//���ÿ��� �ִ� ���� �ִ� ��� �߿��� ���� ���� ����� �� ��´�. �� ������ �����ǿ��� ���� �� �������.
			if(column[man].number>=0) {
				total+=shark[column[man].number].z;
				live[column[man].number]=true; //��� ���
				numberOfShark--;
				if(numberOfShark==0) {
					break;
				}
			}
			for(int i=0; i<m; i++) {
				if(!live[i]) { //�� ����ִٸ� ��������.
					move(shark[i]);
					map[shark[i].r][shark[i].c].add(shark[i]);
				}
			}
			
			//��Ƹ���
			
			for(int i=0; i<m; i++) {
				if(!live[i]) {
					while(map[shark[i].r][shark[i].c].size()>1) {
						Shark sh=map[shark[i].r][shark[i].c].poll();
						live[sh.number]=true; //��� ��Ƹ���
					}
					map[shark[i].r][shark[i].c].clear();
				}
			}
			
			//column ������Ʈ
			for(int i=0; i<c; i++) {
				column[i] = new Column(-1,Integer.MAX_VALUE);
			}
			for(int i=0; i<m; i++) {
				if(!live[i] && shark[i].r<column[shark[i].c].r) { //�� ��������� �� ��ġ ������Ʈ
					column[shark[i].c].r=shark[i].r;
					column[shark[i].c].number=shark[i].number;
					//column �ּҰ� ����
				}
			}
			
		
			
		}
		bw.append(total+"");
		bw.flush();
		bw.close();
		
	}
	
	public static void move(Shark shark) { //�ӷ� s �̵����� d ũ�� z 1234 ���Ʒ������ʿ���
		if(shark.d==1) {
			if(shark.r-shark.s<0) {
				int tmp=shark.r; //shark.r���� 0���� �̵��ѰŸ�
				shark.s-=tmp; //�̵��� �Ÿ� ����
				shark.r=0; //0�� ������
				shark.d=2; //������ 2
				move(shark);
				shark.s+=tmp;
			}
			else {
				shark.r=shark.r-shark.s;
			}
		}
		else if(shark.d==2) {
			if(shark.r+shark.s>r-1) {
				int tmp=r-1-shark.r;
				shark.s-=tmp;
				shark.r=r-1;
				shark.d=1;
				move(shark);
				shark.s+=tmp;
			}
			else {
				shark.r=shark.r+shark.s;
			}
		}
		else if(shark.d==3) {
			if(shark.c+shark.s>c-1) {
				int tmp=c-1-shark.c;
				shark.s-=tmp;
				shark.c=c-1;
				shark.d=4;
				move(shark);
				shark.s+=tmp;
			}
			else {
				shark.c=shark.c+shark.s;
			}
		}
		else if(shark.d==4) {
			if(shark.c-shark.s<0) {
				int tmp=shark.c;
				shark.s-=tmp;
				shark.c=0;
				shark.d=3;
				move(shark);
				shark.s+=tmp;
			}
			else {
				shark.c=shark.c-shark.s;
			}
		}
			
	}
		

}

class Column{
	int number;
	int r;
	public Column(int number, int r) {
		// TODO Auto-generated constructor stub
		this.number=number;
		this.r=r;
	}
}

class Shark implements Comparable<Shark>{
	int number;
	int r;
	int c;
	int s;
	int d;
	int z;
	public Shark(int number,int r, int c, int s, int d, int z) {
		this.number=number;
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
	
	@Override
	public int compareTo(Shark o) {
		// TODO Auto-generated method stub
		//�ּ���
		return this.z-o.z;
	}
	
}
