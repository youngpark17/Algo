import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		long answer=n; //방이 n개면 그만큼 총 감독관 필요.
		
		st = new StringTokenizer(br.readLine());
		int master = Integer.parseInt(st.nextToken());
		
		int slave = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			arr[i]-=master;
			if(arr[i]%slave!=0 &&arr[i]>0) {
				answer += ((arr[i]/slave)+1);
			}
			else {
				if(arr[i]>0) {
					answer+=(arr[i]/slave);
				}
			}
		}
		
		
		System.out.println(answer);
		
		
	}

}
