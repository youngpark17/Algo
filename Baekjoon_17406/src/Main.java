import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int m;
	static int k;
	static int[][] map;
	static int[][] tmap;
	static boolean[] visited;
	static Node[] output;
	static int min = Integer.MAX_VALUE;
	static Node[] input;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		k = Integer.parseInt(tmp[2]);
		visited = new boolean[k];
		input = new Node[k];
		output = new Node[k];
		tmap = new int[n][m];
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			tmp = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		for(int i=0; i<k; i++) {
			tmp = br.readLine().split(" ");
			input[i] = new Node(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]));
		}
		comb(0);
		System.out.println(min);
		
	}
	
	public static void comb(int c) {
		if(k==c) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					tmap[i][j]=map[i][j];
				}
			}
			//순열 구했다.
			for(int i=0; i<k; i++) {
				int R = output[i].r-1; //(R-S,C-S) (R+S, C+S) 시계방향으로 돌림 한칸씩 돌림.
				int C = output[i].c-1;
				int S = output[i].s;
				rotate(R,C,S);
			}
			for(int i=0; i<n; i++) {
				int sum=0;
				for(int j=0; j<m; j++) {
					sum+=tmap[i][j];
				}
				min = Math.min(sum, min);
			}
			
		}
		else {
			for(int i=0; i<k; i++) {
				if(!visited[i]) {
					visited[i] = true;
					output[c] = input[i];
					comb(c+1);
					visited[i] = false;
				}
			}
		}
	}
	
	public static void rotate(int r, int c, int s) {
		if(s==0) {
			return;
		}
		int tmp = tmap[r-s][c+s];
		for(int i=c+s; i>c-s; i--) {
			tmap[r-s][i] = tmap[r-s][i-1];
		}
		for(int i=r-s; i<r+s; i++) {
			tmap[i][c-s] = tmap[i+1][c-s];
		}
		for(int i=c-s; i<c+s; i++) {
			tmap[r+s][i] = tmap[r+s][i+1];
		}
		for(int i=r+s; i>r-s+1; i--) {
			tmap[i][c+s] = tmap[i-1][c+s];
		}
		tmap[r-s+1][c+s] = tmp;
		rotate(r,c,s-1);
		
		
		
	}
	

}

class Node{
	int r;
	int c;
	int s;
	
	Node(int r, int c, int s){
		this.r=r;
		this.c=c;
		this.s=s;
	}
}
