import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] times;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		times = new int[n];
		for(int i=0; i<n; i++) {
			times[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(solution());
	}
	public static long solution(){
		// �ð����� ��������.
		//20����� �̺�Ž���ϰ�. �����ϸ� ������.
		//�����κ� �ð�/times[i]�� �� �ð����� �ѻ���� �Ҽ� �ִ� ��
		//�� ���� n���� ũ�� ... ����
		//�ּڰ��̴ϱ� Ž�������� ������.
		long ans=0;
		long start = 0;
		long end = Long.MAX_VALUE/2;
		while(start<=end) {
			long mid = (start+end)/2;
			long tmp = 0;
			for(int k : times) {
				tmp+=(long)(mid/k);
				if(tmp>m) {
					break;
				}
			}
			if(tmp>=m) {
				end = mid-1;
				ans=mid;
				
			}
			else {
				start = mid+1;
				
			}
		}
		return ans;
	}

}
