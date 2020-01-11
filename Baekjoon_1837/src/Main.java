import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		BigInteger p = new BigInteger(sc.next());
		int k = sc.nextInt();
		int[] prime = new int[k];
		boolean[] visited = new boolean[k+1];
		int cnt=0;
		for(int i=2; i<k; i++) {
			if(!visited[i]) {
				prime[cnt++]=i;
			}
			for(int j=i+i; j<k; j+=j) {
				visited[j]=true;
			}
		}
		
		for(int i=0; i<cnt; i++) {
			if((p.remainder(BigInteger.valueOf(prime[i])).doubleValue())==0){ //k보다 작은 소수의 집합에서 나누어 떨어지면
				System.out.println("BAD "+prime[i]);
				System.exit(0);
			}
		}
		System.out.println("GOOD");
		
		
		
	}

}
