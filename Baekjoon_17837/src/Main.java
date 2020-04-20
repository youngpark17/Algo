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
	static int[] horseUp; //엎혀있는 말 번호
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
			horse[i] = new Node(a-1,b-1,c); //1234 오 왼 위 아래
			horseUp[i]=-1; //처음엔 업혀있는 말 없으니까 -1
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
			if(nx>n-1 || ny>n-1 || nx<0 || ny<0) { //파란색을 만난거
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
				if(mapColor[nx][ny]==2) { //방향을 바꾸고 이동하려는 칸이 파란색인경우
					continue;
				}
				else { //이동방향을 반대로 하고 한칸 이동.
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
					//이동방향을 반대로 하고 한칸 이동.
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
				//나가는거 가르키고 있는 연결 끊자.(number를 가르키고 있음)
				if(horseDown[number]!=-1) { //밑에 뭐가 있었다면.
					horseUp[horseDown[number]]=-1;
				}
				mapHorse[x][y]=horseDown[number];
				horseDown[number]=-1;
				//nx ny에 있는 것과연결해야되는데 없으니까 그냥.
				int p = findParents(number);
				mapHorse[nx][ny]=p;
				oneMove(number,horse[number].ro);

			}
			else{
				//이미 뭐가 있다.
				if(horseDown[number]!=-1) { //밑에 뭐가 있었다면.
					horseUp[horseDown[number]]=-1;
				}
				mapHorse[x][y]=horseDown[number];
				horseDown[number]=-1;
				//여기부터 연결 맺는 부분
				horseUp[mapHorse[nx][ny]]=number;
				horseDown[number]=mapHorse[nx][ny];
				int p = findParents(number); 
				mapHorse[nx][ny]=p;
				oneMove(number,horse[number].ro);
				//k밑에 딸린게 몇갠지 체크
				int d = getDepth(p,0);
				if(d>=3) {
					System.out.println(turnNumber);
					flag=true;
					return;
				}
			}
		}
		else { //빨간색인 경우 _틀림
			if(mapHorse[nx][ny]==-1) { //원래 아무것도없음.
				if(horseDown[number]!=-1) { //밑에 뭐가 있었다면.
					horseUp[horseDown[number]]=-1;
				}
				mapHorse[x][y]=horseDown[number];
				horseDown[number]=-1;
				oneMove(number,horse[number].ro);
				reverse(number);
				mapHorse[nx][ny]=number;

				//이제 number가 젤 위에 있음.

			}
			else {
				if(horseDown[number]!=-1) { //밑에 뭐가 있었다면.
					horseUp[horseDown[number]]=-1;
				}
				mapHorse[x][y]=horseDown[number];
				horseDown[number]=-1;
				int p = findParents(number);
				oneMove(number,horse[number].ro);
				reverse(number);
				//이제 p가 젤 아래에있으니 p랑 잇자
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
	public static void oneMove(int number, int ro) { //가장 아래서부터
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
