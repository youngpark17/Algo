import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int paperCount;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static int[] paperArr;
	static int sum;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		sum=0;
		paperArr=new int[5];
		paperCount=0;
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					paperCount++;
				}
			}
		}
		dfs(0);
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else
			System.out.println(min);
		
		
	}
	
	public static void dfs(int x) {
		if(sum>=min) {
			return;
		}
		if(paperCount==0) {
			min = Math.min(min, sum);
			return;
		}
		int r=x/10;
		int c=x%10;
		if(map[r][c]==1) {
			for(int j=4; j>=0; j--) {
				if(c+j<10 && r+j<10) {
					if(canCover(r,c,j) &&paperArr[j]<5) {
						cover(r,c,j);
						paperArr[j]++;
						paperCount-=(j+1)*(j+1);
						sum++;
						dfs(x+(j+1));
						decover(r,c,j);
						paperCount+=(j+1)*(j+1);
						paperArr[j]--;
						sum--;
					}
				}
			}
		}
		else {
			dfs(x+1);
		}
		
		
	}
	
	public static void cover(int r, int c, int j) {
		for(int i=r; i<=r+j; i++) {
			for(int k=c; k<=c+j; k++) {
				map[i][k]=0;
			}
		}
		
	}
	
	public static void decover(int r, int c, int j) {
		for(int i=r; i<=r+j; i++) {
			for(int k=c; k<=c+j; k++) {
				map[i][k]=1;
			}
		}
		
	}
	
	public static boolean canCover(int x, int y, int d) {
		for(int i=x; i<=x+d; i++) {
			for(int j=y; j<=y+d; j++) {
				if(map[i][j]==0) {
					return false;
				}
			}
		}
		
		
		return true;
	}

}
