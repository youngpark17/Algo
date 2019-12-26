import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		long m = Integer.parseInt(tmp[1]);
		tmp = br.readLine().split(" ");
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(tmp[i]);
		}

		Arrays.sort(arr);
		int pivot= (2000000000)/2;
		solve(arr, 0, pivot, 2000000000, m);
		
		
	}
	
	public static void solve(int[] arr,int h, int pivot, int h2, long m) {
		
		while(h2>=h) {
			long sum=0;
			pivot = (h+h2)/2;
			for(int k : arr) {
				if(k>pivot) {
					sum+=(k-pivot);
				}
			}
			
			
			if(sum>=m) { // 나무가 과도하게 채집됨. 높이 높이자
				h=pivot+1;
			}
			else if(sum<m){//나무가 부족 , 높이 낮추자
				h2=pivot-1;
			}
			
		}
		
		System.out.println(h2);
		
		
//		
//		for(int k : arr){
//			if(k>pivot) {
//				sum+=(k-pivot);
//			}
//		}
//		if(sum>m) { // 나무가 과도하게 채집됨. 높이 높이자
//			h=pivot+1;
//			pivot=(h+h2)/2;
//			solve(arr, h, pivot,h2);
//		}
//		else if(sum<m){//나무가 부족 , 높이 낮추자
//			h2=pivot-1;
//			pivot=(h+h2)/2;
//			solve(arr,h,pivot,h2);
//		}
//		else {
//			System.out.println(h);
//		}
	}

}
