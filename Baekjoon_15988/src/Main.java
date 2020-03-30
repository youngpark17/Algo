import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int max=0;
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int k = sc.nextInt();
			list.add(k);
			max = Math.max(max, k);
		}
		long[] dp=new long[max+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		dp[4]=7;
		for(int i=5; i<dp.length; i++) {
			dp[i] = (dp[i-3]+dp[i-2]+dp[i-1])%1_000_000_009;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int t : list) {
			bw.append(dp[t]+"\n");
		}
		bw.flush();
		bw.close();
		
		
	}

}
