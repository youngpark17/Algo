import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[] arr;
	static long[] seg;
	static long[] lazy;
	static int m;
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		seg= new long[n*4];
		arr = new long[n*4];
		lazy = new long[n*4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		seg(0,n-1,1);
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			if(a==1) {
				int i = Integer.parseInt(st.nextToken())-1;
				int j = Integer.parseInt(st.nextToken())-1;
				int k = Integer.parseInt(st.nextToken());
				
				update(0,n-1,k,i,j,1);
			}
			else {
				int x = Integer.parseInt(st.nextToken())-1;
				long tmp = get(0,n-1,1,x,x);
				bw.append(tmp+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	public static long get(int left, int right, int node, int start, int end) {
		if(lazy[node]!=0) {
			seg[node]+=(right-left+1)*lazy[node];
			if(left!=right) {
				lazy[node*2]+=lazy[node];
				lazy[node*2+1]+=lazy[node];
			}
			lazy[node]=0;
		}
		if(left>end || right<start) {
			return 0;
		}
		if(start<=left && right<=end) {
			return seg[node];
		}
		int mid = (left+right)/2;
		return get(left,mid,node*2,start,end)+get(mid+1,right,node*2+1,start,end);
	}
	
	public static void update(int left, int right, long k, int start, int end, int node) {
		if(lazy[node]!=0) {
			seg[node] +=(right-left+1)*lazy[node];
			if(left!=right) { //밑에도 자식이 있는거니까
				lazy[node*2] += lazy[node];
				lazy[node*2+1] += lazy[node];
			}
			//자신에게 전파시켰으니까 본인은 0
			lazy[node]=0;
		}
		if(left> end || right<start) {
			return;
		}
		
		if(start<=left && right<=end) {
			seg[node] +=(right-left+1)*k;
			if(left!=right) {
				lazy[node*2]+=k;
				lazy[node*2+1]+=k;
			}
			return;
		}
		
		
		int mid = (left+right)/2;
		update(left,mid,k,start,end,node*2);
		update(mid+1,right,k,start,end,node*2+1);
		//구간에 대한 대표합 다시 업데이트
		seg[node]=seg[node*2]+seg[node*2+1];
	}
	public static long seg(int left, int right, int node) {
		if(left==right){
			return seg[node]=arr[left];
		}
		int mid = (left+right)/2;
		return seg[node] = seg(left,mid,node*2)+seg(mid+1,right,node*2+1);
	}

}
