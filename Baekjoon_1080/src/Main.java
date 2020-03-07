import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int m;
	static int[][] from;
	static int[][] to;
	static int[] dx= {0,0,0,1,1,1,2,2,2};
	static int[] dy = {0,1,2,0,1,2,0,1,2};
	static int count=0;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		from = new int[n][m];
		to = new int[n][m];
		for(int i=0; i<n; i++) {
			char[] t1 = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				from[i][j] = t1[j]-'0';
			}
		}
		
		for(int i=0; i<n; i++) {
			char[] t2 = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				to[i][j] = t2[j]-'0';
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				to[i][j] = from[i][j]^to[i][j];
			}
		}
		boolean flag=false;
		if(n<3 || m<3) {
			flag=true;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(to[i][j]==1) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		if(flag) {
			System.out.println(0);
			System.exit(0);
		}
		//n-3 m-3까지 확인해보자.
		for(int i=0; i<n-2; i++) {
			for(int j=0; j<m-2; j++) {
				if(to[i][j]==1) {
					count++;
					for(int k=0; k<9; k++) {
						if(to[i+dx[k]][j+dy[k]]==0) {
							to[i+dx[k]][j+dy[k]]=1;
						}
						else {
							to[i+dx[k]][j+dy[k]]=0;
						}
					}
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0;j<m;j++) {
				if(to[i][j]==1) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		System.out.println(count);
		
		
		
	}
	


}
