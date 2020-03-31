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
			String tmp = br.readLine();
			if(tmp.length()==1) { //인덱스 출력
				System.out.println(seg[1]+1);
			}
			else { //업데이트
				st = new StringTokenizer(tmp);
				st.nextToken();
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken());
				arr[from]=to;
				update(from,0,n-1,1);
				
			}
			
		}
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
