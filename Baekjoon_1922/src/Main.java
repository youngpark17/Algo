import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static int[] arr;
	static List<Edge> list;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		for(int i=0; i<arr.length; i++) {
			arr[i]=i;
		}
		int answer=0;
		
		list = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			String[] tmp = br.readLine().split(" ");
			int node1 = Integer.parseInt(tmp[0]);
			int node2 = Integer.parseInt(tmp[1]);
			int cost = Integer.parseInt(tmp[2]);
			Edge e = new Edge(cost, node1, node2);
			list.add(e);
		}
		
		Collections.sort(list);
		while(!list.isEmpty()) {
			Edge e = list.remove(0);
			if(!check(e)) { // 두 컴퓨터가 연결이 안되어 있으면
				union(e.point1,e.point2); //연결
				answer+=e.cost;
			}
		}
		
		System.out.println(answer);
		
	}
	
	public static int find(int parent) {
		if(arr[parent]==parent) { //루트 노드이면
			return parent;
		}
		return arr[parent] = find(arr[parent]);
	}
	
	public static void union(int node1, int node2) {
		int x = find(node1);
		int y = find(node2);
		if(x!=y) {
			arr[x]=y;
		}
	}
	
	public static boolean check(Edge e) {
		int k1 = find(e.point1);
		int k2 = find(e.point2);
		return (k1==k2)? true:false;
	}
	


}

class Edge implements Comparable<Edge>{
	int cost;
	int point1;
	int point2;
	Edge(int cost, int point1, int point2){
		this.cost=cost;
		this.point1=point1;
		this.point2=point2;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.cost-o.cost;
	}
	
}
