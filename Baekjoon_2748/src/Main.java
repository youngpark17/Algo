import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] arr = new long[n+1];
		if(n>=0) {
			arr[0]=0;
		}
		
		if(n>=1) {
			arr[1]=1;
		}
		
		if(n>=2) {
			for(int i=2; i<arr.length; i++) {
				arr[i]=arr[i-1]+arr[i-2];
			}
		}
		
		System.out.println(arr[n]);
	}

}
