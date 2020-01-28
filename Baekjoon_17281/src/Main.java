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
		//순열을 구해서..., 그 뒤로 시뮬레이션 하자. 1번 선수는 무조건 4번타자.
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
			arr[i] = i+1; //1번타자부터 8번타자까지 순열. 0번타자가 1번타순.
		}
		per(0);
		System.out.println(finalnumber);
		
	}
	
	public static void simul(int a) {
		switch(a) {
		case 1: //안타. 
			if(one==1 && two==1 && three==1) { //만루이면.
				number+=1;
				three=1;
				two=1;
				one=1;
			}
			else if(one==0&&two==1 && three==1) { //2,3루 차있는데
				number+=1;
				three=1;
				two=0;
				one=1;
			}
			else if(one==1 && two==0 && three==1) { //1,3루 차잇는데
				number+=1;
				three=0;
				two=1;
				one=1;
			}
			else if(one==1 && two==1 && three==0) { //1,2루 차있는데
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
			else { // 전부 영
				one=1;
			}
			break;
		case 2: //2루타.
			if(one==1 && two==1 && three==1) { //만루이면.
				number+=2;
				three=1;
				two=1;
				one=0;
			}
			else if(one==0&&two==1 && three==1) { //2,3루 차있는데 2루타.
				number+=2;
				three=0;
				two=1;
				one=0;
			}
			else if(one==1 && two==0 && three==1) { //1,3루 차잇는데 2루타
				number+=1;
				three=1;
				two=1;
				one=0;
			}
			else if(one==1 && two==1 && three==0) { //1,2루 차있는데 2루타.
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
			else { // 전부 영
				two=1;
			}

			break;
		case 3:
			if(one==1 && two==1 && three==1) { //만루이면.
				number+=3;
				three=1;
				two=0;
				one=0;
			}
			else if(one==0 &&two==1 && three==1) { //2,3루 차있는데 3루타.
				number+=2;
				three=1;
				two=0;
				one=0;
			}
			else if(one==1 && two==0 && three==1) { //1,3루 차잇는데 3루타
				number+=2;
				three=1;
				two=0;
				one=0;
			}
			else if(one==1 && two==1 && three==0) { //1,2루 차있는데 3루타.
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
			else { // 전부 영
				three=1;
			}
			break;
			
		case 4: //홈런
			int sum = one+two+three+1;
			number+=sum;
			one=0;
			two=0;
			three=0;
			break;
			
		case 0: //아웃;
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
		if(d==8) { //1번타자 뺴고 나머지  순열 하는거니까...
			List<Integer> list = new ArrayList<>();
			for(int i=0; i<8; i++) {
				if(i==3) {
					list.add(0); //1번 타자는 4번타자로.... 3명이 앞에 들어갔을때 투입하자.
				}
				list.add(arr[i]); //0~8까지 차있음.
			}
			tmpN=n;
			number=0;
			tasun=0;
			//순열은 맞게 구했음.
			while(tmpN!=0){
				while(true) { //중간에 한 이닝이 끝나면 타선이 저장되고 다시시작해야됨.
					simul(map[n-tmpN][list.get(tasun)]); //tasun index는 0~8까지 
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
