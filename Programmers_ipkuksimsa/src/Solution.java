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
		// 시간별로 정렬하자.
		//20억부터 이분탐색하고. 가능하면 줄이자.
		//구현부분 시간/times[i]가 그 시간내에 한사람이 할수 있는 양
		//그 합이 n보다 크면 ... 가능
		//최솟값이니까 탐색했을때 작은거.
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
