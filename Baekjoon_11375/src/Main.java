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
		list = new List[1001];
		visited = new boolean[1001];
		match = new int[1001];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
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
			if(dfs(i)) { //매칭 성공.
				ans++;
			}
		}
		return ans;
	}
	
	public static boolean dfs(int x) {
		if(visited[x]) { //방문된 정점은 방문 불가 1~n번까지 중에
			//지금 dfs돌리고 있는 정점 기준으로는 아무것도 방문 안된 상태 도착 부분만 매칭이 되어있는 상태
			return false;
		}
		visited[x] = true; //방문
		for(int k : list[x]) {
			if(match[k]==0 || dfs(match[k])) {
				//매칭이 되어있지 않은 정점을 만나거나 이미 매칭된 정점이 다른 정점과 매칭이 가능할 때
				match[k] = x; //매칭 시켜줌
				return true;
				
			}
		}
		return false;
	}

}
