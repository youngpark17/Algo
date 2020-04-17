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
		//1, 1, 1, 2, 3, 3, 3, 3, 3, 1 3�� �׽�Ʈ���̽�
		
		map = new int[33];
		next = new int[33];
		// �ݽð�� ����ġ�� ...
		for(int i=1; i<=20; i++) {
			map[i]=i*2;
		}
		map[21]=13; map[22]=16; map[23]=19; map[24]= 25; map[25] = 22; map[26]=24;
		map[27]=28; map[28]=27; map[29]=26; map[30]=30; map[31]=35;
		for(int i=0; i<=19; i++) {
			next[i]=i+1;
		}
		// 5���� ����Ҷ� 21, 10���� ����Ҷ� 25, 15���� ����Ҷ� 27
		next[20]=32; next[21]=22; next[22]=23; next[23]=24; next[24]=30; next[25]=26; next[26]=24;
		next[27]=28; next[28]=29; next[29]=24; next[30]=31; next[31]=20;
		
		//������ 0, ������ 32. 31������ 5�� ������ 36���� �����ֿ� 
		//�����ؾ� ������ ����°� �ƴϴ�.
		//�� ������ ����
		//�迭���� ���� �Է��س��� ������ ���ǿ� ��ȣ �ޱ�� �ؾߵɵ�.
		//�ߺ������ε� ... ��... �� 4���߿��� 10���� �̴� �ߺ������ε� ������ ó�����ʿ������ �������� ��0�����س����� ������ ó���� �ȴ�.
		
		
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
				if(k<0) { //0���� ���� ���� ���Դٴ°� ���� ���ԵǴ� ����°� �� �ʿ����.
					for(int j=0; j<4; j++) {
						horse[j]=0; //�ʱ�ȭ�ϰ�
					}
					return;
				}
				sum+=k;
			}
			for(int j=0; j<4; j++) {
				horse[j]=0; //�ʱ�ȭ�ϰ�
			}
			score = Math.max(score, sum);
			return;
		}
		else {
			for(int i=0; i<4; i++) {
				output[c]=i; //i��° Ȧ�� ó��.
				comb(c+1);
			}
		}
	}
	public static int move(int h, int c, int d, int score) {
		if(c==0) { 
			for(int i=0; i<4; i++) { //�̵��� ��ġ�� ĭ�� ���� ������...
				if(i!=h) {
					if(horse[i]==horse[h] && horse[i]!=32 && horse[i]!=0) { // ������ ���
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
