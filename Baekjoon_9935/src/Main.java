import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static char[] tmp;
	static int n;
	static Stack<Character> st;
	static char[] target;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		tmp = br.readLine().toCharArray();
		target = br.readLine().toCharArray();
		n = target.length;
		st = new Stack<Character>();
		for(int i=0; i<tmp.length; i++) {
			st.push(tmp[i]);
			if(st.size()>=n) {

				if(check()) {
					for(int j=0; j<n; j++) {
						st.pop();
					}
				}
			}

		}

		if(st.size()==0) {
			bw.append("FRULA");
		}
		else {
			for(char c : st) {
				bw.append(c);
			}
		}
		bw.flush();

	}
	public static boolean check() {
		int idx=0;
		for(int i=st.size()-n; i<st.size(); i++) {
			if(st.get(i)!=target[idx++]) {
				return false;
			}
		}
		return true;
	}

}
