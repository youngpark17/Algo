import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[][] dp = new int[30][30];
		dp[0][0] = dp[1][0] = dp[1][1] =1;

		for(int i=2; i<30; i++) {
			for(int j=0; j<30; j++) {
				if(i==j||j==0) {
					dp[i][j]=1;
				}
				else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
		}
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m =Integer.parseInt(st.nextToken());
			System.out.println(dp[m][n]);
		}
	}

}
