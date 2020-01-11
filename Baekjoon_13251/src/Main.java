import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[m];
		long n=0;
		for(int i=0; i<m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			n+=arr[i];
		}
		double k =Integer.parseInt(br.readLine());
		double total=0;
		
		for(int i=0; i<arr.length; i++) {
			double p=1;
			for(double j=0; j<k; j++) {
				p=p*((arr[i]-j)/(n-j));
			}
			total+=p;
		}
		
		System.out.println(total);


	}



}
