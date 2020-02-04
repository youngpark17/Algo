import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		tmp = br.readLine().split(" ");
		arr = new int[n];
		output = new int[m];
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		Arrays.sort(arr);
		per(0,0);
		bw.flush();
	}
	public static void per(int d, int c) throws IOException {
		if(c==m) {
			for(int k : output) {
				bw.append(k+" ");
			}
			bw.append("\n");
		}
		else {
			for(int i=0; i<n; i++) {
				if(c!=0) {
					if(output[c-1]<=arr[i]) {
						output[c] = arr[i];
						per(d+1,c+1);
					}
				}
				else {
					output[c] = arr[i];
					per(d+1,c+1);
				}
				

			}
		}
	}

}
