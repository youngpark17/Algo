import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int k;
	static int[][] map;
	static int[][] sticker;
	static int answer=0;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			sticker = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
			for(int a=0; a<sticker.length; a++) {
				st = new StringTokenizer(br.readLine());
				for(int b=0; b<sticker[0].length; b++) {
					sticker[a][b] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt=0;
			loop1: for(int a=0; a<n; a++) {
				for(int b=0; b<m; b++) {
					if(canCover(a,b)) {
						cnt=0;
						break loop1;
					}
					else if(a==n-1 && b==m-1){ //끝까지 갔는데 못붙였다면 회전 시킨다음에 확인하자..
						cnt++;
						if(cnt<4) {
							a=-1;
							b=0;
							rotate();
							break;
						}
						else {
							cnt=0;
							break loop1;
						}
					}

				}
			}
			
		}
		
		
		System.out.println(answer);
	}
	
	public static void rotate() {
		int[][] tmp = new int[sticker[0].length][sticker.length];
		for(int r=0; r<sticker.length; r++) {
			for(int c=0; c<sticker[0].length; c++) {
				int newR = sticker.length-(r+1);
				tmp[c][r] = sticker[newR][c];
			}
		}
		sticker=tmp;
	}
	
	public static boolean canCover(int r,int c) {
		for(int i=0; i<sticker.length; i++) {
			for(int j=0; j<sticker[0].length; j++) {
				if(r+i>=n || c+j>=m) {//범위 초과
					return false;
				}
				if(map[r+i][c+j]==1 && sticker[i][j]==1) { //스티커를 붙이려했으나... 못붙임
					return false;
				}
			}
		}
		for(int i=0; i<sticker.length; i++) {
			for(int j=0; j<sticker[0].length; j++) {
				if(sticker[i][j]==1) {
					map[r+i][c+j]=1;
					answer++;
				}
			}
		}
		
		return true;
	}
	


}
