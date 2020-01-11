import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	static String[] everyTmp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		everyTmp = new String[n];
		Map<String,Integer> mp = new HashMap<>();
		List<Node> list = new ArrayList<>();

		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			everyTmp[i]=tmp;
			
			for(int j=0; j<tmp.length(); j++) {
				String tmp2=tmp.substring(j, j+1);
				if(mp.containsKey(tmp2)) {
					mp.put(tmp2, mp.get(tmp2)+(int)Math.pow(10,tmp.length() - (j+1)));
				}
				else {
					mp.put(tmp2, (int)Math.pow(10, tmp.length()-(j+1)));
				}

			}
		}
		for(Entry<String,Integer> e: mp.entrySet()) {
			list.add(new Node(e.getKey(),e.getValue()));
		}
		int count=9;
		Collections.sort(list);
		for(Node k : list) {
			k.cost=count--;
		}
		
		
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<everyTmp.length; j++) {
				everyTmp[j]=everyTmp[j].replaceAll(list.get(i).c, list.get(i).cost+"");
				
			}
		}


		int answer=0;
		for(String t : everyTmp) {
			answer+=Integer.parseInt(t);
		}
		System.out.println(answer);


	}


}




class Node implements Comparable<Node>{
	String c;
	int cost;
	Node(String c, int cost){
		this.c=c;
		this.cost=cost;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return o.cost-this.cost;
	}
	

}
