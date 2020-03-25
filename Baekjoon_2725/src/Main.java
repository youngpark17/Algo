import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int t;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int cnt=0;
		for(int j=1; j<=1000; j++) {
			for(int k=1; k<=j; k++) {
					if(gcd(j,k)==1) {
						cnt++;
					}
				}
			arr[j] = cnt*2+1;
			}
		
		for(int i=0; i<t; i++) {
			int n= Integer.parseInt(br.readLine());
			bw.append((arr[n])+"\n");
			}
		bw.flush();
		bw.close();
			
			
		}
	
	public static int gcd(int a, int b) {
		while(a%b!=0) {
			int tmp=b;
			b=a%b;
			a=tmp;
		}
		return b;
		
	}

}
