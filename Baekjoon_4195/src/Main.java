import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int n;
	static Map<String,String> map;
	static Map<String,Integer> value;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(T-->0) {
			n  = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			value = new HashMap<>();
			while(n-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				if(!map.containsKey(s1)) {
					map.put(s1, s1);
					value.put(s1,1);
				}
				if(!map.containsKey(s2)) {
					map.put(s2, s2);
					value.put(s2,1);
				}
				union(s1,s2);
			}
		}
		bw.flush();
		bw.close();
	}
	
	public static String find(String s) {
		if(s.equals(map.get(s))) {
			return s;
		}
		String p = find(map.get(s));
		map.put(s, p);
		return p;
	}
	
	public static void union(String s1, String s2) throws Exception {
		String p1 = find(s1);
		String p2 = find(s2);
		int k = p1.compareTo(p2);
		//k가 양수면 p1이 더 큰거
		if(k<0) {
			String tmp = p1;
			p1 = p2;
			p2 = tmp;
		}
		//항상 p1이 더 큼.
		//p1이 부모
		if(p1.equals(p2)) {
			bw.append(value.get(p1)+"\n");
			return;
		}
		int t = value.get(p1)+value.get(p2);
		value.put(p2, 0);
		bw.append(t+"\n");
		value.put(p1, t);
		map.put(p2, p1);
	}

}
