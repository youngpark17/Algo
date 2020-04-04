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
	static int[] tree2; //����Ÿ���϶� ���̴� Ʈ��.
	static int cnt=0;
	static boolean flag; //�Ϲݱٹ����ϋ� false ����Ÿ���϶� true
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new List[n+1];
		tree = new int[n+1];
		tree2 = new int[n+1];
		in = new int[n+1];
		out = new int[n+1];
		flag=false;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=1; i<=n; i++) {
			if(i==1) {
				st.nextToken();
				continue;
			}
			list[Integer.parseInt(st.nextToken())].add(i); //���� ��簡 �ڽ����� �ִ�.
		}
		dfs(1);
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==3) {
				flag=!flag;
			}
			else if(a==1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if(!flag) { //in[x]���� out[x]���� ���� ����. 
					update(tree,in[b],c);
					update(tree,out[b]+1,-c);
				}
				else {//���� Ÿ���϶� in[b]
					update(tree2,in[b],c);
				}
			}
			else {
				int x = Integer.parseInt(st.nextToken());
				int a1 = get(tree2,out[x])-get(tree2,in[x]-1);
				int a2 = get(tree,in[x]);
				bw.append(a1+a2+"\n");
			}
			
		}
		bw.flush();
		bw.close();
		
	}
	
	public static void update(int[] arr,int x, int w) {
		while(x<=n) {
			arr[x]+=w;
			x+=(x&-x);
		}
	}
	public static int get(int[] arr, int x) {
		int ans=0;
		while(x>0) {
			ans+=arr[x];
			x-=(x&-x);
		}
		return ans;
	}
	
	public static void dfs(int k) {
		in[k]=++cnt;
		for(int k1: list[k]) {
			dfs(k1);
		}
		out[k]=cnt;
	}

}
