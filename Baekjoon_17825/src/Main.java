import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] number;
	static int[] output;
	static int[] horse;
	static int score = Integer.MIN_VALUE;
	static int[] map;
	static int[] next;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		number = new int[10];
		horse = new int[4];
		output = new int[10];
		//1, 1, 1, 2, 3, 3, 3, 3, 3, 1 3번 테스트케이스
		
		map = new int[33];
		next = new int[33];
		// 반시계로 돈다치면 ...
		for(int i=1; i<=20; i++) {
			map[i]=i*2;
		}
		map[21]=13; map[22]=16; map[23]=19; map[24]= 25; map[25] = 22; map[26]=24;
		map[27]=28; map[28]=27; map[29]=26; map[30]=30; map[31]=35;
		for(int i=0; i<=19; i++) {
			next[i]=i+1;
		}
		// 5에서 출발할땐 21, 10에서 출발할땐 25, 15에서 출발할땐 27
		next[20]=32; next[21]=22; next[22]=23; next[23]=24; next[24]=30; next[25]=26; next[26]=24;
		next[27]=28; next[28]=29; next[29]=24; next[30]=31; next[31]=20;
		
		//시작은 0, 도착은 32. 31번에서 5가 나오면 36까지 갈수있움 
		//도착해야 점수가 생기는게 아니다.
		//말 업고가기 없다
		//배열마다 점수 입력해놓고 실제로 말판에 번호 메기고 해야될듯.
		//중복조합인데 ... 음... 말 4개중에서 10번을 뽑는 중복순열인데 나간건 처리할필요없지만 도착지점 값0으로해놓으면 어차피 처리는 된다.
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<10;i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		comb(0);
		System.out.println(score);
		
	}
	
	public static void comb(int c) {
		if(c==10) {
			if(output[0]==1&&
					output[1]==1&&
					output[2]==1&&
					output[3]==2&&
					output[4]==3&&
					output[5]==3&&
					output[6]==3&&
					output[7]==3&&
					output[8]==3&&
					output[9]==1) {
				int t=0;
			}
			int sum=0;
			for(int i=0; i<10; i++) {
				int k= move(output[i],number[i], 0,0);
				if(k<0) { //0보다 작은 값이 나왔다는건 말이 업게되는 경우라는것 볼 필요없음.
					for(int j=0; j<4; j++) {
						horse[j]=0; //초기화하고
					}
					return;
				}
				sum+=k;
			}
			for(int j=0; j<4; j++) {
				horse[j]=0; //초기화하고
			}
			score = Math.max(score, sum);
			return;
		}
		else {
			for(int i=0; i<4; i++) {
				output[c]=i; //i번째 홀스 처리.
				comb(c+1);
			}
		}
	}
	public static int move(int h, int c, int d, int score) {
		if(c==0) { 
			for(int i=0; i<4; i++) { //이동을 마치는 칸에 말이 있으면...
				if(i!=h) {
					if(horse[i]==horse[h] && horse[i]!=32 && horse[i]!=0) { // 업히는 경우
						return -1;
					}
				}
			}
			return score;
		}
		if(c!=0 && horse[h]==32) {
			return score;
		}
		
		if(d==0 && (horse[h]==5 || horse[h]==10 || horse[h]==15)) {
			switch(horse[h]) {
				case 5:
					horse[h]=21;
					return move(h,c-1,d+1,map[21]);
				case 10:
					horse[h]=25;
					return move(h,c-1,d+1,map[25]);
				case 15:
					horse[h]=27;
					return move(h,c-1,d+1,map[27]);
			}
		}
		else {
			horse[h]= next[horse[h]];
			return move(h,c-1,d+1,map[horse[h]]);
		}
		return score;
	}
	

}
