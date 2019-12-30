import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[] parent;
	static int[] depth;
	static ArrayList<Integer>[] list;
	static int n;
	static int m;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList();
		}
		
		
		for(int i=0; i<n-1; i++) {
			String[] tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			list[a].add(b);
			list[b].add(a);
		}
		
		int start = 1; // 루트 1번
		parent = new int[n+1];
		depth = new int[n+1];
		
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		parent[start]=start;
		depth[start]=start;
		while(!que.isEmpty()) {
			
			int from = que.poll();
			
			for(int to : list[from]) {
				if(parent[to]==0) { //부모가 설정이 안되어있으면 
					que.add(to); //현재 노드의 자식들 다 넣음.
					parent[to]=from;
					depth[to]=depth[from]+1;
					
				}
			}
		}
		
		m= Integer.parseInt(br.readLine());
		while(m-- > 0) {
			String[] tmp = br.readLine().split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			int temp;
			if(depth[y]>depth[x]) { //y가 x보다 깊이가 깊으면
				temp=y;
				y=x;
				x=temp; //깊이가 깊은 것을 x로 바꿈. x가 깊이가 더 큼.
			}
			
			while(depth[x]!=depth[y]) {
				x=parent[x];
			}
			
			if(x==y) { //깊이가 같아졌을떄  같으면
				System.out.println(x);
			}
			else {
				while(parent[x]!=parent[y]) { //깊이가 같은데 부모가 다르면 같을때까지 거슬러 올라감
					x=parent[x];
					y=parent[y];
				}
				System.out.println(parent[x]);
			}
		}
		
	
		
	}
	


}
