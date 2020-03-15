import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] tmp = new int[n-1];
		for(int i=1; i<n; i++) {
			tmp[i-1] = arr[i]-arr[i-1];
		}
		
		List<Node> list = new ArrayList<Node>();
		for(int i=0; i<n-1; i++) {
			list.add(new Node(i,tmp[i]));
		}
		Collections.sort(list); //내림차순 정렬
		List<Integer> list2 = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<k-1; i++) {
			set.add(list.get(i).x);
		}
		List<Integer> arr2 = new ArrayList<>();
		for(int i=0; i<n; i++) {
			arr2.add(arr[i]);
			if(set.contains(i)) {
				arr2.add(0);
			}
		}
		int sum=0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int idx=0;
		
		for(int i=0; i<k; i++) {
			while(arr2.get(idx)!=0 && arr2.get(idx)<=arr[n-1]) {
				max = Math.max(max, arr2.get(idx));
				min = Math.min(min, arr2.get(idx));
				idx++;
				if(idx==arr2.size()) {
					break;
				}
			}
			idx++;
			if(max!=Integer.MIN_VALUE) {
				sum+=max-min;
			}
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
		}
		
		
		
		System.out.println(sum);
		
		
	}

}

class Node implements Comparable<Node>{
	int x; //인덱스
	int y; //cost
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return o.y-this.y;
	}
}
