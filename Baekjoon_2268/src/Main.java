import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static long[] tree;
	static long[] arr;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		tree = new long[n+1];
		arr = new long[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==0) {
				if(b>c) {
					int t= b;
					b=c;
					c=t;
				}
				bw.append((sum(c)-sum(b-1))+"\n");
			}
			else {
				long diff = (long)c-(arr[b]);
				update(b,diff);
				arr[b] = c;
			}
		}
		bw.flush();
		bw.close();
	}
	public static void update(int x, long v) {
		while(x<n+1) {
			tree[x]+=v;
			x+=(x&-x);
		}
	}
	public static long sum(int x) {
		long ret=0;
		while(x>0) {
			ret += tree[x];
			x-=(x&-x);
		}
		return ret;
	}

}
