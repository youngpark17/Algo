import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] dp;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		arr = new int[n+1];
		for(int i=1; i<n+1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//4개까지 살펴봤을때의 최대값?
		//0 1 2 3 4 5 6 7 8 9
		dp[1]=arr[1];
		if(n>=2) {
			dp[2] = arr[1]+arr[2];
		}
				
		if(n>=3) {
			for(int i=3; i<n+1; i++) {
				dp[i] = Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]);
				dp[i] = Math.max(dp[i-1], dp[i]);
			}
		}
		System.out.println(dp[n]);
		
		
	}

}
