import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static Node[] seg;
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr=new int[n];
		seg = new Node[n*4];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		makeSeg(0,n-1,1);
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			Node t = get(0,n-1,1,a,b);
			bw.append(t.min+" "+t.max+"\n");
			
		}
		
		bw.flush();
		bw.close();
		
		
		
	}
	
	public static Node get(int left, int right, int node, int start, int end) {
		if(left>end || right<start) {
			return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE);
		}
		if(start<=left && right<=end) {
			return seg[node];
		}
		int mid = (left+right)/2;
		Node n1 = get(left,mid,node*2,start,end);
		Node n2 = get(mid+1,right,node*2+1,start,end);
		int min = Math.min(n1.min, n2.min);
		int max = Math.max(n1.max, n2.max);
		return new Node(min,max);
	}
	
	public static Node makeSeg(int left, int right, int node) {
		if(left==right) {
			return seg[node] = new Node(arr[left],arr[left]);
		}
		int mid=(left+right)/2;
		Node n1 = makeSeg(left,mid,node*2);
		Node n2 = makeSeg(mid+1,right,node*2+1);
		int min = Math.min(n1.min, n2.min);
		int max = Math.max(n1.max, n2.max);
		Node t = new Node(min,max);
		return seg[node]=t;
		
	}

}

class Node{
	int min;
	int max;
	
	Node(int x, int y){
		this.min=x;
		this.max=y;
	}
}
