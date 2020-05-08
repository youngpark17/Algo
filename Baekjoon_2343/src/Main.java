import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		//m���� ������������ �ִ밪.
		//�ִ��� �ּڰ�
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//ū�� �ڿ������� 
		long ans=Integer.MAX_VALUE;
		long end = Long.MAX_VALUE/2;
		long start = 1;
		while(start<=end) {
			long mid = (start+end)/2;
			//mid�� �����ϸ� mid������
			int cnt = check(mid);
			if(cnt<=m) {
				ans =Math.min(ans, mid);
				end=mid-1;
			}
			else {
				start=mid+1;
			}
			
		}
		System.out.println(ans);
	}
	
	public static int check(long mid) {
		//mid�� ������ ��������� ĭ�� ��.
		int cnt=1;
		long sum=0;
		for(int i=0;i<n; i++){
			if(arr[i]>mid) {
				return Integer.MAX_VALUE;
			}
			if(sum+arr[i]>mid) {
				sum=0;
				cnt++;
			}
			sum+=arr[i];
		}
	
		return cnt;
		
	}
	

}
