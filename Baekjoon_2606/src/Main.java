import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static List<Integer>[] list;
	static boolean[] visited;
	static int answer=0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new List[n];
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken())-1;
			int n2 = Integer.parseInt(st.nextToken())-1;
			list[n1].add(n2);
			list[n2].add(n1);
		}
		dfs(0);
		System.out.println(answer-1);
	}
	
	public static void dfs(int k) {
		for(int a : list[k]) {
			if(!visited[a]) {
				visited[a]=true;
				answer++;
				dfs(a);
			}	
		}
	}

}
