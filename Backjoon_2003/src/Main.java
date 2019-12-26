import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int count=0;
	static int m;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		
		tmp = br.readLine().split(" ");
		int[] arr = new int[n];
		
		for(int i=0; i<tmp.length; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		
		for(int i=0; i<tmp.length; i++) {
			sum(arr,i);
		}
		
		System.out.println(count);
		
		

	}
	
	public static void sum(int[] arr, int start) {
		int tmp = 0;
		for(int i=start; i<arr.length; i++) {
			tmp+=arr[i];
			if(tmp==m) {
				count++;
				return;
			}
		}
		
	}

}
