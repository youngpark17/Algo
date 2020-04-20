import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.net.ssl.HostnameVerifier;

public class Main {
	static int n;
	static int k;
	static int[][] mapColor;
	static Node[] horse;
	static int[][] mapHorse;
	static int[] horseUp; //�����ִ� �� ��ȣ
	static int[] horseDown;
	static int turnNumber=0;
	static boolean flag=false;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		mapColor = new int[n][n];
		mapHorse = new int[n][n];
		horse = new Node[k];
		horseUp = new int[k];
		horseDown = new int[k];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				mapColor[i][j] = Integer.parseInt(st.nextToken());
				mapHorse[i][j] = -1;
			}
		}
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			mapHorse[a-1][b-1]=i;
			horse[i] = new Node(a-1,b-1,c); //1234 �� �� �� �Ʒ�
			horseUp[i]=-1; //ó���� �����ִ� �� �����ϱ� -1
			horseDown[i]=-1;
		}
		while(!flag && turnNumber<=1000) {
			gameStart();
		}
		if(!flag) {
			System.out.println(-1);
		}
	}

	public static void gameStart() {
		turnNumber++;
		for(int i=0; i<k; i++) {
//			for(int t=0; t<n; t++) {
//				for(int j=0; j<n; j++) {
//					System.out.print(mapHorse[t][j]+1+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			int x = horse[i].x;
			int y = horse[i].y;
			int nx=x;
			int ny=y;
			switch(horse[i].ro) {
			case 1:
				ny+=1;
				break;
			case 2:
				ny-=1;
				break;
			case 3:
				nx-=1;
				break;
			case 4:
				nx+=1;
				break;
			}
			if(nx>n-1 || ny>n-1 || nx<0 || ny<0) { //�Ķ����� ������
				switch(horse[i].ro) {
				case 1:
					horse[i].ro=2;
					ny=y-1;
					break;
				case 2:
					horse[i].ro=1;
					ny=y+1;
					break;
				case 3:
					horse[i].ro=4;
					nx=x+1;
					break;
				case 4:
					horse[i].ro=3;
					nx=x-1;
					break;
				}
				if(mapColor[nx][ny]==2) { //������ �ٲٰ� �̵��Ϸ��� ĭ�� �Ķ����ΰ��
					continue;
				}
				else { //�̵������� �ݴ�� �ϰ� ��ĭ �̵�.
					if(mapColor[nx][ny]==0) {
						move(i,x,y,nx,ny,false);
					}
					else {
						move(i,x,y,nx,ny,true);
					}
				}
			}
			else if(mapColor[nx][ny]==2) {
				switch(horse[i].ro) {
				case 1:
					horse[i].ro=2;
					ny=y-1;
					break;
				case 2:
					horse[i].ro=1;
					ny=y+1;
					break;
				case 3:
					horse[i].ro=4;
					nx=x+1;
					break;
				case 4:
					horse[i].ro=3;
					nx=x-1;
					break;
				}
				if(nx>n-1 || ny>n-1 ||nx <0 || ny<0) {
					continue;
				}
				else if(mapColor[nx][ny]!=2) {
					//�̵������� �ݴ�� �ϰ� ��ĭ �̵�.
					if(mapColor[nx][ny]==0) {
						move(i,x,y,nx,ny,false);
					}
					else {
						move(i,x,y,nx,ny,true);
					}

				}
				else {
					continue;
				}
			}
			else if(mapColor[nx][ny]==0) {
				move(i,x,y,nx,ny,false);
			}
			else if(mapColor[nx][ny]==1) {
				move(i,x,y,nx,ny,true);
			}
		}
	}

	public static void move(int number ,int x, int y, int nx, int ny,boolean check) {
		if(!check) {
			if(mapHorse[nx][ny]==-1) {
				//�����°� ����Ű�� �ִ� ���� ����.(number�� ����Ű�� ����)
				if(horseDown[number]!=-1) { //�ؿ� ���� �־��ٸ�.
					horseUp[horseDown[number]]=-1;
				}
				mapHorse[x][y]=horseDown[number];
				horseDown[number]=-1;
				//nx ny�� �ִ� �Ͱ������ؾߵǴµ� �����ϱ� �׳�.
				int p = findParents(number);
				mapHorse[nx][ny]=p;
				oneMove(number,horse[number].ro);

			}
			else{
				//�̹� ���� �ִ�.
				if(horseDown[number]!=-1) { //�ؿ� ���� �־��ٸ�.
					horseUp[horseDown[number]]=-1;
				}
				mapHorse[x][y]=horseDown[number];
				horseDown[number]=-1;
				//������� ���� �δ� �κ�
				horseUp[mapHorse[nx][ny]]=number;
				horseDown[number]=mapHorse[nx][ny];
				int p = findParents(number); 
				mapHorse[nx][ny]=p;
				oneMove(number,horse[number].ro);
				//k�ؿ� ������ ��� üũ
				int d = getDepth(p,0);
				if(d>=3) {
					System.out.println(turnNumber);
					flag=true;
					return;
				}
			}
		}
		else { //�������� ��� _Ʋ��
			if(mapHorse[nx][ny]==-1) { //���� �ƹ��͵�����.
				if(horseDown[number]!=-1) { //�ؿ� ���� �־��ٸ�.
					horseUp[horseDown[number]]=-1;
				}
				mapHorse[x][y]=horseDown[number];
				horseDown[number]=-1;
				oneMove(number,horse[number].ro);
				reverse(number);
				mapHorse[nx][ny]=number;

				//���� number�� �� ���� ����.

			}
			else {
				if(horseDown[number]!=-1) { //�ؿ� ���� �־��ٸ�.
					horseUp[horseDown[number]]=-1;
				}
				mapHorse[x][y]=horseDown[number];
				horseDown[number]=-1;
				int p = findParents(number);
				oneMove(number,horse[number].ro);
				reverse(number);
				//���� p�� �� �Ʒ��������� p�� ����
				horseUp[mapHorse[nx][ny]]=p;
				horseDown[p] = mapHorse[nx][ny];
				mapHorse[nx][ny] = number;

				int d = getDepth(number,0);
				if(d>=3) {
					System.out.println(turnNumber);
					flag=true;
					return;
				}
			}
		}



	}
	public static void oneMove(int number, int ro) { //���� �Ʒ�������
		if(number==-1) {
			return;
		}
		switch(ro) {
		case 1:
			horse[number].y+=1;
			break;
		case 2:
			horse[number].y-=1;
			break;
		case 3:
			horse[number].x-=1;
			break;
		case 4:
			horse[number].x+=1;
			break;
		}
		oneMove(horseUp[number],ro);
	}

	public static int getDepth(int number, int d) {
		if(horseDown[number]==-1) {
			return d;
		}
		return getDepth(horseDown[number], d+1);
	}



	public static int findParents(int number) {
		if(horseUp[number]==-1) {
			return number;
		}
		return findParents(horseUp[number]);
	}

	public static int findSons(int number) {
		if(horseDown[number]==-1) {
			return number;
		}
		return findSons(horseDown[number]);
	}

	public static void reverse(int number) {
		if(number==-1) {
			return;
		}
		int upTemp = horseUp[number];
		int downTemp = horseDown[number];
		horseUp[number]=downTemp;
		horseDown[number]=upTemp;
		reverse(upTemp);

	}

}

class Node{
	int x;
	int y;
	int ro;
	Node(int x,int y, int ro){
		this.x=x;
		this.y=y;
		this.ro=ro;
	}
}
