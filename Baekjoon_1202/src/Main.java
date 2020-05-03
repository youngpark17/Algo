import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	static int n,k;
	static Node[] arr;
	static int[] bag;
	static long ans;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new Node[n];
		bag = new int[k];
		PriorityQueue<Node> pq = new PriorityQueue<Node>((Node a, Node b)->(b.v-a.v));
		//��� ��������.
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		for(int i=0; i<k; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		ans=0;
		visited = new boolean[k];
		//Set���� .... ���� ���� ������ ó���ȵǴϱ� map���� ����üũ.
		TreeMap<Integer,Integer> map = new TreeMap<>();
		for(int tmp : bag) {
			map.put(tmp,map.getOrDefault(tmp, 0)+1);
		}
		while(!pq.isEmpty() && !map.isEmpty()) {
			Node t = pq.poll();
			//���� ���Ժ��� ũ�ų� �������߿� �� ������.
			if(map.lastKey()>=t.m) {//Ʈ���� ���� ���� ���Զ� ���ų� ū ������ �����Ѵٸ�...
				int rm = map.tailMap(t.m).firstKey();
				map.put(rm,map.get(rm)-1);
				if(map.get(rm)==0) {
					map.remove(rm);
				}
				ans+=(long)t.v;
			}
			
			
		}
		System.out.println(ans);
		

	}

}

class Node{
	int m;
	int v;
	Node(int m, int v){
		this.m=m;
		this.v=v;
	}
}
