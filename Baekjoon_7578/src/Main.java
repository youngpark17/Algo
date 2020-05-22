import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int[] arr2;
	static long[] tree;
	static long cnt;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[1000001];
		for(int i=1; i<n+1; i++) {
			arr[Integer.parseInt(st.nextToken())]=i;
		}
		tree = new long[n+1];
		arr2 = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			arr2[i] = arr[Integer.parseInt(st.nextToken())];
		}
		//완탐으로 생각해보자.
		//j<i일때 arr[j]가 arr[i]보다 크다면 얽힌것이다. 2문포문으로 가능하다 O(n^2)
//		for(int i=1; i<n+1; i++) {
//			for(int j=i-1; j>0; j--) {
//				if(arr2[j]>arr2[i]) {
//					cnt++;
//				}
//			}
//		}
		for(int i=n; i>0; i--) {
			cnt += get(1)-get(arr2[i]);
			update(arr2[i],1);
			
		}
		System.out.println(cnt);
		
	}
	
	public static long get(int x) {
		long ret=0;
		while(x<n+1) {
			ret+=tree[x];
			x+=(x&-x);
		}
		return ret;
	}
	public static void update(int x, int value) {
		while(x>0) {
			tree[x]+=value;
			x-=(x&-x);
		}
	}
	
	

}
