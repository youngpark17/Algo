import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int last_ans;
	static List[] seg;
	static int[] arr;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		seg = new List[n*4];
		for(int i=0; i<n*4; i++) {
			seg[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		makeSeg(0,n-1,1);
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int i = a^last_ans;
			int j = b^last_ans;
			int k = c^last_ans;
			last_ans=get(0,n-1,k,i-1,j-1,1);
			bw.append(last_ans+"\n");
		}
		bw.flush();
		bw.close();
		
		
	}
	
	public static int get(int left, int right, int k, int start, int end, int node) {
		if(left>end || right<start) {
			return 0;
		}
		if(start<=left && right<=end) {
			int t  = seg[node].size()-binarySearch(seg[node], k);
			return t;
		}
		int mid = (left+right)/2;
		return get(left,mid,k,start,end,node*2)+get(mid+1,right,k,start,end,node*2+1);
	}
	
	public static int binarySearch(List<Integer> list,int k) {
		int left = 0;
		int right=list.size();
		int mid=0;
		while(left<right) {
			mid=(left+right)/2;
			if(k<list.get(mid)) {
				right=mid;
			}
			else {
				left=mid+1;
			}
		}
		return right;
	}
	
	public static List<Integer> makeSeg(int left, int right, int node) {
		if(left==right) {
			seg[node].add(arr[left]);
			return seg[node];
		}
		int mid = (right+left)/2;
		List<Integer> n1 = makeSeg(left,mid,node*2);
		List<Integer> n2 = makeSeg(mid+1,right,node*2+1);
		List<Integer> list = new ArrayList<>();
		boolean flag1=false;
		boolean flag2=false;
		int idx1=0;
		int idx2=0;
		while(!flag1 && !flag2) {
			if(n1.get(idx1)<=n2.get(idx2)) {
				list.add(n1.get(idx1++));
				if(idx1==n1.size()) {
					flag1=true;
					while(flag1 && !flag2) {
						list.add(n2.get(idx2++));
						if(idx2==n2.size()) {
							flag2=true;
						}
					}
				}
			}
			else {
				list.add(n2.get(idx2++));
				if(idx2==n2.size()) {
					flag2=true;
					while(!flag1 && flag2) {
						list.add(n1.get(idx1++));
						if(idx1==n1.size()) {
							flag1=true;
						}
					}
				}
			}
		}
		return seg[node] = list;
		
	}

}
