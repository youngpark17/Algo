import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static int n;
	static int[] arr;
	static int budget;
	static int min = Integer.MAX_VALUE;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		String[] tmp = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		budget = Integer.parseInt(br.readLine());
		long sum=0;
		
		//��� ��û �ݾ� �״�� ����
		for(int k : arr) {
			sum+=k;
			
		}
		if(sum<=budget) {
			Arrays.sort(arr);
			System.out.println(arr[arr.length-1]);
			System.exit(0);
		}
		//���Ѿ� ��������� ������ ���� ������ ��������. ���꺸�� ���ԛ����� ���Ѿ����� ���� ������ ����
		//budget������ ������ ������Ű�� �ִ밪... 
		Arrays.sort(arr);
		int l=1;
		int r=arr[arr.length-1];
		int m=0;
		while(l<=r) {
			m = (l+r)/2;
			if(check(m, budget)) { //���� �ݾ��� �� �۾Ƶ� �ȴٸ� ���Ѿ��� �� �������ȴٸ�
				l=m+1;
			}
			else {
				r=m-1;
			}
		}
		System.out.println(r);
		
		
		
	}
	
	public static boolean check(int mid, int b) {
		for(int k : arr) {
			if(k>mid) { //���Ѿ׺��� ũ�ٸ� ���Ѿ� ��ŭ�� ����.
				b-=mid;
			}
			else { //���Ѿ׺��� �۴ٸ� 
				b-=k;
			}
		}
		//���� �ݾ��� �ִ밡 �Ǿ����.
		if(min>b && b>=0) { //���ݱ����� �ּұݾ׺��� ���� �ݾ��� �� �۴ٸ�
			min=b;
			return true;
		}
		else {
			return false;
		}
	}

}
