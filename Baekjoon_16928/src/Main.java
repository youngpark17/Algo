import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
	static int n;
	static int m;
	static Map<Integer, Integer> l;
	static Map<Integer, Integer> s;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		visited = new boolean[101];
		l = new HashMap<Integer,Integer>();
		s = new HashMap<Integer,Integer>();
		for(int i=0; i<n; i++) {
			tmp = br.readLine().split(" ");
			l.put(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
		}
		
		for(int i=0; i<m; i++) {
			tmp = br.readLine().split(" ");
			l.put(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
		}
		
		int start=1;
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(1,0));
		visited[start]=true;
		while(!que.isEmpty()) {
			Node t = que.poll();
			if(t.x==100){
				System.out.println(t.c);
				System.exit(0);
			}
			for(int i=1; i<=6; i++) {
				int next=t.x+i;
				if(l.containsKey(t.x+i)) {
					next=l.get(t.x+i);
				}
				else if(s.containsKey(t.x+i)) {
					next=s.get(t.x+i);
				}
				if(next<=100 &&!visited[next]) {
					visited[next] = true;
					que.add(new Node(next,t.c+1));
				}
			}
			
		}
		
	}

}

class Node{
	int x;
	int c;
	Node(int x, int c){
		this.x=x;
		this.c=c;
	}
}
