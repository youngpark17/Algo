import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] aa,bb,cc,dd;
	static List<Integer> ab;
	static List<Integer> cd;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		aa = new int[n];
		bb = new int[n];
		cc = new int[n];
		dd = new int[n];
		ab = new ArrayList<>();
		cd = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			aa[i] = Integer.parseInt(st.nextToken());
			bb[i] = Integer.parseInt(st.nextToken());
			cc[i] = Integer.parseInt(st.nextToken());
			dd[i] = Integer.parseInt(st.nextToken());
		}
		Map<Integer,Integer> mp1 = new HashMap<>();
		Map<Integer,Integer> mp2 = new HashMap<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int tmp1 = aa[i]+bb[j];
				int tmp2= cc[i]+dd[j];
				mp1.put(tmp1,mp1.getOrDefault(tmp1, 0)+1);
				mp2.put(tmp2,mp2.getOrDefault(tmp2, 0)+1);
			}
		}
		long ans=0;
		for(int tmp : mp1.keySet()) {
			if(mp2.containsKey(tmp*(-1))){
				ans += mp1.get(tmp)*mp2.get(tmp*(-1));
			}
		}
		System.out.println(ans);
		
	}

}
