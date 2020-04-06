import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt=0;
		int[] dp = new int[n+1];
		//dp[n^2]은 1 dp[n^2+1]은  dp[n^2]+1;
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		//더해지는 수가 제곱수면 dp[n^2+k] 에서 k가 제곱수이면 dp[n^2]+1;
		for(int i=1; i<=(int)Math.sqrt(n); i++) {
			dp[i*i]=1;
		}
		for(int i=2; i<=n; i++) {
			if(dp[i]==1) {
				continue;
			}
			for(int j=1; j*j<=i; j++) {
				dp[i] = Math.min(dp[i], dp[i-(j*j)]+1);
			}
			
		}
		System.out.println(dp[n]);
	}

}
