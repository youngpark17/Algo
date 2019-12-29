import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int num1 = Integer.parseInt(tmp[0]);
		int num2 = Integer.parseInt(tmp[1]);
		
		int bignum;
		int smallnum;
		if(num1>=num2) {
			bignum=num1;
			smallnum=num2;
		}
		else {
			bignum=num2;
			smallnum=num1;
		}
		int maxNum = max(bignum,smallnum);
		System.out.println(maxNum);
		System.out.println((bignum/maxNum)*smallnum);
		
		
	}
	
	public static int max(int bignum, int smallnum) {
		int namuji = bignum%smallnum;
		if(namuji==0) {
			return smallnum;
		}
		
		return max(smallnum, namuji);
		
	}

}
