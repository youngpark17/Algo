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
	static int cnt=0;
	static int[] tree;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		list = new List[n+1];
		tree= new int[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		in = new int[n+1];
		out = new int[n+1];
		for(int i=1; i<=n; i++) {
			if(i==1) {
				st.nextToken();
				continue;
			}
			list[Integer.parseInt(st.nextToken())].add(i); //입력으로 들어오는 값에 대한 부하직원은 i
		}
		dfs(1); //1이 root
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==1) { // b직원이 상사한테 c만큼 갈굼 받는다.
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				update(in[b],c);
				update(out[b]+1,-c);
				//이렇게 할 경우 이 노드를 포함하고 있는 구간에대해서만 업데이트 되기때문에
				//get을 했을때 
			}
			else {
				int b = Integer.parseInt(st.nextToken());
				//in[b]
				bw.append(get(in[b])+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	
	public static int get(int k) {
		int ans=0;
		while(k>0) {
			ans+=tree[k];
			k-=(k&-k);
		}
		return ans;
	}
	
	public static void update(int k, int w) {
		//k위로 다 업데이트
		while(k<=n) {
			tree[k]+=w;
			k+=(k&(-k));
		}
	}
	public static void dfs(int k) {
		in[k]=++cnt; //트리 형태로 들어오므로 visited 체크할 필요없음.
		//k의 자식은 k보다 in[k]의 값이 크며, out[k]의 값이 작거나 같다.
		//-> in[k]기준으로 같거나 큰거 다 트리에 더하고 out[k]기준으로 큰거는 부모니까 빼자.
		for(int k1 : list[k]) {
			dfs(k1);
		}
		out[k]=cnt;
	}

}
