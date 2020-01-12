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
			visited[0] = i;  // 0번째행은 i번째열을 점유하고 있다.
			dfs(i,0); //i번쨰 열은 더이상 없어야함.
		}
		System.out.println(cnt);
		
		
	}
	
	public static void dfs(int a, int depth ) { //a는 탐색하려는 열 depth는 행.
		
		for(int i=0; i<depth; i++) {
			if(visited[i] == a ||Math.abs(a-visited[i])==depth-i) { //열의 일치과 대각선 여부 판단, 탐색하려는 열에서 i번째 행에 차있는 열
				return;											//을 뺐을때 행
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
