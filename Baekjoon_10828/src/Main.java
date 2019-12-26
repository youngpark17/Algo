import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<Integer>();
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			
			String[] tmp = br.readLine().split(" ");
			String a = tmp[0];
			if(a.equals("push")) {
				st.add(Integer.parseInt(tmp[1]));
			}
			else if(a.equals("pop")) {
				if(st.size()==0) {
					list.add(-1);
				}
				else {
					list.add(st.pop());
				}
			}
			else if(a.equals("size")) {
				list.add(st.size());
			}
			else if(a.equals("empty")) {
				if(st.isEmpty()) {
					list.add(1);
				}
				else {
					list.add(0);
				}
			}
			else if(a.equals("top")){
				if(st.isEmpty()) {
					list.add(-1);
				}
				else {
					list.add(st.peek());
				}
				
			}
			
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	


}
