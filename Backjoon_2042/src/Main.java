import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static long[] segment;
	public static int[] value;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		int k = Integer.parseInt(tmp[2]);
		value = new int[n];
		List<Long> list = new ArrayList<>();
		int h = (int)Math.pow(2.0, Math.floor((Math.log(n)/Math.log(2.0))+1));
		segment = new long[2*h];
		//Arrays.fill(segment, 0);
		for(int i=0; i<n; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		init(1,0,n-1);
		for(int i=0; i<m+k; i++) {
			tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			int c = Integer.parseInt(tmp[2]);
			if(a==1) { // b���� ���� c�� �ٲ�
				int diff = c-value[--b]; //b���� �ε����� �ƴϰ� �����ϱ� �ε����� �ٲٰ� c���� ���̸� ����.
				value[b]=c;
				update(1,0,n-1,b,diff);
			}
			else if(a==2) { //b���� ������ c��° �������� ��... �ε����� b-1���� c-1������ ��
				list.add(sum(1,0,n-1,b-1,c-1));
			}
		}
		for(Long k2 :list) {
			System.out.println(k2);
		}
		
	}
	public static long init(int idx, int left, int right) {
		if(left==right) { // �� ��������� ������ �ϳ���
			return segment[idx] = value[left]; 
		}
		int mid = (left+right)/2;
		return segment[idx]= init(idx*2,left,mid)+init(idx*2+1,mid+1,right);
	}
	
	public static long sum(int idx, int start, int end, int left, int right) { //left,right�� ����
		if(left>end ||right<start) { // ���� ���ϰ� �ִ� sum�� �κ����� ���ϴ� �ε����� ���.
			return 0;
		}
		if(left<=start && right >=end) { //start�� end�� �κ����� ���ϰ� �ִ� ������ ����
			return segment[idx];
		}
		int mid = (start+end)/2;
		return sum(idx*2, start, mid,left,right )+sum(idx*2+1,mid+1,end,left,right);
	}
	
	public static void update(int idx, int start, int end, int change, long diff) {
		if(change<start || change>end) { // �ٲ�� �ε����� Ʈ�� �������̸� ����
			return;
		}
		segment[idx]+=diff; // 1�� �ε���... �� ��Ʈ��忡������ diff��ŭ ���ϸ鼭 �κ��� ������� ����
		if(start!=end) { //�κ� �ϳ��� �ƴҶ�����
			update(idx*2, start,(start+end)/2, change, diff);
			update(idx*2+1, (start+end)/2+1, end, change, diff);
		}
	}

}
