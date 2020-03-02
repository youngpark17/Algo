import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static int[][] map;
	static BufferedWriter bw;
	static String tmp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		map = new int[n][n];
		tmp="";
		for(int i=0; i<n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<n; j++) {
				map[i][j] = tmp[j]-'0';
			}
		}
		dfs(map);
		bw.flush();
	}

	public static void dfs(int[][] arr) throws Exception {
		if(check(arr)) {
			int[][] arr1 = new int[arr.length/2][arr.length/2];
			int[][] arr2 = new int[arr.length/2][arr.length/2];
			int[][] arr3 = new int[arr.length/2][arr.length/2];
			int[][] arr4 = new int[arr.length/2][arr.length/2];
			for(int i=0; i<arr.length/2; i++) {
				for(int j=0; j<arr.length/2; j++) {
					arr1[i][j] = arr[i][j];
				}
			}
			for(int i=0; i<arr.length/2; i++) {
				for(int j=0; j<arr.length/2; j++) {
					arr2[i][j] = arr[i][j+arr.length/2];
				}
			}
			for(int i=0; i<arr.length/2; i++) {
				for(int j=0; j<arr.length/2; j++) {
					arr3[i][j] = arr[i+arr.length/2][j];
				}
			}
			for(int i=0; i<arr.length/2; i++) {
				for(int j=0; j<arr.length/2; j++) {
					arr4[i][j] = arr[i+arr.length/2][j+arr.length/2];
				}
			}
			bw.append("(");
			dfs(arr1);
			dfs(arr2);
			dfs(arr3);
			dfs(arr4);
			bw.append(")");
		}
		else {
			if(arr[0][0]==1) {
				
				bw.append("1");
			}
			else {
				bw.append("0");
			}
		}

	}

	public static boolean check(int[][] arr) {
		boolean flag1=false;
		boolean flag2=false;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j]==1) {
					flag1=true;
				}
				else {
					flag2=true;
				}
			}
		}
		return flag1 && flag2;
	}

}
