import java.util.HashSet;
import java.util.Set;

public class Solution {	
	Set<Integer> set;
	char[] tmp;
	char[] output;
	boolean[] v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so = new Solution();
		System.out.println(so.solution("011"));
		
	}

	public int solution(String numbers) {
		tmp = numbers.toCharArray();
		//9999999 까지의 소수 구하자.
		int n = 99999999+1;
		
		boolean[] visited = new boolean[n+1];
		visited[1] = true;	
		visited[0] = true;
		set = new HashSet<>();
		for(int i=2; i<=(int)Math.sqrt(n); i++) {
			if(!visited[i]) {
				for(int j=i+i; j<=n; j+=i) {
					visited[j] = true;
				}
			}
			
		}
		v = new boolean[tmp.length];
		for(int i=1; i<=tmp.length; i++) {
			output = new char[i];
			dfs(0,i);
		}
		int cnt=0;
		for(int k : set) {
			if(!visited[k]) {
				cnt++;
			}
			
		}
		
		return cnt;
		
		
	}
	
	public void dfs(int c,int k) {
		if(c==k) {
			StringBuilder sb = new StringBuilder();
			sb.append(output);
			set.add(Integer.parseInt(sb.toString()));
			
		}
		else {
			for(int i=0; i<tmp.length; i++) {
				if(!v[i]) {
					v[i] = true;
					output[c] = tmp[i];
					dfs(c+1,k);
					v[i] = false;
				}
			}
		}
	}


}
