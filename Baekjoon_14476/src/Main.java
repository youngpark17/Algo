import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] lefttoright;
	static int[] righttoleft;
	static int[] answer;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//중복 제거
		Set<Integer> set = new LinkedHashSet<>();
		for(int i=0; i<n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		int[] tmp = new int[set.size()];
		Iterator it = set.iterator();
		int t = 0;
		while(it.hasNext()) {
			tmp[t++] =(int)it.next();
		}
		
		lefttoright = new int[set.size()];
		righttoleft = new int[set.size()];
				
		n = set.size();
		answer = new int[n];
		lefttoright[0] = tmp[0];
		righttoleft[n-1] = tmp[n-1];
		for(int i=1; i<n; i++) {
			lefttoright[i] = gcd( lefttoright[i-1], tmp[i]);
		}
		
		for(int i=n-2; i>=0; i--) {
			righttoleft[i] = gcd( tmp[i], righttoleft[i+1]);
		}
		//하나 뻇을떄 최대 공약수는 그 수를 뺐을때의 직전과 직후 중 큰 것
		answer[0] = righttoleft[1];
		answer[n-1] = lefttoright[n-2];
		for(int i=1; i<n-1; i++) {
			answer[i] = gcd(lefttoright[i-1],righttoleft[i+1]);
		}
		
		List<Integer> list = new ArrayList<>();
		
		for(int u : answer) {
			list.add(u);
		}
		
		int max = Collections.max(list);
		int answer2 = tmp[list.indexOf(max)];

		if(answer2%max==0) {
			System.out.println(-1);
		}
		else {
			
			System.out.println(max+" "+answer2);
		}
		
		
		
		
		
	}
	
	public static int gcd(int a, int b) {
		if(b==0) { //a가 더 큼
			return a;
		}
		if(b>a) {
			int tmp=b;
			b=a;
			a=tmp;
		}
		return gcd(b,a%b);
		
	}
	
	

}
