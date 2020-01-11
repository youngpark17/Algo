import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[1001][1001];
		
		dp[0][0]=dp[1][0]=dp[1][1]=1;
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=n; j++) {
				if(i==j || j==0 ) {
					dp[i][j]=1;
				}
				else {
					dp[i][j] = (dp[i-1][j] + dp[i-1][j-1] )%10007;
					
				}
			}
		}
		
		System.out.println(dp[n][k]);
		
		
		
		
	}


}
