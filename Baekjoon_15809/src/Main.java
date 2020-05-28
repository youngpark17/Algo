import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] power;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		power = new int[n+1];
		parents = new int[n+1];
		for(int i=0; i<n+1; i++) {
			parents[i] = i;
		}
		for(int i=1; i<n+1; i++) {
			power[i] = Integer.parseInt(br.readLine());
		}
		while(m-->0) {
			st=  new StringTokenizer(br.readLine());
			int o,p,q;
			o = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			if(o==1) { //동맹.
				union(p,q,true);
			}
			else {
				union(p,q,false);
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<n+1; i++) {
			if(power[i]!=0) {
				list.add(power[i]);
			}
		}
		Collections.sort(list);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(list.size()+"\n");
		for(int k : list) {
			bw.append(k+" ");
		}
		bw.flush();
		bw.close();
	}
	public static int find(int k) {
		if(parents[k]==k) {
			return k;
		}
		return parents[k] = find(parents[k]);
	}
	public static void union(int a, int b,boolean flag) {
		a = find(a);
		b = find(b);
		//큰쪽에 계속 붙이자.
		if(a==b) {
			return ;
		}
		if(power[b]>power[a]) {
			int tmp  = b;
			b = a;
			a=tmp;
		}
		//a가  병력이 더 많다.
		if(flag) {//동맹.
			power[a]+=power[b];
			power[b] = 0;
		}
		else {
			if(power[a]==power[b]) {
				parents[a]=0;
				parents[b]=0;
				power[a]=0;
				power[b]=0;
				return ;
			}
			power[a]-=power[b];
			power[b]= 0;
		}
		parents[b]=a; 
	}

}