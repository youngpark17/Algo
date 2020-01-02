import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[] parent;
	static int[] depth;
	static ArrayList<Integer>[] list;
	static int n;
	static int m;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList();
		}
		
		
		for(int i=0; i<n-1; i++) {
			String[] tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			list[a].add(b);
			list[b].add(a);
		}
		
		int start = 1; // ��Ʈ 1��
		parent = new int[n+1];
		depth = new int[n+1];
		
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		parent[start]=start;
		depth[start]=start;
		while(!que.isEmpty()) {
			
			int from = que.poll();
			
			for(int to : list[from]) {
				if(parent[to]==0) { //�θ� ������ �ȵǾ������� 
					que.add(to); //���� ����� �ڽĵ� �� ����.
					parent[to]=from;
					depth[to]=depth[from]+1;
					
				}
			}
		}
		
		m= Integer.parseInt(br.readLine());
		while(m-- > 0) {
			String[] tmp = br.readLine().split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			int temp;
			if(depth[y]>depth[x]) { //y�� x���� ���̰� ������
				temp=y;
				y=x;
				x=temp; //���̰� ���� ���� x�� �ٲ�. x�� ���̰� �� ŭ.
			}
			
			while(depth[x]!=depth[y]) { //���� ���̰� �ɶ����� x�� �ø�.
				x=parent[x];
			}
			
			if(x==y) { //���̰� ����������  ������
				System.out.println(x);
			}
			else {
				while(parent[x]!=parent[y]) { //���̰� ������ �θ� �ٸ��� ���������� �Ž��� �ö�
					x=parent[x];
					y=parent[y];
				}
				System.out.println(parent[x]);
			}
		}
		
	
		
	}
	


}
