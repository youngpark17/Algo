import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static boolean[] visited;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		visited = new boolean[n];
		int[] output = new int[m];
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		comb(0,0,output);
		bw.flush();
	}
	
	public static void comb(int d, int c, int[] output) throws IOException {
		if(c==m) {
			for(int k : output) {
				bw.append(k+" ");
			}
			bw.append("\n");
		}
		else {
			for(int i=0; i<n; i++) {
				output[d] = arr[i];
				comb(d+1,c+1,output);
			}
		}
	}
	

}
