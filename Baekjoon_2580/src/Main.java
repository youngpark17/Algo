import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] row;
	static boolean[][] col;
	static boolean[][] square;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		row = new boolean[9][10]; //1부터 9까지니까 
		col = new boolean[9][10];
		square = new boolean[9][10];
		StringTokenizer st;
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				row[i][map[i][j]] = true;
				col[j][map[i][j]] = true;
				int squareNum = getSquareNum(i, j);
				square[squareNum][map[i][j]] = true;
			}
		}
		//백트래킹 하자
		dfs(0);
	}
	
	public static void dfs(int cnt) throws Exception {
		if(cnt==81) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					bw.append(map[i][j]+" ");
				}
				bw.append("\n");
			}
			bw.flush();
			bw.close();
			System.exit(0);
		}
		else {
			int x = cnt/9;
			int y = cnt%9;
			//x가 0,1,2 일때 square 0 1 2 x가 0 y가 0,1,2이면 x가 0 y가 345면 1 x가 0가 678 이면 2 
			//x가 3 4 5 일때 square 3 4 5
			//x가 6 7 8 일때 square 6 7 8
			int squareNum=getSquareNum(x, y);
			if(map[x][y]!=0) {
				dfs(cnt+1);
			}
			else {
				for(int i=1; i<10; i++) {
					if(!row[x][i] && !col[y][i] && !square[squareNum][i] &&map[x][y]==0) {
						map[x][y] = i;
						row[x][i]=true;
						col[y][i]=true;
						square[squareNum][i]=true;
						dfs(cnt+1);
						map[x][y]=0;
						row[x][i]=false;
						col[y][i]=false;
						square[squareNum][i]=false;
					}
				}
			}
	
			
		}
	}
	public static int getSquareNum(int x, int y) {
		int squareNum=0;
		if(x/3==0) {
			if(y/3==0) {
				squareNum=0;
			}
			else if(y/3==1) {
				squareNum=1;
			}
			else if(y/3==2) {
				squareNum=2;
			}
		}
		else if(x/3==1) {
			if(y/3==0) {
				squareNum=3;
			}
			else if(y/3==1) {
				squareNum=4;
			}
			else if(y/3==2) {
				squareNum=5;
			}
		}
		else if(x/3==2) {
			if(y/3==0) {
				squareNum=6;
			}
			else if(y/3==1) {
				squareNum=7;
			}
			else if(y/3==2) {
				squareNum=8;
			}
		}
		return squareNum;
	}

}
