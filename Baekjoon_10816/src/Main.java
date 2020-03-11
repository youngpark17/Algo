import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		visited = new int[20000001];
		for(int i=0; i<n; i++) {
			int k = Integer.parseInt(st.nextToken())+10000000;
			visited[k]++;
		}
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<m; i++) {
			bw.append(visited[Integer.parseInt(st.nextToken())+10000000]+" ");
		}
		bw.flush();
		bw.close();
	}

}
