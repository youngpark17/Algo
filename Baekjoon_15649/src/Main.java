import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		int[] output = new int[m];
		comb(0,0,output);
		
	}
	public static void comb(int d, int c,int[] output) {
		if(c==m) {
			for(int k : output) {
				System.out.print(k+" ");
			}
			System.out.println();
		}
		else {
			for(int i=0; i<n; i++) {
				if(!visited[i]) {
					visited[i] = true;
					output[d] = arr[i];
					comb(d+1,c+1,output);
					output[d] = 0;
					visited[i] = false;
				}
			}
		}
	}
	


}
