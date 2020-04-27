import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long n;
	static int k;
	static int q;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		while(q-->0) {
			int ans=0;
			
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b  =Long.parseLong(st.nextToken());
			if(k==1) {
				bw.append(Math.abs(a-b)+"\n");
				continue;
			}
			while(a!=b) {
				while(a>b) { //a가 더 아래에 있으니까 올리자.
					ans++;
					a = getParent(a);
				}
				
				while(b>a) {
					ans++;
					b = getParent(b);
				}
			}
			bw.append(ans+"\n");
			
		}
		bw.flush();
		bw.close();

	}

	public static long getParent(long a) {
		return (a+k-2)/k;
	}

}
