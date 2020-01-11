import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static Set<String> st = new HashSet<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		boolean[] visted= new boolean[n];
		int r = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=br.readLine();
		}
		per(arr,0,arr.length,r);
		System.out.println(st.size());
		
		
		
	}
	
	public static void per(String[] arr, int depth, int n, int r) {
		if(depth==r) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<r; i++) {
				sb.append(arr[i]);
			}
			st.add(sb.toString());
		}
		
		for(int i=depth; i<n; i++) {
			swap(arr,depth,i);
			per(arr,depth+1,n,r);
			swap(arr,i,depth);
		}
		
	}
	
	public static void swap(String[] arr, int i, int j) {
		String tmp = arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
		
	}

}
