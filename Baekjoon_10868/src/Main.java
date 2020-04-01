import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static int[] seg;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr= new int[n];
		seg = new int[n*4];
		m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		makeSeg(0,n-1,1);
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int tmp = get(0,n-1,1,a,b);
			bw.append(tmp+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int get(int left, int right, int node, int start, int end) {
		if(left>end || start>right) {
			return (1<<31)-1;
		}
		
		if(start<=left && right<=end) {
			return seg[node];
		}
		int mid=(left+right)/2;
		return Math.min(get(left,mid,node*2,start,end),get(mid+1,right,node*2+1,start,end));
	}
	
	public static int makeSeg(int left, int right, int node) {
		if(left==right) {
			return seg[node] = arr[left];
			
		}
		int mid=(left+right)/2;
		int k= makeSeg(left,mid,node*2);
		int k2= makeSeg(mid+1,right,node*2+1);
		if(k==0) {
			return seg[node]=k2;
		}
		if(k2==0) {
			return seg[node]=k;
		}
		return seg[node]=Math.min(k,k2);
	}

}

