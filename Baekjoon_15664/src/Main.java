import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	static int n;
	static int r;
	static BufferedWriter bw;
	static Set<String> set;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n];
		visited = new boolean[n];
		output = new int[n];
		set = new LinkedHashSet<>();
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		per(0,n,r);
		for(String s : set) {
			System.out.println(s);
		}
		
//		Iterator it = set.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
	}
	
	public static void per(int depth, int n, int r) {
		if(depth==r) {
			String s="";
			s+=output[0]+" ";
			for(int i=1; i<r; i++) {
				if(output[i-1]>output[i]) {
					return;
				}
				s+=output[i]+" ";
			}
			set.add(s);
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i]=true;
				output[depth] = arr[i];
				per(depth+1,n,r);
				visited[i]=false;
			}
		}
		
		
		
	}
	
	

}
