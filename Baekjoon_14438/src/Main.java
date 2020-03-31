import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int[] seg;
	static int m;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		seg = new int[n*4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		makeSeg(0,n-1,1);
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			if(v==1) {
				int i = Integer.parseInt(st.nextToken())-1;
				int k = Integer.parseInt(st.nextToken());
				arr[i]=k;
				update(i,0,n-1,1);
			}
			else {
				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken())-1;
				int t = get(0,n-1,1,start,end);
				bw.append(t+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	public static int get(int left, int right, int node, int start, int end) {
		if(left>end || start>right) {
			return -1;
		}
		if(left>=start && end>=right) { //포함되고있어야지...
			return seg[node];
		}
		int mid =(left+right)/2;
		int a1 = get(left,mid,node*2,start,end);
		int a2 = get(mid+1,right,node*2+1,start,end);
		if(a1==-1) {
			return a2;
		}
		if(a2==-1) {
			return a1;
		}
		return Math.min(a1, a2);
		
	}
	
	public static void update(int idx, int left, int right, int node) {
		if(left>idx || right<idx) {
			return;
		}
		if(left==right) {
			seg[node]=arr[idx];
			return;
		} 
		int mid=(left+right)/2;
		update(idx,left,mid,node*2);
		update(idx,mid+1,right,node*2+1);
		//끝까지 간다음에
		seg[node] = Math.min(seg[node*2], seg[node*2+1]);
	}
	
	public static int makeSeg(int left, int right, int node) {
		if(left==right) {
			return seg[node] = arr[left];
		}
		int mid = (left+right)/2;
		int a = makeSeg(left,mid,node*2);
		int b = makeSeg(mid+1,right,node*2+1);
		return seg[node] = Math.min(a, b);
	}

}
