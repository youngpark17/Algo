import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int k;
	static boolean[] visited;
	static int[] output;
	static char[] arr;
	static long min = Long.MAX_VALUE;
	static long max = Long.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		arr = br.readLine().replaceAll(" ", "").toCharArray();
		visited = new boolean[10];
		output = new int[k+1];
		//0~10까지 9개중  k+1개를 선택하는 순열 백트래킹.
		per(0);
		System.out.println(max);
		if((min+"").length()!=k+1) {
			System.out.print(0);
			System.out.println(min);
		}
		else {
			System.out.println(min);
		}
	}
	
	public static void per(int c) {
		if(c==k+1) {
			String s = "";
			for(int k : output) {
				s+=k;
			}
			long k = Long.parseLong(s);
			min = Math.min(min, k);
			max = Math.max(max, k);
		}
		else {
			for(int i=0; i<visited.length; i++) {
				if(!visited[i]) {
					if(c!=0 && arr[c-1]=='<' && output[c-1]>i) {
						continue;
					}
					else if(c!=0 && arr[c-1]=='>' &&output[c-1]<i) {
						continue;
					}
					visited[i] = true;
					output[c] = i;
					per(c+1);
					visited[i] = false;
				}
			}
		}
	}

}
