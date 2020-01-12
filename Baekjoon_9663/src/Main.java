import java.util.Scanner;

public class Main {
	static int[] visited;
	
	static int n;
	static int cnt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n  = sc.nextInt();
		visited = new int[n+1];
		cnt=0;
		for(int i=0; i<n; i++) {
			visited[0] = i;  // 0��°���� i��°���� �����ϰ� �ִ�.
			dfs(i,0); //i���� ���� ���̻� �������.
		}
		System.out.println(cnt);
		
		
	}
	
	public static void dfs(int a, int depth ) { //a�� Ž���Ϸ��� �� depth�� ��.
		
		for(int i=0; i<depth; i++) {
			if(visited[i] == a ||Math.abs(a-visited[i])==depth-i) { //���� ��ġ�� �밢�� ���� �Ǵ�, Ž���Ϸ��� ������ i��° �࿡ ���ִ� ��
				return;											//�� ������ ��
			}
		}
		
		if(depth==n-1) {
			cnt++;
			return;
		}
		for(int i=0; i<n; i++) {
			visited[depth+1]=i;
			dfs(i,depth+1);
		}
		
	}

}
