import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so = new Solution();
		int n = 10;
		int[] times= {1,5};
		System.out.println(so.solution(n, times));
		
	}

	public long solution(int n, int[] times) {
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
				if(tmp>n) {
					break;
				}
			}
			if(tmp>=n) {
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
