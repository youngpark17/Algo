import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int k;
	static long[] arr;
	static long[] seg;
	static long[] lazy;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		3 3 2
//		-2
//		0
//		-1
//		1 1 3 -1
//		1 2 2 0
//		1 3 3 -2
//		2 1 1
//		2 3 3
		
		//output -3,-4
		
		//lazy propagation으로 바꾸자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new long[n];
		seg = new long[n*4];
		lazy = new long[n*4];
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		int total=m+k;
		init(0,n-1,1);
		while(total-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==1) {
				int b=Integer.parseInt(st.nextToken())-1;
				int c=Integer.parseInt(st.nextToken())-1;
				long d = Integer.parseInt(st.nextToken());
				update(0,n-1,1,b,c,d);
				
			}
			else {
				int b=Integer.parseInt(st.nextToken())-1;
				int c=Integer.parseInt(st.nextToken())-1;
				long tmp = sum(0,n-1,1,b,c);
				bw.append(tmp+"\n");
			}
		}
		bw.flush();
		bw.close();
		
	}
	
	public static long sum(int left, int right, int node, int start, int end) {
		if(lazy[node]!=0) {
			seg[node]+=(right-left+1)*lazy[node];
			if(left!=right) {
				lazy[node*2]+=lazy[node];
				lazy[node*2+1]+=lazy[node];
			}
			lazy[node]=0;
			
		}
		if(left>end || start>right) {
			return 0;
		}
		if(start<=left && right<=end) {
			return seg[node];
		}
		int mid=(left+right)/2;
		return sum(left,mid,node*2,start,end)+sum(mid+1,right,node*2+1,start,end);
	}
	
	public static void update(int left, int right, int node, int start, int end, long diff) {
		if(lazy[node]!=0) {
			seg[node]+=(right-left+1)*lazy[node];
			if(left!=right) {
				lazy[node*2]+=lazy[node];
				lazy[node*2+1]+=lazy[node];
			}
			lazy[node]=0;
		}
		if(left>end || start>right) {
			return;
		}
		if(start<=left && right<=end) {
			seg[node] +=(right-left+1)*diff;
			if(left!=right) {
				lazy[node*2]+=diff;
				lazy[node*2+1]+=diff;
			}
			return;
		}
		
		int mid = (left+right)/2;
		update(left,mid,node*2,start,end,diff);
		update(mid+1,right,node*2+1,start,end,diff);
		seg[node]=seg[node*2]+seg[node*2+1];
	}
	
	public static long init(int left, int right, int node) {
		if(left==right) {
			return seg[node]=arr[left];
		}
		int mid=(left+right)/2;
		return seg[node] = init(left,mid,node*2)+init(mid+1,right,node*2+1);
	}

}
