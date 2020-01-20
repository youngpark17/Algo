import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int x;
	static int y;
	static int[][] map;
	static int[] order;
	static int[] box;
	static int currentX;
	static int currentY;
	static int currentUpper;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		order = new int[k];
		currentX=x;
		currentY=y;
		box = new int[6];
		currentUpper=0;
		Arrays.fill(box, 0);
		for(int i=0; i<k; i++) {
			order[i] = Integer.parseInt(st.nextToken());
			roll(order[i]);
		}
		

	}
	
	static void rotateRight() {
		int tmp = box[5];
		box[5]=box[2];
		box[2]=box[0];
		box[0]=box[3];
		box[3]= tmp;
	}

	static void rotateLeft() {
		int tmp = box[0];
		box[0]=box[2];
		box[2]=box[5];
		box[5]=box[3];
		box[3]=tmp;
	}

	static void rotateDown() {
		int tmp = box[4];
		box[4]=box[0];
		box[0]=box[1];
		box[1]=box[5];
		box[5]=tmp;

	}
	static void rotateUp() {
		int tmp = box[0];
		box[0]=box[4];
		box[4]=box[5];
		box[5]=box[1];
		box[1]=tmp;
	}

	static void roll(int order) {
		if(order==1) {//1234 悼辑合巢
			if(currentY+1>m-1) {
				return;
			}
			if(map[currentX][currentY]==0) {
				map[currentX][currentY]=box[5];
			}
			else {
				box[5]=map[currentX][currentY];
				map[currentX][currentY]=0;
			}
			rotateRight();
			currentY++;
			System.out.println(box[0]);

		}
		else if(order==2) { //辑率
			if(currentY-1<0) {
				return;
			}
			if(map[currentX][currentY]==0) {
				map[currentX][currentY]=box[5];
			}
			else {
				box[5]=map[currentX][currentY];
				map[currentX][currentY]=0;
			}
			rotateLeft();
			currentY--;

			System.out.println(box[0]);
		}
		else if(order==3) { //合率
			if(currentX-1<0) {
				return;
			}
			if(map[currentX][currentY]==0) {
				map[currentX][currentY]=box[5];
			}
			else {
				box[5]=map[currentX][currentY];
				map[currentX][currentY]=0;
			}
			currentX--;
			rotateUp();
			System.out.println(box[0]);
		}
		else { //巢率
			if(currentX+1>n-1) {
				return;
			}
			if(map[currentX][currentY]==0) {
				map[currentX][currentY]=box[5];
			}
			else {
				box[5]=map[currentX][currentY];
				map[currentX][currentY]=0;
			}
			currentX++;
			rotateDown();
			System.out.println(box[0]);
		}


	}

}
