import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int T;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		//문자열 길이대로 정렬한 다음에....
		l:while(T-->0) {
			List<String> lst = new ArrayList<>();
			int  k = Integer.parseInt(br.readLine());
			for(int i=0; i<k; i++) {
				lst.add(br.readLine());
			}
			Collections.sort(lst);
			for(int i=0; i<lst.size()-1; i++) {
				String tmp = lst.get(i);
				if(lst.get(i+1).length()>=tmp.length()) {
					if(lst.get(i+1).substring(0,tmp.length()).equals(tmp)){
						bw.append("NO\n");
						continue l;
					}
				}
				
			}

			bw.append("YES\n");
			
		}
		bw.flush();
		bw.close();
			
	}
}


