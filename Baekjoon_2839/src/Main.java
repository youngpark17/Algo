import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n%5==0) {
			System.out.println(n/5);
			return;
		}
		else { // 5a+3b
			int p = n/5;
			for(int i=p; i>0; i--) {
				int temp = n-(i*5);
				if(temp%3==0) {
					System.out.println(i+(temp/3));
					return;
				}
			}
		}
		if(n%3==0) {
			System.out.println(n/3);
			return;
		}
		else {
			System.out.println(-1);
		}
	}
}
