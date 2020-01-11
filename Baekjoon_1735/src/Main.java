import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int a1 = Integer.parseInt(tmp[0]);
		int b1 = Integer.parseInt(tmp[1]);
		tmp = br.readLine().split(" ");
		int a2 = Integer.parseInt(tmp[0]);
		int b2 = Integer.parseInt(tmp[1]);
		
		int newb = b1*b2;
		int newa = a1*b2+a2*b1;
		int t = max(newa, newb);
		System.out.println(newa/t+" "+newb/t);
		
	}
	
	public static int max(int newa, int newb) {
		if(newb ==0) {
			return newa;
		}
		if(newb>=newa) {
			int tmp = newb;
			newb=newa;
			newa=tmp;
		}
		//newa∞° ¥ı≈≠
		
		int k = newa%newb;
		
		return max(newb,k);
	}

}
