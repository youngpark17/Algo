import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n,q;
	static long[] arr, tree;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		arr = new long[n+1];
		tree = new long[n+1];
		//펜윅트리 사용하자ㅣ
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			update(i,arr[i]);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(q-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(x>y) { //y가 더 커야함.
				int tmp = x;
				x = y;
				y = tmp;
			}
			bw.append((query(y)-query(x-1))+"\n");
			update(a,-arr[a]);
			arr[a] = b;
			update(a,b);
		}
		bw.flush();
		bw.close();
		
		
		
		
	}
	
	public static void update(int x, long value) {
		while(x<n+1) {
			tree[x]+=value;
			x+=(x&-x);
		}
	}
	
	public static long query(int idx) {
		long ans=0;
		while(idx>0) {
			ans+=tree[idx];
			idx-=(idx&-idx);
		}
		return ans;
	}

}
