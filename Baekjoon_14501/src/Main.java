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
		//i�� ��¥... �ش� ��¥������ ��� ���� ��.
		for(int i=1; i<n+1; i++) {
			String[] tmp  =br.readLine().split(" ");
			t[i] = Integer.parseInt(tmp[0]);
			p[i] =  Integer.parseInt(tmp[1]);
		}
		// �� ���� ��¥�� �̿밡���ϰ�
		// �� ���� ��¥�� �ִ��� + ������ ���� > ������... ����.
		for(int i=1; i<=n+1; i++) {
			dp[i] = Math.max(dp[i], max);
			//������ ����� �ִ���� vs �̹����� ���� ����.
			dp[t[i]+i] = Math.max(dp[t[i]+i], dp[i]+p[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);

	}

}


