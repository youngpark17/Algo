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
		//최대값의 x일때 구간이 m개로 가능한가?
		//구간이 더 적게 나누어진다면 x/2
		//구간이 더 많이 나누어진다면 x*2
		// 4 4 6 이 구간에서의 최대값은 6
		//4 5 4 이 구간에서의 최대값은 5... 분할시 최대값의 최소값은 5
		r*=2;
		int l=0;
		int mid=0;
		while(l<=r) {
			mid = (l+r)/2;
			if(check(mid)) { //목표값과 같거나 적게 나누어짐. 
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
		int seg = 1;//마지막엔 무조건 구간 하나 있다고 봄.
		//차이가 mid보다 커야 구간으로 인정. mid는 구간을 인정하는 최솟값
		for(int i=1; i<n; i++) {
			max = Math.max(max,arr[i]);
			min = Math.min(min,arr[i]);
			if(max-min>mid) { 
				seg+=1;
				max=arr[i];
				min=arr[i];
			}
		}
		
		return seg<=m; // 목표한값보다 구간이 적거나 같게 나누어짐.
	}

}
