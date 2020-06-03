import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static int maxN;
	static StringBuilder sb;
	static int n;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n =sc.nextInt();
		maxN=1*(int)Math.pow(10, n)-1;
		//maxN까지의 소수를 모두 구하자.
		
		//백트래킹으로 maxN까지의 소수 찾자.
		sb = new StringBuilder();
		
		for(int i=2; i<9; i++) {
			if(!check(i)) {
				sb.append(i);
				dfs(0);
				sb.deleteCharAt(sb.toString().length()-1);
			}
		}
		bw.flush();
		bw.close();
		
	}
	
	public static boolean check(int k) {
		for(int i=2; i<=Math.sqrt(k); i++) {
			if(k%i==0) {
				return true;
			}
		}
		return false;
	}
	
	public static void dfs(int depth) throws Exception {
		if(depth==n-1) {
			if(!check(Integer.parseInt(sb.toString()))) {
				bw.append(sb.toString()+"\n");
			}
		}
		else {
			for(int i=1; i<=9; i++) {
				sb.append(i);
				if(!check(Integer.parseInt(sb.toString()))) {
					dfs(depth+1);
				}
				sb.deleteCharAt(sb.toString().length()-1);
			}
		}
	}
	

}
