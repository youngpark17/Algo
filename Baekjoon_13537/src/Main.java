import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static List[] seg;
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		seg = new List[n*4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<4*n; i++) {
			seg[i] = new ArrayList<>();
		}
		m = Integer.parseInt(br.readLine());
		makeSeg(0,n-1,1);
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			//구간 a,b를 대표하는 값?
			
			int k = Integer.parseInt(st.nextToken());
			int t = get(0,n-1,1,a,b,k);
			bw.append(t+"\n");
			
		}
		bw.flush();
		bw.close();
		

	}
	//start end 시작 끝 인덱스
	//left right 구간합을 구하고자 하는 범위
	public static int get(int start, int end, int node, int left, int right, int k) {
		if(left>end || right<start) {
			return 0;
		}
		if(left<=start && end<=right) {
			//구하고자 하는 범위가 node가 가리키는 범위에 포함될 경우
			int idx = Collections.binarySearch(seg[node], k);
			if(idx<0) {
				// 없다면 들어가야 할 자리가 size와 같거나 더 크면
				//return0
				//아니면 size-1 idx;
				idx = Math.abs(idx)-1;
				if(idx>=seg[node].size()) {
					return 0;
				}
				else {
					return seg[node].size()-idx;
				}
			}
			
			return seg[node].size()-(idx+1);
			
		}
		int mid = (start+end)/2;
		return get(start,mid,node*2,left,right,k)+get(mid+1,end,node*2+1,left,right,k);
		
	}
	

	public static List makeSeg(int left, int right, int node) {
		if(left==right) {
			seg[node].add(arr[left]);
			return seg[node];
		}
		int mid = (left+right)/2;
		List<Integer> list1 = makeSeg(left,mid,node*2);
		List<Integer> list2 = makeSeg(mid+1,right,node*2+1);
		int idx=0;
		int idx2=0;
		boolean flag1=false;
		boolean flag2 = false;
		while(!flag1 || !flag2) {
			int a = list1.get(idx);
			int b = list2.get(idx2);
			if(a<=b &&!flag1) {
				seg[node].add(a);
				idx++;
				if(idx==list1.size()) {
					flag1=true;
					while(idx2<list2.size()) {
						seg[node].add(list2.get(idx2++));
						flag2=true;
					}
				}
			}
			else if(!flag2){
				seg[node].add(b);
				idx2++;
				if(idx2==list2.size()) {
					flag2=true;
					while(idx<list1.size()) {
						seg[node].add(list1.get(idx++));
						flag1=true;
					}
				}
			}
		}
		
		return seg[node];
		
	}
	
	public static int search(List<Integer> list, int k) {
		int left=0;
		int right=list.size()-1;
		int mid=0;
		while(left!=right) {
			mid=(left+right)/2;
			if(k>=mid) {
				left=mid+1;
			}
			else {
				right=mid;
			}
		}
		return mid;
	}
	


}
