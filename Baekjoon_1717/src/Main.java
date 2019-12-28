import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		parent = new int[n+1];
		for(int i=0; i<parent.length; i++) {
			parent[i]=i;
		}
		
		// 다 -1로 초기화 시키니까 밑에 union에서 합치면서 오류
		
		List<String> list = new ArrayList<String>();
		
		for(int i=0; i<m; i++) {
			tmp = br.readLine().split(" ");
			int num0 = Integer.parseInt(tmp[0]);
			int num1 = Integer.parseInt(tmp[1]);
			int num2 = Integer.parseInt(tmp[2]);
			
			if(num0==0) {
				union(num1,num2);
			}
			else {
				int x = find(num1);
				int y = find(num2);
				if(x==y) {
					list.add("YES");
				}
				else {
					list.add("NO");
				}
			}
		}
		for(String p : list) {
			System.out.println(p);
		}
	}
	
	public static int find(int k) {
		if(parent[k]==k) { //음수일 경우 root노가 되며 리턴.
			return k;
		}
		parent[k] = find(parent[k]); // find하면서 root랑 바로 연결해버림
		return parent[k];
	}
	
	public static void union(int k1, int k2) {
		int a = find(k1);
		int b = find(k2);
		if(a!=b) {
			parent[b]=a;
		}
		
		//parent[b]=a를 parent[k2]=a 이런식으로 잘못짰었음.... 병합할때는 해당 노드의 루트값만 바꿔주면됨.
		
	}


}



