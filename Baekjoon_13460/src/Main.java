import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static char[][] map;
	static int[] red;
	static int[] blue;
	static int[] hole;
	static int[] output;
	static int answer = Integer.MAX_VALUE;


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n =Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		output = new int[10];
		red = new int[2];
		blue = new int[2];
		hole = new int[2];
		for(int i=0; i<n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				map[i][j] = tmp[j];
				if(map[i][j]=='R') {
					map[i][j]='.';
					red[0]=i;
					red[1]=j;
				}
				else if(map[i][j]=='B') {
					map[i][j]='.';
					blue[0]=i;
					blue[1]=j;
				}
				else if(map[i][j]=='O') {
					hole[0]=i;
					hole[1]=j;
				}
			}
		}
		per(0,red[0],red[1],blue[0],blue[1]);
		if(answer==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(answer);
		}


	}

	public static void per(int c,int redx, int redy, int bluex, int bluey) {
		if(c==10) {
			return;
		}
		else {
			for(int i=0; i<4; i++) {
				int[] tmp = new int[4];
				if(c==0) {
					
					output[c]=i;
					tmp=move(i, redx, redy,bluex,bluey);
					if(tmp[2]==hole[0] && tmp[3] ==hole[1]) { //파란구슬 빠짐
						continue;
					}
					if(tmp[0]==hole[0] && tmp[1]==hole[1]) {
						//빨간 구슬만 빠짐.
						
						answer = Math.min(c+1, answer);
						//이미 빨간 구슬은 빠져버렸으므로 return;
						continue;
					}
					per(c+1,tmp[0],tmp[1],tmp[2],tmp[3]);
				}
				else {
					if(output[c-1]==0 || output[c-1]==2) {
						if(i==1 || i==3) {
							output[c]=i;
							tmp=move(i, redx, redy,bluex,bluey);
							if(tmp[2]==hole[0] && tmp[3] ==hole[1]) { //파란구슬 빠짐
								continue;
							}
							if(tmp[0]==hole[0] && tmp[1]==hole[1]) {
								//빨간 구슬만 빠짐.
								answer = Math.min(c+1, answer);
								//이미 빨간 구슬은 빠져버렸으므로 return;
								continue;
							}
							per(c+1,tmp[0],tmp[1],tmp[2],tmp[3]);
						}
					}
					else if(output[c-1]==1 || output[c-1]==3) {
						if(i==2 || i==0) {
							output[c]=i;
							tmp=move(i, redx, redy,bluex,bluey);
							if(tmp[2]==hole[0] && tmp[3] ==hole[1]) { //파란구슬 빠짐
								continue;
							}
							if(tmp[0]==hole[0] && tmp[1]==hole[1]) {
								//빨간 구슬만 빠짐.
								answer = Math.min(c+1, answer);
								//이미 빨간 구슬은 빠져버렸으므로 return;
								continue;
							}
							per(c+1,tmp[0],tmp[1],tmp[2],tmp[3]);
						}
					}
				}

			}
		}
	}

	public static int[] move(int a, int redx, int redy, int bluex, int bluey) { //0123
		switch(a) {
		case 0:
			//위로 기울일 때 더 윗행부터 움직이자.
			if(redx<=bluex) { //행--;
				while(map[redx-1][redy]=='.'||map[redx-1][redy]=='O') {
					redx-=1;
					if(map[redx][redy]=='O') {
						break;
					}
				}
				while((map[bluex-1][bluey]=='.'||map[bluex-1][bluey]=='O')&&(bluex-1!=redx||bluey!=redy||map[redx][redy]=='O')) {
					bluex-=1;
					if(map[bluex][bluey]=='O') {
						break;
					}
				}
			}
			else {//blue가 더 위에 있네.
				while(map[bluex-1][bluey]=='.'||map[bluex-1][bluey]=='O') {
					bluex-=1;
					if(map[bluex][bluey]=='O') {
						break;
					}
				}
				while((map[redx-1][redy]=='.'||map[redx-1][redy]=='O')&&(redx-1!=bluex||redy!=bluey||map[bluex][bluey]=='O')) {
					redx-=1;
					if(map[redx][redy]=='O') {
						break;
					}
				}

			}
			break;

		case 1:
			//더 오른쪽에 있는 거 먼저 움직이자.
			if(redy>=bluey) { //열++;
				while(map[redx][redy+1]=='.'||map[redx][redy+1]=='O') {
					redy+=1;
					if(map[redx][redy]=='O') {
						break;
					}
				}
				while((map[bluex][bluey+1]=='.'||map[bluex][bluey+1]=='O')&&(bluex!=redx||bluey+1!=redy||map[redx][redy]=='O')) {
					bluey+=1;
					if(map[bluex][bluey]=='O') {
						break;
					}
				}
			}
			else {
				while(map[bluex][bluey+1]=='.'||map[bluex][bluey+1]=='O') {
					bluey+=1;
					if(map[bluex][bluey]=='O') {
						break;
					}
				}
				while((map[redx][redy+1]=='.'||map[redx][redy+1]=='O')&&(bluex!=redx||bluey!=redy+1||map[bluex][bluey]=='O')) {
					redy+=1;
					if(map[redx][redy]=='O') {
						break;
					}
				}
			}
			break;

		case 2:
			if(redx>=bluex) {//더 아래에있는거 부터 움직이자 더 아랫행. 행++
				while(map[redx+1][redy]=='.'||map[redx+1][redy]=='O') {
					redx+=1;
					if(map[redx][redy]=='O') {
						break;
					}
				}
				while((map[bluex+1][bluey]=='.'||map[bluex+1][bluey]=='O')&&(bluex+1!=redx||bluey!=redy||map[redx][redy]=='O')) {
					bluex+=1;
					if(map[bluex][bluey]=='O') {
						break;
					}
				}
			}
			else {
				while(map[bluex+1][bluey]=='.'||map[bluex+1][bluey]=='O') {
					bluex+=1;
					if(map[bluex][bluey]=='O') {
						break;
					}
				}
				while((map[redx+1][redy]=='.'||map[redx+1][redy]=='O')&&(redx+1!=bluex||redy!=bluey||map[bluex][bluey]=='O')) {
					redx+=1;
					if(map[redx][redy]=='O') {
						break;
					}
				}
			}
			break;

		case 3:
			//열이 더 작은것 부터 움직이자
			if(redy<=bluey) {//열--;
				while(map[redx][redy-1]=='.'||map[redx][redy-1]=='O') {
					redy-=1;
					if(map[redx][redy]=='O') {
						break;
					}
				}
				while((map[bluex][bluey-1]=='.'||map[bluex][bluey-1]=='O')&&(bluex!=redx||bluey-1!=redy||map[redx][redy]=='O')) {
					bluey-=1;
					if(map[bluex][bluey]=='O') {
						break;
					}
				}
			}
			else {
				while(map[bluex][bluey-1]=='.'||map[bluex][bluey-1]=='O') {
					bluey-=1;
					if(map[bluex][bluey]=='O') {
						break;
					}
				}
				while((map[redx][redy-1]=='.'||map[redx][redy-1]=='O')&&(bluex!=redx||bluey!=redy-1||map[bluex][bluey]=='O')) {
					redy-=1;
					if(map[redx][redy]=='O') {
						break;
					}
				}
			}
			break;

		}
		int[] tmp = {redx,redy,bluex,bluey};
		return tmp;

	}
}


