import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int a;
	static int b;
	static int c;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		a = Integer.parseInt(tmp[0]);
		b= Integer.parseInt(tmp[1]);
		c = Integer.parseInt(tmp[2]);
		dfs(a,b,c,0);
		System.out.println(0);
		
	}
	
	public static void dfs(int a1, int b1, int c1, int depth) {
		if(a1==b1 && b1==c1) {
			System.out.println(1);
			System.exit(0);
		}
		if(depth==10) {
			return;
		}
		if(a1!=b1) {
			if(a1>b1) { //작은쪽 두배 큰쪽에서 작은쪽 빼기
				if(a1-b1>0) {
					dfs(a1-b1,b1+b1,c1,depth+1);
				}
			}
			else if(b1>a1) {
				if(b1-a1>0) {
					dfs(a1+a1,b1-a1,c1,depth+1);
				}
			}
		}
		if(a1!=c1) {
			if(a1>c1) {
				if(a1-c1>0) {
					dfs(a1-c1,b1,c1+c1,depth+1);
				}
			}
			else if(c1>a1) {
				if(c1-a1>0) {
					dfs(a1+a1,b1,c1-a1,depth+1);
				}
			}
		}
		if(b1!=c1) {
			if(b1>c1) {
				if(b1-c1>0) {
					dfs(a1,b1-c1,c1+c1,depth+1);
				}
			}
			else if(c1>b1) {
				if(c1-b1>0) {
					dfs(a1,b1+b1,c1-b1,depth+1);
				}
			}
		}
	}

}
