import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static boolean[] visited;
	static int total;
	static int answer;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		total=0;
		answer = Integer.MAX_VALUE;
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}
		visited = new boolean[n];
		
		comb(0,0);
		//n명중에 n/2명만 뽑으면 되는 것이었다...
		System.out.println(answer);
	}
	
	public static void comb(int d, int c) {
		if(c==n/2) {
			int part1=0;
			int part2=0;
			for(int i=0; i<n; i++) {
				for(int j=i; j<n; j++) {
					if(i==j) {
						continue;
					}
					if(visited[i] && visited[j]) {
						part1 += map[i][j];
						part1 += map[j][i];
					}
					if(!visited[i] && !visited[j]) {
						part2 +=map[i][j];
						part2 +=map[j][i];
					}
				}
			}
			
			answer = Math.min(answer, Math.abs(part1-part2));
		}
		else {
			for(int i=d; i<n; i++) {
				if(!visited[i]) {
					visited[i] = true;
					comb(i+1,c+1);
					visited[i] = false;
				}
			}
		}
	}
	
}

