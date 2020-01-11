import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger a= new BigInteger(st.nextToken());
		for(int i=0; i<n-1; i++) {
			a=a.multiply(new BigInteger(st.nextToken()));
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		BigInteger b= new BigInteger(st.nextToken());
		for(int i=0; i<m-1; i++) {
			b=b.multiply(new BigInteger(st.nextToken()));
		}
		String t = a.gcd(b).toString();
		
		if(t.length()<9) {
			System.out.println(t);
		}
		else {
			for(int i=t.length()-9; i<t.length(); i++) {
				System.out.print(t.charAt(i));
			}
		}
		

	}

}
