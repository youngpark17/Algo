import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
	static char[] number;
	static int m;
	static boolean flag;
	static int maxNumber;
	static boolean[][] visited;
	

	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		number = tmp[0].toCharArray();
		m = Integer.parseInt(tmp[1]);
		flag=false;
		maxNumber=0;
		visited = new boolean[1000001][m+1];
		dfs(0);
		if(!flag) {
			System.out.println(-1);
		}
		else {
			System.out.println(maxNumber);
		}

	}

	public static void dfs(int depth) {
		if(depth==m) {
			StringBuilder sb = new StringBuilder();
			sb.append(number);
			maxNumber = Math.max(maxNumber, Integer.parseInt(sb.toString()));
			flag=true;
			return;
		}
		else {
			for(int i=0; i<number.length-1; i++) {
				for(int j=i+1; j<number.length; j++) {
					if(i==0 && number[j]=='0') {
						continue;
					}
					swap(i,j);
					int k =parseInt();
					if(!visited[k][depth]) {
						visited[k][depth] = true;
						dfs(depth+1);
					}
					swap(i,j);
					
				}
			}
		}
	}
	
	public static int parseInt() {
		int ans=0;
		for(int i=0; i<number.length; i++) {
			int z = number[i]-'0';
			ans+=z*Math.pow(10, number.length-1-i);
		}
		return ans;
	}

	public static void swap(int a, int b) {
		char tmp = number[a];
		number[a] = number[b];
		number[b] =tmp;
	}

}