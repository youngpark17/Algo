import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static List<Integer>[] list;
	static int[] w;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n =Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		list = new List[n+1];
		w = new int[n];
		for(int i=0; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		//사장부터 0
		st.nextToken();
		for(int i=1; i<n;i++) {
			list[Integer.parseInt(st.nextToken())-1].add(i);
		}
		//자식에 대한거 담고있음.
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			w[number]+=weight;
		}
		dfs(0);
		for(int k : w) {
			System.out.print(k+" ");
		}
		
		
	}
	
	public static void dfs(int number) {
		for(int k : list[number]) {
			w[k]+=w[number];
			dfs(k);
		}
	}

}
