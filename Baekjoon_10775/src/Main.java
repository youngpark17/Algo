import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
	
	static int gate;
	static int plane;
	static TreeSet<Integer> ts;
	static int cnt;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//treeset 이용해서
		//1부터 최대까지 다 넣자.
		//그리고 비행기가 가능한 도커중 젤 큰 번호는 제거.
		//반복하다가 더이상 가능한 번호가 없다면 종료.
		gate = Integer.parseInt(br.readLine());
		plane= Integer.parseInt(br.readLine());
		cnt=0;
		ts = new TreeSet<Integer>();
		for(int i=1; i<=gate; i++) {
			ts.add(i);
		}
		while(plane-->0) {
			int k = Integer.parseInt(br.readLine());
			int value=0;
			try {
				value = ts.headSet(k, true).last();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(cnt);
				System.exit(0);
			}
			ts.remove(value);
			cnt++;
		}
		System.out.println(cnt);
		
	}

}
