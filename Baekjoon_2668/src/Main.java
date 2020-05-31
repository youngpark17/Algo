import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
	static int n;
	static int[] arr;
	static int[] next;
	static int[] visited;
	static int last;
	static SortedSet<Integer> set;
	static List<Integer> list;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		next = new int[n+1];
		list = new ArrayList<>();
		set = new TreeSet();
		for(int i=1; i<n+1; i++) {
			next[i] = Integer.parseInt(br.readLine());
		}
		visited = new int[n+1];
		for(int i=1; i<n+1; i++) {
			dfs(i);
			Arrays.fill(visited, 0);
		}
		bw.append(set.size()+"\n");
		for(int k : set) {
			bw.append(k+"\n");
		}
		bw.flush();
		bw.close();
		
	}
	public static void dfs(int k) {
		if(visited[k]==1) {
			set.add(k);
			visited[k] =2;
			return;
		}
		visited[k] = 1;
		
		if(visited[k]!=2) {
			dfs(next[k]);
		}
		visited[k] = 2;
	}


}
