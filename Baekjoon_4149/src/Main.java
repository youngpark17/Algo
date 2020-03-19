import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static long n;
	static boolean[] visited;
	static List<Integer> list;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		list = new ArrayList<>();
		visited = new boolean[10000];
		for(int i=2; i<10000; i++) {
			if(!visited[i]) {
				list.add(i);
				for(int j=i*i; j<10000; j+=i) {
					visited[j] = true;
				}
			}
		}
		for(int k : list) {
			while(n%k==0) {
				System.out.println(k);
				n=n/k;
			}
		}
		
	}

}
