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
			list[Integer.parseInt(st.nextToken())].add(i); //�Է����� ������ ���� ���� ���������� i
		}
		dfs(1); //1�� root
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==1) { // b������ ������� c��ŭ ���� �޴´�.
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				update(in[b],c);
				update(out[b]+1,-c);
				//�̷��� �� ��� �� ��带 �����ϰ� �ִ� ���������ؼ��� ������Ʈ �Ǳ⶧����
				//get�� ������ 
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
		//k���� �� ������Ʈ
		while(k<=n) {
			tree[k]+=w;
			k+=(k&(-k));
		}
	}
	public static void dfs(int k) {
		in[k]=++cnt; //Ʈ�� ���·� �����Ƿ� visited üũ�� �ʿ����.
		//k�� �ڽ��� k���� in[k]�� ���� ũ��, out[k]�� ���� �۰ų� ����.
		//-> in[k]�������� ���ų� ū�� �� Ʈ���� ���ϰ� out[k]�������� ū�Ŵ� �θ�ϱ� ����.
		for(int k1 : list[k]) {
			dfs(k1);
		}
		out[k]=cnt;
	}

}
