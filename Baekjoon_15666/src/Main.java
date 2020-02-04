import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	static BufferedWriter bw;
	static Set<Integer> set;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		tmp = br.readLine().split(" ");
		
		output = new int[m];
		visited = new boolean[n];
		set = new LinkedHashSet<>();
		for(int i=0; i<n; i++) {
			set.add(Integer.parseInt(tmp[i]));
		}
		Iterator it = set.iterator();
		int cnt=0;
		arr = new int[set.size()];
		while(it.hasNext()) {
			arr[cnt++] = (int)it.next();
		}
		Arrays.sort(arr);
		n=cnt;
		per(0);
		bw.flush();
		
	}
	public static void per(int c) throws IOException {
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
						per(c+1);
					}
				}
				else {
					output[c] = arr[i];
					per(c+1);
				}
				
			}
		}
	}
}


