import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		if(k==0) {
			System.out.println(1);
			return;
		}
		
		System.out.println(get(n,k));
		
	}
	
	public static int get(int k, int j) {
		if(k==j) {
			return 1;
		}
		if(j==1) {
			return k;
		}
		
		return get(k-1,j-1)+get(k-1,j);
	}

}
