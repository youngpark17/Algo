import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static StringBuilder sb;
	static int[] arr = {1,2,3};
	static boolean[] visited= {false,false,false};
	static int[] output;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder("");
		n = sc.nextInt();
		k = sc.nextInt();
		output = new int[n];
		per(0,n,0,0);
		String[] ttt = sb.toString().split("\\.");
		if(k-1>ttt.length-1) {
			System.out.println(-1);
		}
		else
			System.out.println(ttt[k-1]);

	}

	public static void per(int c,int d, int sum, int depth) {
		if(c==d) {
			if(sum==n) {
				for(int i=0; i<c; i++) {
					if(i!=c-1) {
						sb.append(output[i]+"+");
					}
					else {
						sb.append(output[i]+".");
					}
				}
			}
		}
		else if(sum==n) {
			for(int i=0; i<depth; i++) {
				if(i!=c-1) {
					sb.append(output[i]+"+");
				}
				else {
					sb.append(output[i]+".");
				}
			}
		}
		else {
			for(int i=0; i<3; i++) {

				sum+=arr[i];
				if(sum<=n) {
					output[c]=arr[i];
					per(c+1,d,sum,depth+1);
				}
				sum-=arr[i];

			}
		}
	}

}
