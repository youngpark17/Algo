import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int k;
	static long[] tree;
	static long[] arr;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k= Integer.parseInt(st.nextToken());
		tree = new long[4*(n+1)];
		arr = new long[n+1];
		Arrays.fill(tree, 1);
		for(int i=1; i<=n; i++) {
			int a = Integer.parseInt(br.readLine());
			arr[i] = a; //변경을 위해 저장
		}
		
		init(1,n,1);
		for(int i=0; i<m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==1) { //b번째 수를 c로 변경
				arr[b]=c;
				update(1,n,b,1); //b를 포함하고 있는 구간에 대해 업데이트하자.
			}
			else {
				//b부터 c까지의곱
				long ans = get(1,n,1,b,c);
				bw.append(ans+"\n");
			}
			
		}
		bw.flush();
		bw.close();
		
	}
	public static long get(int left,int right, int node, int start, int end) {
		if(start>right || end<left) {
			return 1;
		}
		if(start<=left && right<=end) {
			return tree[node];
		}
		int mid = (left+right)/2;
		return (get(left,mid,node*2,start,end)*get(mid+1,right,node*2+1,start,end))%1_000_000_007;
	}
	public static void update(int left, int right, int idx, int node) {
		if(idx<left || idx>right) {
			return;
		}
		if(left==right) {
			tree[node]=arr[idx];
			return;
		}
		if(idx>=left && idx<=right) {
			int mid = (right+left)/2;
			update(left,mid,idx,node*2);
			update(mid+1,right,idx,node*2+1);
			tree[node] = (tree[node*2]*tree[node*2+1])%1_000_000_007;
		}
		
	}
	
	public static long init(int left, int right, int node) {
		if(left==right) {
			return tree[node]=arr[left];
		}
		
		int mid = (left+right)/2;
		return tree[node] = (init(left,mid,node*2)*init(mid+1,right,node*2+1))%1_000_000_007;
	}
	
	

}
