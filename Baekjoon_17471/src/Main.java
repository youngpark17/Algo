import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static boolean[] visited;
	static List<Integer>[] list;
	static int sum=0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new List[n+1];
		visited = new boolean[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n+1];
		for(int i=1; i<n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		for(int i=1; i<n+1; i++) {
			list[i] = new LinkedList<>();
		}
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int j=0; j<k; j++) {
				int t = Integer.parseInt(st.nextToken());
				list[i].add(t);
				list[t].add(i);
			}
		}
		for(int i=1; i<((n+1)/2)+1; i++) { //6개의 지역구가 존재하면 1,5 2,4, 33 7개가 존재하면 1,6 2,5 3,4 생각
			comb(i,0,1); //i개 목표 0개 뽑은것부터 시작. depth 1.
		}
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	
		
	}
	
	public static int bfs(int s,int d, int r, boolean flag) {
		Queue<Integer> que = new LinkedList<>();
		boolean[] check = new boolean[n+1];
		int cnt=0;
		que.add(s);
		check[s] = true;
		while(!que.isEmpty()) {
			int k = que.poll();
			cnt++;
			for(int t : list[k]) {
				if(visited[t]==flag && !check[t]) {
					que.add(t);
					check[t] = true;
				}
			}
		}
		return cnt;
	}
	
	public static void comb(int r, int c, int d) {
		if(c==r) {
			boolean flag1=false;
			boolean flag2=false;
			int k1=0;
			int k2=0;
			int c1=0;
			int c2=0;
			for(int i=1; i<n+1; i++){
				if(visited[i]&&!flag1) {
					flag1=true;
					c1 =bfs(i,0,r,visited[i]); // 선택 된것만 가지고 dfs 돌아보고 아닌거 가지고 돌아보고....
				}
				else if(!visited[i] && !flag2) {
					flag2= true;
					c2 =bfs(i,0,n-r,visited[i]);
				}
			}
			if(c1+c2==n) { //나눈 후 bfs로 탐색한 지역구의 개수가 전체와 같다면.
				int tmpsum=0;
				for(int i=1; i<n+1; i++) {
					if(visited[i]) {
						tmpsum+=arr[i];
					}
				}
				min = Math.min(min,Math.abs(sum-tmpsum*2));	
			}
		}
		else {
			for(int i=d; i<n+1; i++) {
				if(!visited[i]) {
					visited[i]  = true;
					comb(r,c+1,i+1);
					visited[i] = false;
				}
			}
		}
	}

}
