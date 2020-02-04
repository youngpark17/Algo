import java.util.Scanner;

public class Main {
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[n];
		visited=new boolean[n];
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		comb(n,0,0,m);
		
	}
	
	public static void comb(int N,int d, int c,int r) {
		if(c==r) {
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
		}
		else {
			for(int i=d; i<N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					comb(N,i+1,c+1,r);
					visited[i] = false;
				}
			}
		}
	}

}
