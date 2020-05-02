import java.util.Scanner;

public class Main {
	static long x,y;
	static long ans=Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		x = sc.nextLong();
		y = sc.nextLong();
		long z = (long)(((double)(y*100)/(double)x));
		//y/totalÀÌ ½Â·üÀÌ´Ù.
		bs(0,2000000001,z);
		if(z>=99) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
		
		
		
	}
	
	public static void bs(long a, long b, long c) {
		if(a==b) {
			return;
		}
		long mid = (a+b)/2;
		int nc = (int)(((y+mid)*100/(double)((x+mid))));
		if(nc>c) {
			ans = Math.min(ans, mid);
			bs(a,mid,c);
		}
		else {
			bs(mid+1,b,c);
		}
		
	}
	
	

}