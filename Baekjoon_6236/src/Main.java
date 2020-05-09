import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int start=1;
		int end = Integer.MAX_VALUE-1;
		int ans=0;
		while(start<=end) {
			int mid = (start+end)/2;
			//k�� mid�� ���������� ���ߵǴ� �ּ�Ƚ��?
			int cnt=check(mid);
			if(cnt==-1) {
				start=mid+1;
			}
			else if(cnt>m) { //���� �ʹ� ���̻�. �ѹ��� ���� �ݾ� �ø���.
				start = mid+1;
			}
			else { //���� ���Ի��ų� k��ŭ ����. 
				ans=mid;
				end=mid-1;
			}
		}
		System.out.println(ans);
		
	}
	
	public static int check(int k) {
		int cnt=1;
		int sum=0;
		for(int i=0; i<n; i++) {
			if(arr[i]>k) {
				return -1;
			}
			sum+=arr[i];
			if(sum>k) {
				cnt++;
				sum=arr[i];
			}
		}
		return cnt;
	}

}
