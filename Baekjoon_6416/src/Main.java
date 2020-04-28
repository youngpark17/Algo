import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Map<Integer,Integer> in;
	static Map<Integer,List<Integer>> mp;
	static Map<Integer, Boolean> visited;



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		mp = new HashMap<Integer,List<Integer>>();
		in = new HashMap<>();
		int T=0;
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a==-1 && b==-1) {
				break;
			}
			if(a==0 && b==0) {
				T++;
				if(mp.size()==0) {
					System.out.println("Case "+T+" is a tree.");
					init();
					continue;
				}
				int rootIdx=0;
				int count=0;
				boolean flag=false;
				for(Integer I : mp.keySet()) {
					if(in.get(I)==0) {
						rootIdx=I;
						count++;
					}
					if(count>1) {
						//root가 2개 이상이면
						System.out.println("Case "+T+" is not a tree.");
						flag=true;
						init();
						break;
					}
				}
				if(count==0) {
					System.out.println("Case "+T+" is not a tree.");
					flag=true;
					init();
				}
				if(!flag) {
					visited = new HashMap<>();
					for(Integer I : mp.keySet()) {
						visited.put(I, false);
					}
					if(!dfs(rootIdx)) {
						System.out.println("Case "+T+" is not a tree.");
					}
					else {
						System.out.println("Case "+T+" is a tree.");
					}
					init();
				}
				continue;
			}


			if(!mp.containsKey(a)) {
				in.put(a, 0);
				mp.put(a, new ArrayList<Integer>());
			}
			if(!mp.containsKey(b)) {
				in.put(b, 0);
				mp.put(b, new ArrayList<Integer>());
			}
			mp.get(a).add(b);
			in.put(b,in.get(b)+1);

		}
	}

	public static void init() {
		mp.clear();
		in.clear();
	}

	public static boolean dfs(int x) {
		if(visited.get(x)) {
			return false; //방문했던거 또 방문.
		}
		visited.put(x, true);
		for(Integer I : mp.get(x)) {
			if(!dfs(I)) {
				return false;
			}
		}

		return true;
	}

}
