import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static List<Integer>[] list;
	static boolean[] visited;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new List[n];
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			list[i] = new LinkedList<>();
		}
		for(int i=0;i<m; i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		//한 점을 기준으로 dfs 돌고 깊이가 5이상인 경우가 있으면 1출력.
		for(int i=0; i<n; i++) {
			dfs(i,0);
		}
		System.out.println(0);
	}
	public static void dfs(int num, int d) {
		if(d==5) {
			System.out.println(1);
			System.exit(0);
		}
		else {
			for(int k : list[num]) {
				if(!visited[k]) {
					visited[k]=true;
					dfs(k,d+1);
					visited[k] = false;
				}
			}
		}
	}

}
