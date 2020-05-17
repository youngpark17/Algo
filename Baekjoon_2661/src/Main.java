import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		//1부터 시작하며 탐색... 2개로 나눴을경우 3개로 나눴을경우 ....n/2로 나누었을 경우까지...
		arr = new int[n];
		dfs(0);
	}
	
	public static void dfs(int c) throws Exception {
		if(c==n) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for(int k :arr) {
				bw.append(k+"");
			}
			bw.flush();
			bw.close();
			System.exit(0);
		}
		else {
			for(int i=1; i<=3; i++) {
				arr[c] = i;
				if(!check(c+1)) {
					dfs(c+1);
				}
			}
		}
	}
	
	public static boolean check(int c) {
		int d=1;
		int s2=c-d;
		int e2=c-1;
		int s1=c-2*d;
		int e1=c-d-1;
		//4개일경우 비교는? 4/3 , 4,3/2,1 
		while(s1>=0) {
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			for(int i=s1; i<=e1; i++) {
				sb1.append(arr[i]);
			}
			for(int i=s2; i<=e2; i++) {
				sb2.append(arr[i]);
			}
			if(sb1.toString().equals(sb2.toString())) {
				return true;
			}
			d++;
			s2=c-d;
			e2=c-1;
			s1=c-2*d;
			e1=c-d-1;
		}
		return false;
	}

}
