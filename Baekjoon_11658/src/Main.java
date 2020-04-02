import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static long[][] cumSum;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st=new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		cumSum = new long[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; i++) {
			cumSum[i][0] = map[i][0];
		}
		for(int i=0 ;i<n; i++) {
			for(int j=1; j<n; j++) {
				cumSum[i][j] = cumSum[i][j-1]+map[i][j];
			}
		}
	
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			if(w==0) {
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				
				int diff = c-map[x][y];
				map[x][y]=c;
				for(int i=y; i<n; i++) {
					cumSum[x][i]+=diff; //행에 대한 누적합
					
				}
			}
			else {
				int x1 = Integer.parseInt(st.nextToken())-1;
				int y1 = Integer.parseInt(st.nextToken())-1;
				int x2 = Integer.parseInt(st.nextToken())-1;
				int y2 = Integer.parseInt(st.nextToken())-1;
				long tmp = sum(x1,y1,x2,y2);
				bw.append(tmp+"\n");
			}
		}
		bw.flush();
		bw.close();
		
		
	}
	
	public static long sum(int x1, int y1, int x2, int y2) {
		int ans=0;
		for(int i=0; i<=x2; i++) {
			ans+=cumSum[i][y2];
		}
		for(int i=0; i<x1; i++) {
			ans-=cumSum[i][y2];
		}
		for(int i=x1; i<=x2; i++) {
			if(y1==0) {
				break;
			}
			ans-=cumSum[i][y1-1]; 
		}
		return ans;
		
	}


}