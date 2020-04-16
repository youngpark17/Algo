import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int l;
	static int[][] map;
	static boolean[][] rowput;
	static boolean[][] colput;
	static int cnt=0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		rowput = new boolean[n][n];
		colput = new boolean[n][n];
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) { //열로 갈 수 있는 길 판단
			for(int j=0; j<n-1; j++) {
				int k = map[i][j];
				int k2 = map[i][j+1];
				int diff=Math.abs(k-k2);
				if(k==k2) {
					if(j==n-2) {
						cnt++;
					}
					continue;
				}
				else if(k+1==k2) { //열이 커지는 방향으로 가다보니까 오르막
					if(j-l+1>=0) { //언덕설치가능
						if(canPut(i,j-l+1,j,false,k)) {
							for(int a=j-l+1; a<=j; a++) {
								rowput[i][a]=true;
							}
						}
						else {
							break;
						}
					}
					else {
						break;
					}
				}
				else if(k-1==k2) {
					if(j+l<n) { //내리막설치가능
						if(canPut(i,j+1,j+l,false,k2)) {
							for(int a=j+1; a<=j+l; a++) {
								rowput[i][a]=true;
							}
						}
						else {
							break;
						}
					}
					else {
						break;
					}
				}
				else if(diff>1) {
					break;
				}
				if(j==n-2) {
					cnt++;
				}
				
			}
		}
		
		for(int i=0; i<n; i++) { //행으로 갈 수 있는 길 판단
			for(int j=0; j<n-1; j++) {
				int k = map[j][i];
				int k2 = map[j+1][i];
				int diff=Math.abs(k-k2);
				if(k==k2) {
					if(j==n-2) {
						cnt++;
					}
					continue;
				}
				else if(k+1==k2) { //열이 커지는 방향으로 가다보니까 오르막
					if(j-l+1>=0) { //언덕설치가능
						
						if(canPut(i,j-l+1,j,true,k)) {
							for(int a=j-l+1; a<=j; a++) {
								colput[a][i]=true;
							}
						}
						else {
							break;
						}
					}
					else {
						break;
					}
				}
				else if(k-1==k2) {
					if(j+l<n) { //내리막설치가능
						
						if(canPut(i,j+1,j+l,true,k2)) {
							for(int a=j+1; a<=j+l; a++) {
								colput[a][i]=true;
							}
						}
						else {
							break;
						}
					}
					else {
						break;
					}
				}
				else if(diff>1) {
					break;
				}
				if(j==n-2) {
					cnt++;
				}
				
			}
		}
		System.out.println(cnt);
	}
	
	static boolean canPut(int idx,int s, int e, boolean flag, int k) {
		if(!flag) {
			for(int i=s; i<=e; i++) {
				if(rowput[idx][i] ||map[idx][i]!=k) {
					return false;
				}
			}
		}
		else {
			for(int i=s; i<=e; i++) {
				if(colput[i][idx]||map[i][idx]!=k) {
					return false;
				}
			}
		}
		return true;
		
	}

}
