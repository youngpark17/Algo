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
			if(a==1) { // b번쨰 수를 c로 바꿈
				int diff = c-value[--b]; //b값은 인덱스가 아니고 순서니까 인덱스로 바꾸고 c와의 차이를 구함.
				value[b]=c;
				update(1,0,n-1,b,diff);
			}
			else if(a==2) { //b번쨰 수부터 c번째 수까지의 합... 인덱스로 b-1부터 c-1까지의 합
				list.add(sum(1,0,n-1,b-1,c-1));
			}
		}
		for(Long k2 :list) {
			System.out.println(k2);
		}
		
	}
	public static long init(int idx, int left, int right) {
		if(left==right) { // 즉 리프노드의 구간이 하나면
			return segment[idx] = value[left]; 
		}
		int mid = (left+right)/2;
		return segment[idx]= init(idx*2,left,mid)+init(idx*2+1,mid+1,right);
	}
	
	public static long sum(int idx, int start, int end, int left, int right) { //left,right는 고정
		if(left>end ||right<start) { // 현재 구하고 있는 sum이 부분합을 구하는 인덱스를 벗어남.
			return 0;
		}
		if(left<=start && right >=end) { //start와 end가 부분합을 구하고 있는 범위에 포함
			return segment[idx];
		}
		int mid = (start+end)/2;
		return sum(idx*2, start, mid,left,right )+sum(idx*2+1,mid+1,end,left,right);
	}
	
	public static void update(int idx, int start, int end, int change, long diff) {
		if(change<start || change>end) { // 바뀌는 인덱스가 트리 범위밖이면 종료
			return;
		}
		segment[idx]+=diff; // 1번 인덱스... 즉 루트노드에서부터 diff만큼 더하면서 부분합 원래대로 만듬
		if(start!=end) { //부분 하나가 아닐때까지
			update(idx*2, start,(start+end)/2, change, diff);
			update(idx*2+1, (start+end)/2+1, end, change, diff);
		}
	}

}
