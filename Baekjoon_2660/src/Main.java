import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] scores;
	static int[] arr;
	static List<Integer>[] list;
	static boolean[] visited;
	static int cnt;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		scores = new int[n+1];
		list = new List[n+1];
		visited = new boolean[n+1];
		for(int i=1; i<n+1;i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		while(!(a==-1 && b==-1)) {
			list[a].add(b);
			list[b].add(a);
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<=50; j++) {
				cnt=0;
				bfs(i,0,j);
				Arrays.fill(visited, false);
				if(cnt==n) {
					scores[i]=j;
					break;
				}
			}
		}
		int minScore=Integer.MAX_VALUE;
		for(int i=1; i<n+1; i++) {
			if(scores[i]<minScore) {
				minScore=scores[i];
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> lst = new ArrayList<>();
		for(int i=1; i<n+1; i++) {
			if(scores[i]==minScore) {
				lst.add(i);
			}
		}
		bw.append(minScore+" ");
		bw.append(lst.size()+"\n");
		for(int stu : lst) {
			bw.append(stu+" ");
		}
		bw.flush();
		bw.close();
	
		
	}
	
	public static void bfs(int start,int depth, int maxDepth) {
		Node t = new Node(start,0);
		visited[start] = true;
		Queue<Node> que = new LinkedList<Node>();
		que.add(t);
		while(!que.isEmpty()) {
			Node p = que.poll();
			if(p.currentDepth>maxDepth) {
				break;
			}
			cnt++;
			for(int k : list[p.x]) {
				if(!visited[k]) {
					visited[k]=true;
					que.add(new Node(k,p.currentDepth+1));
				}
			}
		}
	}

}

class Node{
	int x;
	int currentDepth;
	
	Node(int x, int c){
		this.x=x;
		this.currentDepth=c;
	}
}
