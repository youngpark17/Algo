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
		makeSeg(0,n-1,1);
		m = Integer.parseInt(br.readLine());
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==2) { //인덱스 출력
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				int an = get(0,n-1,1,from,to)+1;
				bw.append(an+"\n");
			}
			else { //업데이트
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken());
				arr[from]=to;
				update(from,0,n-1,1);
				
			}
			
		}
		bw.flush();
		bw.close();
	}
	
	public static int get(int left, int right, int node, int start, int end) {
		//start랑 end는 고정값, 구하는 범위
		if(start>right || left>end) {
			return -1;
		}
		if(left>=start && right<=end) {
			return seg[node];
		}
		int mid = (left+right)/2;
		int idx1 = get(left,mid,node*2,start,end);
		int idx2 = get(mid+1,right,node*2+1,start,end);
		if(idx1<0) {
			return idx2;
		}
		if(idx2<0) {
			return idx1;
		}
		if(arr[idx1]==arr[idx2]) {
			return Math.min(idx1, idx2);
		}
		else if(arr[idx1]<arr[idx2]) {
			return idx1;
		}
		return idx2;
	}
	
	public static void update(int fixIndex,int left, int right, int node) {
		if(fixIndex<left || fixIndex>right) {
			return;
		}
		if(left==right) {
			seg[node] = fixIndex;
			return;
		}
		int mid = (left+right)/2;
		update(fixIndex,left,mid,node*2);
		update(fixIndex,mid+1,right,node*2+1);
		//끝까지 내려갔다가 올라오면서 바꾸자.
		if(arr[seg[node*2]]==arr[seg[node*2+1]]) {
			seg[node] = Math.min(seg[node*2], seg[node*2+1]);
		}
		else if(arr[seg[node*2]]<arr[seg[node*2+1]]) {
			seg[node] = seg[node*2];
		}
		else {
			seg[node] = seg[node*2+1];
		}
		
	}
	
	public static int makeSeg(int left, int right,int node) {
		if(left==right) {
			return seg[node] = left;
		}
		int mid= (left+right)/2;
		int idx1 = makeSeg(left,mid,node*2);
		int idx2 = makeSeg(mid+1,right,node*2+1);
		if(arr[idx1]==arr[idx2]) {
			return seg[node] = Math.min(idx1, idx2);
		}
		else if(arr[idx1]<arr[idx2]) {
			return seg[node] = idx1;
		}
		else {
			return seg[node] = idx2;
		}
	}

}
