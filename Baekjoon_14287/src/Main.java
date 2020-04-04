import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static List<Integer>[] list;
	static int[] in;
	static int[] out;
	static int[] tree;
	static int cnt=0;
	static int length;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new List[n+1];
		in = new int[n+1];
		out = new int[n+1];
		length = (int) Math.pow(2, ((int)(Math.log10(n)/Math.log10(2)))+1);
		
		tree = new int[length+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=1; i<=n; i++) {
			if(i==1) {
				st.nextToken();
				continue;
			}
			list[Integer.parseInt(st.nextToken())].add(i); //직속 상사가 자식으로 있다.
		}
		dfs(1);
		//out[i]가 자기와 같거나 자기보다 느림. in[i]는 자기보다 낮음. 업데이트
		//처음에 갈굼당한 수치는 0 부하가 상사 갈굼. 
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			if(v==1) {
				int i = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				update(in[i],w);
			}
			else if(v==2){
				int i = Integer.parseInt(st.nextToken());
				bw.append(get(out[i])-get(in[i]-1)+"\n"); //트리는 
			}
		}
		bw.flush();
		bw.close();
		
	}
	
	public static long get(int k) {
		long ans=0;
		while(k>0) {
			ans+=tree[k];
			k-=(k&-k);
		}
		return ans;
	}
	public static void update(int k, int w) {
		while(k<=length) {
			tree[k]+=w;
			k+=(k&-k);
		}
	}
	
	public static void dfs(int k) {
		in[k]=++cnt;
		for(int k1 : list[k]) {
			dfs(k1);
		}
		out[k]=cnt;
	}
	



}
