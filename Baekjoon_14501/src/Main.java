import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] t;
	static int[] p;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		t = new int[n+6];
		p = new int[n+6];
		dp = new int[n+6];
		int max=0;
		//i는 날짜... 해당 날짜까지의 상담 가능 일.
		for(int i=1; i<n+1; i++) {
			String[] tmp  =br.readLine().split(" ");
			t[i] = Integer.parseInt(tmp[0]);
			p[i] =  Integer.parseInt(tmp[1]);
		}
		// 이 전의 날짜에 이용가능하고
		// 이 전의 날짜의 최대합 + 지금의 합이 > 현재합... 갱신.
		for(int i=1; i<=n+1; i++) {
			dp[i] = Math.max(dp[i], max);
			//이전에 저장된 최대수익 vs 이번으로 생긴 수익.
			dp[t[i]+i] = Math.max(dp[t[i]+i], dp[i]+p[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);

	}

}


