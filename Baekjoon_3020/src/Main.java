import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,h;
	static int[] down;
	static int[] up;
	static int ans;
	static int cnt;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		down = new int[h+1];
		up = new int[h+1];
		long[] sumUp = new long[h+1];
		long[] sumDown = new long[h+1];
		ans=Integer.MAX_VALUE;
		cnt=0;
		for(int i=0; i<n/2; i++) {
			up[Integer.parseInt(br.readLine())]++;
			down[Integer.parseInt(br.readLine())]++;

		}
		for(int i=1; i<h+1; i++) {
			sumUp[i] = sumUp[i-1] + up[i];
			sumDown[i] = sumDown[i-1]+down[i];
		}

		for(int i=1; i<=h; i++) {
			//i´Â ³ôÀÌ
			int tmp=0;
			tmp +=sumDown[h] - sumDown[i-1]; 
			tmp += sumUp[h] - sumUp[h-i];
			if(ans>tmp) {
				ans = tmp;
				cnt=1;
			}
			else if(ans==tmp){
				cnt++;
			}

		}
		System.out.println(ans+" "+cnt);


	}


}
