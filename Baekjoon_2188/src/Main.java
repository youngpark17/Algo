import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static List<Integer>[] list;
	static boolean[] visited;
	static int[] match;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new List[n+1];
		visited = new boolean[n+1];
		match = new int[m+1];
		for(int i=1; i<=n ;i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int j=0; j<k; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		System.out.println(binaryMatch());
		
	}
	
	public static int binaryMatch() {
		int ans=0;
		for(int i=1; i<=n; i++) {
			Arrays.fill(visited, false);
			if(dfs(i)) {
				ans++;
			}
		}
		return ans;
	}
	
	public static boolean dfs(int x) {
		if(visited[x]) {
			return false;
		}
		visited[x]= true;
		for(int k : list[x]) {
			if(match[k]==0 || dfs(match[k])){ //¾ÆÁ÷ ¸ÅÄªÀÌ ¾ÈµÆ°Å³ª, ¸ÅÄªµÆ¾îµµ ´Ù¸¥°Å¶û ¸ÅÄªÇÒ¼öÀÖ´Â°Å
				match[k] = x;
				return true;
			}
		}
		return false;
	}

}
