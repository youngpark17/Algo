import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int m,n,l;
	static List<Integer> mlist;
	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		mlist = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int v=0;
		for(int i=0; i<m; i++) {
			int t = Integer.parseInt(st.nextToken());
			if(t>v) {
				v=t;
			}
			mlist.add(t);
		}
		Collections.sort(mlist);
		int cnt=0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			if(y1<=l&&x1<v+l) {
				int s = 0;
				int e = mlist.size()-1;
				int start = x1-y1+l;
				int end = x1+y1-l;
				if(start>end) {
					int tmp = end;
					end = start;
					start = tmp;
				}
				while(s<=e) {
					int mid = (s+e)/2;
					int k = mlist.get(mid);
					if(k>=start && k<=end) {
						cnt++;
						break;
					}
					else if(k<start) {
						s=mid+1;
					}
					else {
						e=mid-1;
					}
					
				}
			}
		}
		System.out.println(cnt);
		
		
	}
	

}

class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
}
