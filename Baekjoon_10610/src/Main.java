import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split("");
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<a.length; i++) {
			list.add(Integer.parseInt(a[i]));
		}
		if(!list.contains(0)) {
			System.out.println(-1);
			System.exit(0);
		}
		int sum = 0;
		for(int k : list) {
			sum+=k;
		}
		if(sum%3!=0) {
			System.out.println(-1);
			System.exit(0);
		}
		else {
			Collections.sort(list);
			Collections.reverse(list);
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<list.size(); i++) {
				sb.append(list.get(i));
			}
			System.out.println(sb.toString());
			
		}
		
		
		
	}
	
}
