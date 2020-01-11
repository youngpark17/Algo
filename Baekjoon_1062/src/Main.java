import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	//¸øÇ°
	static int max;
	static int n;
	static int k;
	static char[] arr = {'b','d','e','f','g','h','j','k','l','m','o','p','q','r','s','t','u','v','w','x','y','z'};
	static int realk;
	static boolean[] visited;
	static String[] tmp2;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		max=0;
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		k = Integer.parseInt(tmp[1]);
		realk = k-5; //a n t c i ¸¦ –A ¤©¤· k
		visited = new boolean[arr.length];
		tmp2 = new String[n];
		Set<Character>[] st = new Set[n];
		for(int i=0; i<n; i++) {
			tmp2[i]=br.readLine();
			tmp2[i]=tmp2[i].substring(4, tmp2[i].length()-4);
			st[i] = new HashSet<>();
			for(Character p : (Character[])st[i].toArray()) {
				st[i].add(p);
			}
		}
		
		
		
	}
	
	public static void combination(int d,int n, int r) {
		
		if(r==0) {
			for(int i=0; )
		}
		
		if(d==n) {
			return;
		}
		for(int i=d; i<n; i++) {
			visited[d]=true;
			combination(d+1,n,r-1);
			visited[d]=false;
			combination(d+1,n,r);
			
		}
		
	}
	
	public static void swap(int i, int j) {
		char tmp = arr[i];
		arr[j]=tmp;
		arr[j]=tmp;
	}

}
