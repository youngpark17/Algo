import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			tmp = tmp.replace("0.", "");
			if(tmp.contains("(")) {
				int idx = tmp.indexOf(")"); // 순환 소수 종료 인덱스
				int idx0 = tmp.indexOf("("); //슨환 소수 시작 인덱스. 순환소수 아닌 부분의 길이
				tmp = tmp.replace("(", "");
				tmp = tmp.replace(")", "");
				long e1 =(long) Math.pow(10,idx-1);
				long e2 =(long) Math.pow(10, idx0);
				long y = e1-e2; //분모
				long realTmp=Long.parseLong(tmp);
				long y2 = realTmp-(realTmp/(long)Math.pow(10, idx-idx0-1));
				long gcd3 = gcd(y,y2);
				y=y/gcd3;
				y2=y2/gcd3;
				bw.append(y2+"/"+y+"\n");
			}
			else {
				int length = tmp.length();
				long y = (long)Math.pow(10, length);
				long y2 = Integer.parseInt(tmp);
				
				long gcd2=gcd(y,y2);
				y=y/gcd2;
				y2=y2/gcd2;
				bw.append(y2+"/"+y+"\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	
	
	public static long gcd(long a, long b) {
		if(b==0) { //a가 더 큼
			return a;
		}
		if(b>a) {
			long tmp=b;
			b=a;
			a=tmp;
		}
		return gcd(b,a%b);
		
	}

}
