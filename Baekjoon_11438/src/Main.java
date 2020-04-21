import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static boolean[] visited;
	static int[] nodeDepth;
	static int[][] parents;
	static List<Integer>[] list;
	static int k;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		list = new List[n];
		nodeDepth = new int[n];	
		k = (int)Math.ceil((Math.log10(n)/Math.log10(2))); //��尡 15���̸� �־��ǰ��0 1 2 4 8(�������̸�) 
		parents = new int[n][k]; //parents[node][i]���� i�� node�� 2^i��° ����.
		visited = new boolean[n];
		
			
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList();
		}
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			list[a].add(b);
			list[b].add(a);
		}

		setParent();
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int k= lca(a,b)+1;
			bw.append(k+"\n");
		}
		bw.flush();
		bw.close();
		
		
		
		
		
	}
	
	public static int lca(int a, int b) {
		if(nodeDepth[a]<nodeDepth[b]) {//a�� �� depth ŭ. a�� �� �Ʒ�������. 
			int tmp=b;
			b=a;
			a=tmp; 
		}
		for(int i=k; i>=0; i--) { //depth ������
			if(nodeDepth[a]-nodeDepth[b]>=(1<<i)) {
				a = parents[a][i];
			}
		}
		if(a==b) { //���� ���ٸ� �̰� �θ��
			return a;
		}
		for(int i=k-1; i>=0; i--) {
			if(parents[a][i]!=parents[b][i]) { // ���� ����µ� �ٸ��ٸ� ��� �Ž��� �ö���.
				a= parents[a][i];
				b= parents[b][i];
			}
			
		}
		return parents[a][0];
	}
	
	public static void setParent() {
		dfs(0,0); //1���� ��Ʈ��.
		for(int j=1; j<k; j++) {
			for(int i=0; i<n; i++) {
				parents[i][j] = parents[parents[i][j-1]][j-1]; //i�� node�� 2^j��° �θ�� i��° node�� 2^(j-1)��° �θ��� 2^(j-1)��°�θ�
				//2^(j-1)+2^(j-1)�� 2^j�̹Ƿ�
				
			}
		}
		
	}
	
	public static void dfs(int node, int depth) {
		visited[node] = true;
		nodeDepth[node] =depth;
		for(int k : list[node]) {
			if(!visited[k]) {
				parents[k][0] = node;
				dfs(k,depth+1);
			}
		}
		
	}

}
