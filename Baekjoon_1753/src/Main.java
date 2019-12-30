import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int[] distance;
	static boolean[] visited;
	static int[] previous;
	static int v;
	static int e;
	static int k;
	static List<Edge>[] list;


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		v = Integer.parseInt(tmp[0]);
		e = Integer.parseInt(tmp[1]);
		k = Integer.parseInt(br.readLine());
		distance = new int[v+1];
		visited = new boolean[v+1];
		previous = new int[v+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(previous, -1);
		distance[k]=0;
		previous[k]=0;
		list = new List[v+1];

		for(int i=1; i<v+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<e; i++) {
			tmp = br.readLine().split(" ");
			Edge e = new Edge(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]));
			list[e.from].add(e);	
		}

		for(int i=1; i<v+1; i++) {
			int minVer = -1;
			int min = Integer.MAX_VALUE;
			for(int j=1; j<v+1; j++) {
				if(!visited[j] && distance[j]<min) { //시작점.
					min = distance[j];
					minVer=j;
				}
			}
			if(minVer!=-1) {
				visited[minVer]=true;


				for(Edge e : list[minVer]) { //e.to까지의 현재 거리는
					int currentDistance = distance[e.to];
					int newdist = distance[minVer]+e.cost;
					if(currentDistance>newdist) {
						distance[e.to] = newdist;
						previous[e.to] = minVer;
					}
				}


			}

		
		}
		
		for(int i=1; i<v+1; i++) {
			if(distance[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {
				System.out.println(distance[i]);
			}

		}

	}
}

	class Edge{
		int from;
		int to;
		int cost;
		Edge(int from, int to, int cost){
			this.from=from;
			this.to=to;
			this.cost=cost;
		}
	}
