import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberOfTestCase = Integer.parseInt(br.readLine());
		for(int i=0; i<numberOfTestCase; i++) {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int[][] arr = new int[n][n];
			int cnt=1;
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					arr[j][k] = Integer.parseInt(tmp[cnt++]);
				}
			}
			System.out.print("#"+(i+1)+" ");
			divide(arr);
			System.out.println();
		}
	}
	
	
	public static int findMax(int[][] arr) {
		int max = -1;
		for(int[] k : arr) {
			for(int p : k) {
				if(p>max) {
					max=p;
				}
			}
		}
		return max;
	}
	
	
	public static void divide(int[][] arr) {
		int n = arr.length/2;
		if(n==1) {
			return;
		}
		int[][] arrB0 = new int[n][n];
		int[][] arrB1 = new int[n][n];
		int[][] arrB2 = new int[n][n];
		int[][] arrB3 = new int[n][n];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(i<n && j<n) {
					arrB0[i][j] = arr[i][j];
				}
				else if(i<n && j>=n) {
					arrB1[i][j-n] = arr[i][j];
				}
				else if(i>=n && j<n) {
					arrB2[i-n][j] = arr[i][j];
				}
				else if(i>=n && j>=n) {
					arrB3[i-n][j-n] = arr[i][j];
				}
			}
		}
		
		int maxA = findMax(arr);
		int maxB0 = findMax(arrB0);
		int maxB1 = findMax(arrB1);
		int maxB2 = findMax(arrB2);
		int maxB3 = findMax(arrB3);
		if(maxB1<maxB0) {
			maxB0=maxB1;
		}
		
		if(maxB2<maxB0) {
			maxB0=maxB2;
		}
		
		if(maxB3<maxB0) {
			maxB0=maxB3;
		}
		
		//현재 부분행렬의 최대값들중 촤소값이 maxB0
		
		if(maxA<=maxB0*1.2) {
			System.out.print(1);
			divide(arrB0);
			divide(arrB1);
			divide(arrB2);
			divide(arrB3);
		}
		else {
			System.out.print(0);
		}
		
	}

}
