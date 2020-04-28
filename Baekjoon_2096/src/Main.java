import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] maxDp;
	static int[][] minDp;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		maxDp = new int[2][3];
		minDp = new int[2][3];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(i==0) {
				maxDp[0][0]=a;
				maxDp[0][1]=b;
				maxDp[0][2]=c;
				minDp[0][0]=a;
				minDp[0][1]=b;
				minDp[0][2]=c;
				continue;
			}
			maxDp[1][0] = Math.max(maxDp[0][0], maxDp[0][1])+a;
			maxDp[1][1] = Math.max(maxDp[0][2], Math.max(maxDp[0][0], maxDp[0][1]))+b;
			maxDp[1][2] = Math.max(maxDp[0][1], maxDp[0][2])+c;
			maxDp[0][0] = maxDp[1][0];
			maxDp[0][1] = maxDp[1][1];
			maxDp[0][2] = maxDp[1][2];
			minDp[1][0] = Math.min(minDp[0][0], minDp[0][1])+a;
			minDp[1][1] = Math.min(minDp[0][2], Math.min(minDp[0][0], minDp[0][1]))+b;
			minDp[1][2] = Math.min(minDp[0][1], minDp[0][2])+c;
			minDp[0][0] = minDp[1][0];
			minDp[0][1] = minDp[1][1];
			minDp[0][2] = minDp[1][2];
			
		}
		int maxValue = Math.max(Math.max(maxDp[0][0], maxDp[0][1]),maxDp[0][2]);
		int minValue = Math.min(Math.min(minDp[0][0], minDp[0][1]),minDp[0][2]);
		System.out.println(maxValue+" "+minValue);
		
	}

}
