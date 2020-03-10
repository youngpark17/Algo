import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		st = new StringTokenizer(br.readLine());
		int r=0;
		arr = new int[n];
		for(int i=0; i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			r= Math.max(r, arr[i]);
		}
		//�ִ밪�� x�϶� ������ m���� �����Ѱ�?
		//������ �� ���� ���������ٸ� x/2
		//������ �� ���� ���������ٸ� x*2
		// 4 4 6 �� ���������� �ִ밪�� 6
		//4 5 4 �� ���������� �ִ밪�� 5... ���ҽ� �ִ밪�� �ּҰ��� 5
		r*=2;
		int l=0;
		int mid=0;
		while(l<=r) {
			mid = (l+r)/2;
			if(check(mid)) { //��ǥ���� ���ų� ���� ��������. 
				r=mid-1;
			}
			else {
				l=mid+1;
			}
			
			
		}
		System.out.println(l);
		
		
	}
	
	public static boolean check(int mid) {
		int min = arr[0];
		int max = arr[0];
		int seg = 1;//�������� ������ ���� �ϳ� �ִٰ� ��.
		//���̰� mid���� Ŀ�� �������� ����. mid�� ������ �����ϴ� �ּڰ�
		for(int i=1; i<n; i++) {
			max = Math.max(max,arr[i]);
			min = Math.min(min,arr[i]);
			if(max-min>mid) { 
				seg+=1;
				max=arr[i];
				min=arr[i];
			}
		}
		
		return seg<=m; // ��ǥ�Ѱ����� ������ ���ų� ���� ��������.
	}

}
