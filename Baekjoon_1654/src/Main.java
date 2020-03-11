import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	static int k;
	static int n;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		k = Integer.parseInt(tmp[0]);
		n = Integer.parseInt(tmp[1]);
		arr = new int[k];
		long r=Long.MAX_VALUE;
		for(int i=0; i<k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
		}
		long l = 0;
		long m=0;
		//랜선 길이를 이분 탐색하자. 랜선 길이를 n개만큼 만드는 길이의 최대값.
		while(l<=r) {
			m = (l+r)/2;
			if(check(m)) {
				r=m-1;
			}
			else {
				l=m+1;
			}
		}
		System.out.println(r);
	}
	public static boolean check(long mid) {
		int sum=0;
		for(int k : arr) {
			sum+=k/mid;
		}
		return sum<n; //더 적게 만들어졌다면
	}

}
