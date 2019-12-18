import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static List<Integer>[] list;
	static boolean[] flag;
	static List<Integer>[] list2;


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n  = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int v = Integer.parseInt(input[2]);
		list = new LinkedList[n+1];
		flag = new boolean[n+1];
		
		flag[0]=true;
		for(int i=0; i<n+1; i++) {
			list[i] = new LinkedList<>();
		}
	


		for(int i=0; i<m; i++) {
			input = br.readLine().split(" ");
			int v1 = Integer.parseInt(input[0]);
			int v2 = Integer.parseInt(input[1]);
			list[v1].add(v2);
			list[v2].add(v1);
		}
		

		for(int i=1; i<n+1; i++) {
			Collections.sort(list[i]);
		}

		list2=list;
		if(!flag[v]) {
			dfs(v);
		}

		Arrays.fill(flag, false);
		System.out.println();
		bfs(v);

	

	}

	public static void dfs(int k) {
		flag[k]=true;
		System.out.print(k+" ");
		for(Integer i : list[k]) {
			if(!flag[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int k) {
		Queue<Integer> que = new LinkedList<>();
		flag[k]=true;
		que.add(k);

		while(!que.isEmpty()) {
			int j = que.remove();
			System.out.print(j+" ");
			for(Integer p : list2[j]) {
				if(!flag[p]) {
					que.add(p);
					flag[p]=true;
				}
				
			}

		}

	}
}


