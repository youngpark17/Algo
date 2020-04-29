import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] tree;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		while(n!=0) {
			arr = new int[n];
			tree = new int[4*n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			makeSeg(0,n-1,1);
			long area = getMaxArea(0, n-1);
			bw.append(area+"\n");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
		}
		bw.flush();
		bw.close();
		
		
	}
	
	public static long getMaxArea(int start, int end) {
		int minIdx = getMinIndex(0,n-1,1,start, end);
		
		//minIdx 기준으로 왼쪽, 오른쪽 탐색하자.
		//일단 넓이 구해놓자.
		long area = (long)arr[minIdx]*(long)(end-start+1);
		if(start<=minIdx-1) {
			long tmp = getMaxArea(start, minIdx-1);
			area = Math.max(tmp, area);
			
		}
		
		if(minIdx+1<=end) {
			long tmp = getMaxArea(minIdx+1, end);
			area = Math.max(tmp, area);
		}
		return area;
	}
	
	public static int getMinIndex(int left, int right, int node, int start, int end) {
		if(start>right || end<left) {
			return -1;
		}
		if(left>=start && right<=end) {
			return tree[node];
		}
		int mid=(left+right)/2;
		int leftIdx=getMinIndex(left, mid, node*2, start, end);
		int rightIdx=getMinIndex(mid+1, right, node*2+1, start, end);
		
		if(rightIdx==-1) {
			return leftIdx;
		}
		if(leftIdx==-1) {
			return rightIdx;
		}
		//높이가 더 작은 Idx 반환.
		return arr[leftIdx]<=arr[rightIdx]? leftIdx : rightIdx;
	}	
	
	public static void makeSeg(int left, int right, int node) {
		//구간에 대한 높이의 최소값을 가지는 arr의 인덱스
		if(left==right) {
			tree[node] = left;
			return;
		}
		int mid = (left+right)/2;
		makeSeg(left,mid,node*2);
		makeSeg(mid+1,right,node*2+1);
		if(arr[tree[node*2]]<=arr[tree[node*2+1]]) {
			tree[node] = tree[node*2];
		}
		else {
			tree[node] = tree[node*2+1];
		}
		
	}

}
