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
		
		//모든 요청 금액 그대로 배정
		for(int k : arr) {
			sum+=k;
			
		}
		if(sum<=budget) {
			Arrays.sort(arr);
			System.out.println(arr[arr.length-1]);
			System.exit(0);
		}
		//상한액 계산했을때 예산을 쓰는 정도로 기준잡자. 예산보다 적게썻으면 상한액증가 많이 썼으면 감소
		//budget내에서 기준을 만족시키는 최대값... 
		Arrays.sort(arr);
		int l=1;
		int r=arr[arr.length-1];
		int m=0;
		while(l<=r) {
			m = (l+r)/2;
			if(check(m, budget)) { //남은 금액이 더 작아도 된다면 상한액을 더 높여도된다면
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
			if(k>mid) { //상한액보다 크다면 상한액 만큼만 배정.
				b-=mid;
			}
			else { //상한액보다 작다면 
				b-=k;
			}
		}
		//남은 금액이 최대가 되어야함.
		if(min>b && b>=0) { //지금까지의 최소금액보다 남은 금액이 더 작다면
			min=b;
			return true;
		}
		else {
			return false;
		}
	}

}
