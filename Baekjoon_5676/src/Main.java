import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static int[] arr;
	static int[] tree;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//펜윅 트리 이용해서 바뀔때는 그 구간을 포함하고 있는거에 대해서 원래값으로 나누고 다시 곱하자.
		String input="";
		while((input = br.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(input);
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n+1];
			tree = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<n+1; i++) {
				int a = Integer.parseInt(st.nextToken());
				if(a>0) {
					arr[i]=1;
				}
				else if(a==0) {
					arr[i]=0;
				}
				else {
					arr[i]=-1;
				}
				if(arr[i]==0) {
					update(i,100000);
				}
				else if(arr[i]<0) {
					update(i,1);
				}
			}
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				if(st.nextToken().equals("C")) {
					int idx = Integer.parseInt(st.nextToken());
					int v = Integer.parseInt(st.nextToken());
					if(arr[idx]>0) { //양수
						
					}
					else if(arr[idx]==0) { //0
						update(idx,-100000);
					}
					else if(arr[idx]<0) { //음수
						update(idx,-1);
					}
					
					if(v>0) {
						arr[idx]=1;
					}
					else if(v==0) {
						arr[idx]=0;
						update(idx,100000);
					}
					else if(v<0) {
						arr[idx]=-1;
						update(idx,1);
					}
					
				}
				else {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					long aa = get(a-1);
					long bb = get(b);
					long c = bb-aa;  //구간 a,b사이의 음수의 갯수
					if(c>=100000) {//
						bw.append("0");
					}
					else if(c%2==0) {
						bw.append("+");
					}
					else {
						bw.append("-");
					}
					
				}
			}
			bw.append("\n");
			bw.flush();
		}
		bw.close();
		
		
		
		
	}
	
	public static long get(int idx) {
		long ans=0;
		for(int i=idx; i>0; i-=i&(-i)) {
			ans+=tree[i];
		}
		return ans;
	}
	
	
	public static void update(int idx, int value) {
		for(int i=idx; i<n+1; i+=i&(-i)) { //
			tree[i]+=value;
		}
	}
	
	
	public static void change() {
		
	}

}
