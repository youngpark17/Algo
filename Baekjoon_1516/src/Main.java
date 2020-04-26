import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static List<Integer>[] list;
	static int[] time;
	static int[] minTime;
	static int[] indegree;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		list = new List[n+1];
		time = new int[n+1];
		minTime = new int[n+1];
		indegree = new int[n+1];
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int k=1; k<n+1; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<Integer.MAX_VALUE; i++) {
				if(i==1) {
					time[k] = Integer.parseInt(st.nextToken());
					continue;
				}
				int a = Integer.parseInt(st.nextToken());
				if(a==-1) {
					break;
				}
				list[a].add(k);
				indegree[k]++;
				
			}
		}
		Queue<Integer> que = new LinkedList<>();
		for(int i=1; i<n+1; i++) {
			if(indegree[i]==0) { //진입하는게 없으면 최소가능.
				minTime[i] = time[i];
				que.add(i);
			}
		}
		
		while(!que.isEmpty()) {
			int current = que.poll();
			
			for(int next : list[current]) {
				//자기 건물보다 먼저 지어져야 하는 것 중 가장 오래걸린거 찾아서 그 뒤에 짓자.
				indegree[next]--;

				minTime[next] = Math.max(minTime[next], minTime[current] + time[next]);
				if(indegree[next]==0) {
					que.add(next);
				}
				
			}
		}
		
		for(int i=1; i<n+1; i++) {
			bw.append(minTime[i]+" ");
		}
		bw.flush();
		bw.close();
	
			
		
	}
	
	public static void dfs(int a, int cum) {
		
		
	}

}
