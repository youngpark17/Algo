import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int r,c;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		for(int i=0; i<r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int s=1;
		int e=r-1;
		while(s<=e) {
			int mid = (s+e)/2;
			if(check(mid)) {//true면 중복 발생. mid값 줄이자.
				e=mid-1;
			}
			else {
				s=mid+1;
			}
		}
		System.out.println(e);
		
		
	}
	public static boolean check(int mid) {
		Set<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<c; i++) {
			for(int j=mid; j<r; j++) {
				sb.append(map[j][i]);
			}
			if(set.contains(sb.toString())) {
				return true;
			}
			set.add(sb.toString());
			sb.delete(0, sb.toString().length());
		}
		return false;
	}

}
