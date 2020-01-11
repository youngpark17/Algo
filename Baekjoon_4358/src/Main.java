import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String tmp ="";
		double cnt=0;
		Map<String,Integer> mp = new HashMap<>();
		Set<String> st = new HashSet<>();
		
		while((tmp=br.readLine())!=null &&tmp.length()!=0) {
			cnt++;
			if(mp.containsKey(tmp)) {
				int k= mp.get(tmp)+1;
				mp.put(tmp,k);
			}
			else {
				st.add(tmp);
				mp.put(tmp, 1);
			}
			
		}
		String[] arr= new String[st.size()];
		Iterator it = st.iterator();
		int t=0;
		while(it.hasNext()) {
			arr[t++] = (String)it.next();
		}
		
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			double p = (Math.round((mp.get(arr[i])/cnt)*1000000))/10000.0;
			bw.append(arr[i]+" "+String.format("%.4f", p)+"\n");
		}
		
		bw.flush();
		bw.close();
		

	}

}
