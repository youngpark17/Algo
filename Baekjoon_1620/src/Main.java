import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static int n;
	static int m;
	static String[] arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		arr = new String[n];
		Map<String, Integer> mp = new HashMap<>();
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
			mp.put(arr[i],i+1);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<m; i++) {
			String t = br.readLine();
			if(mp.containsKey(t)) {
				bw.append(mp.get(t)+"\n");
			}
			else {
				bw.append(arr[Integer.parseInt(t)-1]+"\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
