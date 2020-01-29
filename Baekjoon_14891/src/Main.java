import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int[][] a;
	static int k;
	static boolean[] flag; 

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = new int[4][8];
		flag = new boolean[3];
		for(int i=0; i<4; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<tmp.length; j++) {
				a[i][j] = tmp[j]-'0';
			}
		}
		k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken())-1; //0123로 바꾸자.
			int ro = Integer.parseInt(st.nextToken()); //1시계 -1반시계
			Arrays.fill(flag, false);
			check();
			if(number==0) {
				rotate(0,ro);
				for(int j=0; j<3; j++) {
					if(flag[j]) {
						ro*=-1;
						rotate(j+1,ro);
					}
					else {
						break;
					}
				}
			}
			else if(number==1) {
				rotate(number,ro);
				if(flag[0]) {
					rotate(0, ro*-1);
				}
				if(flag[1]) {
					rotate(2,ro*-1);
					if(flag[2]) {
						rotate(3,ro);
					}
				}
			}
			else if(number==2) {
				rotate(number,ro);
				if(flag[2]) {
					rotate(3,ro*-1);
				}
				if(flag[1]) {
					rotate(1,ro*-1);
					if(flag[0]) {
						rotate(0,ro);
					}
				}
			}
			else if(number==3) {
				rotate(number,ro);
				if(flag[2]) {
					rotate(2,ro*-1);
					if(flag[1]) {
						rotate(1,ro);
						if(flag[0]) {
							rotate(0,ro*-1);
						}
					}
				}
			}
		}
		int answer=0;
		for(int i=0; i<4; i++) {
			if(a[i][0]==1) {
				answer+=(1<<i);
			}
		}
		System.out.println(answer);
	}
	
	public static void rotate(int number, int ro) {
		if(ro==1) { //시계
			int tmp = a[number][7];
			a[number][7] = a[number][6];
			a[number][6] = a[number][5];
			a[number][5] = a[number][4];
			a[number][4] = a[number][3];
			a[number][3] = a[number][2];
			a[number][2] = a[number][1];
			a[number][1] = a[number][0];
			a[number][0] = tmp;
		}
		else {
			int tmp = a[number][0];
			a[number][0] = a[number][1];
			a[number][1] = a[number][2];
			a[number][2] = a[number][3];
			a[number][3] = a[number][4];
			a[number][4] = a[number][5];
			a[number][5] = a[number][6];
			a[number][6] = a[number][7];
			a[number][7] = tmp;
		}
	}
	
	public static void check() {
		if(a[0][2]!=a[1][6]) {
			flag[0] = true;
		}
		if(a[1][2]!=a[2][6]) {
			flag[1]=true;
		}
		if(a[2][2]!=a[3][6]) {
			flag[2]=true;
		}
	}
}