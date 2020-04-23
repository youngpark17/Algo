import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static boolean[] visited;
	static int[] match;
	static List<Integer>[] list;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1]; //강호네회사 직원 수
		match = new int[m+1]; //해야할 일 m개
		
		//한사람당 2개 가능.
		list = new List[n+1];
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

			
			for(int j=0; j<2; j++) {
				if(dfs(i)) {
					Arrays.fill(visited, false);
					ans++;
				}
			}
		}
		return ans;
	}
	
	public static boolean dfs(int x) {
		if(visited[x]) {
			return false;
		}
		visited[x] = true;
		for(int k : list[x]) {
			if(match[k]==0 || dfs(match[k])) {//아직 매칭이 안됐거나
				// 이미 매칭 됐어도 다른거랑 매칭 가능한 경우
				match[k] = x;
				return true;
			}
		}
		return false;
	}

}
