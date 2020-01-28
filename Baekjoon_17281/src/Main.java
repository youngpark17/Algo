import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static int[] arr;
	static int one,two,three;
	static int outCnt;
	static int number;
	static int finalnumber = Integer.MIN_VALUE;
	static int tmpN;
	static int tasun=0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//������ ���ؼ�..., �� �ڷ� �ùķ��̼� ����. 1�� ������ ������ 4��Ÿ��.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][9];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		arr = new int[8];
		for(int i=0; i<8; i++) {
			arr[i] = i+1; //1��Ÿ�ں��� 8��Ÿ�ڱ��� ����. 0��Ÿ�ڰ� 1��Ÿ��.
		}
		per(0);
		System.out.println(finalnumber);
		
	}
	
	public static void simul(int a) {
		switch(a) {
		case 1: //��Ÿ. 
			if(one==1 && two==1 && three==1) { //�����̸�.
				number+=1;
				three=1;
				two=1;
				one=1;
			}
			else if(one==0&&two==1 && three==1) { //2,3�� ���ִµ�
				number+=1;
				three=1;
				two=0;
				one=1;
			}
			else if(one==1 && two==0 && three==1) { //1,3�� ���մµ�
				number+=1;
				three=0;
				two=1;
				one=1;
			}
			else if(one==1 && two==1 && three==0) { //1,2�� ���ִµ�
				three=1;
				two=1;
				one=1;
			}
			else if(one==1 && two==0 && three==0) {
				one=1;
				two=1;
				three=0;
			}
			else if(one==0 && two==1 && three==0) {
				one=1;
				two=0;
				three=1;
			}
			else if(one==0 && two==0 && three==1) {
				number+=1;
				one=1;
				two=0;
				three=0;
			}
			else { // ���� ��
				one=1;
			}
			break;
		case 2: //2��Ÿ.
			if(one==1 && two==1 && three==1) { //�����̸�.
				number+=2;
				three=1;
				two=1;
				one=0;
			}
			else if(one==0&&two==1 && three==1) { //2,3�� ���ִµ� 2��Ÿ.
				number+=2;
				three=0;
				two=1;
				one=0;
			}
			else if(one==1 && two==0 && three==1) { //1,3�� ���մµ� 2��Ÿ
				number+=1;
				three=1;
				two=1;
				one=0;
			}
			else if(one==1 && two==1 && three==0) { //1,2�� ���ִµ� 2��Ÿ.
				number+=1;
				three=1;
				two=1;
				one=0;
			}
			else if(one==1 && two==0 && three==0) {
				one=0;
				two=1;
				three=1;
			}
			else if(one==0 && two==1 && three==0) {
				number+=1;
				one=0;
				two=1;
				three=0;
			}
			else if(one==0 && two==0 && three==1) {
				number+=1;
				one=0;
				two=1;
				three=0;
			}
			else { // ���� ��
				two=1;
			}

			break;
		case 3:
			if(one==1 && two==1 && three==1) { //�����̸�.
				number+=3;
				three=1;
				two=0;
				one=0;
			}
			else if(one==0 &&two==1 && three==1) { //2,3�� ���ִµ� 3��Ÿ.
				number+=2;
				three=1;
				two=0;
				one=0;
			}
			else if(one==1 && two==0 && three==1) { //1,3�� ���մµ� 3��Ÿ
				number+=2;
				three=1;
				two=0;
				one=0;
			}
			else if(one==1 && two==1 && three==0) { //1,2�� ���ִµ� 3��Ÿ.
				number+=2;
				three=1;
				two=0;
				one=0;
			}
			else if(one==1 && two==0 && three==0) {
				number+=1;
				one=0;
				two=0;
				three=1;
			}
			else if(one==0 && two==1 && three==0) {
				number+=1;
				one=0;
				two=0;
				three=1;
			}
			else if(one==0 && two==0 && three==1) {
				number+=1;
				one=0;
				two=0;
				three=1;
			}
			else { // ���� ��
				three=1;
			}
			break;
			
		case 4: //Ȩ��
			int sum = one+two+three+1;
			number+=sum;
			one=0;
			two=0;
			three=0;
			break;
			
		case 0: //�ƿ�;
			outCnt+=1;
			if(outCnt==3) {
				tmpN-=1;
				outCnt=0;
				one=0;
				two=0;
				three=0;
			}
			
			break;
		}
	}
	
	public static void per(int d) {
		if(d==8) { //1��Ÿ�� ���� ������  ���� �ϴ°Ŵϱ�...
			List<Integer> list = new ArrayList<>();
			for(int i=0; i<8; i++) {
				if(i==3) {
					list.add(0); //1�� Ÿ�ڴ� 4��Ÿ�ڷ�.... 3���� �տ� ������ ��������.
				}
				list.add(arr[i]); //0~8���� ������.
			}
			tmpN=n;
			number=0;
			tasun=0;
			//������ �°� ������.
			while(tmpN!=0){
				while(true) { //�߰��� �� �̴��� ������ Ÿ���� ����ǰ� �ٽý����ؾߵ�.
					simul(map[n-tmpN][list.get(tasun)]); //tasun index�� 0~8���� 
					tasun+=1;
					if(tasun==9) {
						tasun=0;
					}
					if(tmpN==0) {
						break;
					}
				}
			}
		finalnumber = Math.max(finalnumber, number);
		
		}
		else {
			for(int i=d; i<8; i++) {
				swap(d,i);
				per(d+1);
				swap(i,d);
			}
		}
	}
	
	public static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}

}
