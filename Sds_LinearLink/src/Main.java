import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
//		//테스트 케이스
//		5
//		3
//		0 0 0 
//		5
//		0 0 1 0 1 
//		10
//		0 0 0 1 0 0 0 1 0 1 
//		15
//		0 1 1 1 1 1 1 0 0 1 1 1 0 0 0 
//		30
//		1 1 0 1 0 1 0 0 0 0 0 0 1 0 0 1 0 1 0 0 1 1 1 1 1 0 1 1 0 0 
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			int[] arr = new int[n];
			int[] dp = new int[n];
			int[] group = new int[n];
			for(int j=0; j<tmp.length; j++) {
				arr[j]=Integer.parseInt(tmp[j]);
				
			}
			group[0]=0;
			dp[0]=0;
			for(int j=1; j<arr.length; j++) {
				
				group[j]=j;
				if(arr[j]==0) {
					dp[j]=dp[j-1];
				}
				else { //arr[j] 가 1일 경우에 0을 다섯개 만나거나 인덱스가 0보다 작아질 경우까지 게속...
					int cnt=1;
					int minus=1;
					int sum=0;
					while(cnt<=5 && j-minus>=0)
					{
						if(arr[j-minus]==0) {
							cnt++;
							sum+=minus;
							if(group[j-minus]!=j-minus) { //이미 연결되어 있다면.
								int t = group[j-minus];
								for(int k=0; k<j; k++) {
									if(group[k]==t) {
										group[k]=j;
									}
								}
							}
							group[j-minus]=j;
						
							minus++;
							
						}
						else {
							minus++;
						}
						
						
					}
					dp[j]=dp[j-1]+sum;
				}
			}
			Set<Integer> st = new HashSet<>();
			for(int p:group) {
				st.add(p);
			}
			System.out.println("#"+(i+1)+" "+dp[n-1]+" "+st.size());

		}
	}

}



