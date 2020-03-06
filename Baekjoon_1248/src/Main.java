import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int n;
	static char[][] op;
	static char[] tmp;
	static int[] output;
	static int[][] s;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		op=new char[n][n];
		tmp = br.readLine().toCharArray();
		int idx=0;
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				op[i][j]=tmp[idx++];
			}
		}
		output = new int[n];
		s = new int[n][n];
		per(0);

	}

	public static void per(int c) { //4개중 첫번쨰꺼 3개중 첫번쨰꺼 2개중 첫번쨰꺼 
		if(c==n) {
			List<Integer> list  = new ArrayList<>();
			for(int i=0; i<output.length; i++) {
				int sum=0;
				for(int j=i; j<output.length;j++) {
					sum+=output[j];
					list.add(sum);
				}
			}
			
			for(int i=0; i<list.size(); i++) {
				if(tmp[i]=='0') {
					if(list.get(i)!=0) {
						return;
					}
				}
				else if(tmp[i]=='+') {
					if(list.get(i)<=0) {
						return;
					}
				}
				else if(tmp[i]=='-') {
					if(list.get(i)>=0) {
						return;
					}
				}
			}
			for(int k : output) {
				System.out.print(k+" ");
			}
			System.exit(0);
		}
		else {
			loop:for(int i=-10; i<=10; i++) {
				output[c] =i;
				s[c][c]=i;
				if(c>0) {
					//열은 그대론데 행 줄어들면서 값 갱신.
					for(int j=c-1; j>=0; j--) {
						s[j][c] = s[c][c]+s[j][c-1];
					}
				}
				for(int a=c; a>=0; a--) {
					if(op[a][c]=='0') {
						if(s[a][c]!=0) {
							continue loop;
						}
					}
					else if(op[a][c]=='+') {
						if(s[a][c]<=0) {
							continue loop;
						}
					}
					else if(op[a][c]=='-') {
						if(s[a][c]>=0) {
							continue loop;
						}
					}
				}
				
				per(c+1);
			}
		}
	}
	
}


