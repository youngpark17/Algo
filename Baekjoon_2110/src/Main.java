import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int c;
	static List<Integer> list;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int k= Integer.parseInt(br.readLine());
			list.add(k);
		}
		Collections.sort(list);
		if(c==n) { //놔야 하는 공유기 개수와 집의 개수가 같다면
			int min=Integer.MAX_VALUE;
			for(int i=1; i<list.size(); i++) {
				min=Math.min(min, list.get(i)-list.get(i-1));
			}
			System.out.println(min);
			System.exit(0);
		}
		//최대의 최소
		//구하는건 두 공유기 사이의 최대 거리. 단 거리가 너무 크면 c개를 못 놓는다.
		int l=1;
		int r = 500;
		int mid=0;
		while(l<=r) {
			mid = (l+r)/2;
			if(check(mid)) { //mid값을 넣었을때 공유기가 c보다 작게설치된다면 거리를 줄여야지..
				r=mid-1;
			}
			else { //mid값을 넣었을때 c랑 같게 설치된다면 
				l=mid+1;
			}
		}
		System.out.println(r);
		
	}
	public static boolean check(int m) {
		//최대의 최소 구하기 일단 최대를 구해야 하므로 첫번째에는 무조건 넣자.
		int cnt=1;
		int k = list.get(0);
		//그 다음집과의 거리 차이가 m이라면 cnt++; k다시 인덱싱. m보다 작다면 또 그 다음꺼랑 비교. m보다 크다면 break; 
		for(int i=1; i<list.size(); i++) {
			if(list.get(i)-k >=m) {
				cnt++;
				k=list.get(i);
			}
		}
		return cnt<c; // 공유기를 c개보다 작게 설치하면 ... //같게 설치되면 
	}

}
