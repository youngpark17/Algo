import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int t,n,m;
	static int[] a;
	static int[] b;
	static long[] sa;
	static long[] sb;
	static Map<Long,Long> mp1;
	static Map<Long,Long> mp2;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//정올 사이트에서는 성공코드...
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		a = new int[n+1];
		sa = new long[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			sa[i] = sa[i-1]+a[i];
		}
		m = Integer.parseInt(br.readLine());
		b = new int[m+1];
		sb = new long[m+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<m+1; i++) {
			b[i] = Integer.parseInt(st.nextToken());
			sb[i] = sb[i-1]+b[i];
		}
		mp1 = new HashMap<>();
		mp2 = new HashMap<>();
		for(int i=n; i>0; i--) {
			for(int j=i-1; j>=0; j--) {
				long tmp = sa[i]-sa[j];
				if(mp1.containsKey(tmp)) {
					mp1.put(tmp, mp1.get(tmp)+1);
				}
				else {
					mp1.put(tmp, (long) 1);
				}
			}
		}
		for(int i=m; i>0; i--) {
			for(int j=i-1; j>=0; j--) {
				long tmp = sb[i]-sb[j];
				if(mp2.containsKey(tmp)) {
					mp2.put(tmp, mp2.get(tmp)+1);
				}
				else {
					mp2.put(tmp, (long) 1);
				}
			}
		}
		long ans=0;
		for(Long tmp : mp1.keySet()) {
			long find = t-tmp;
			if(mp2.containsKey(find)) {
				ans+=(mp2.get(find)*mp1.get(tmp));
			}
		}

		bw.append(ans+"");
		bw.flush();
		bw.close();



	}


	

}
