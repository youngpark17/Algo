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
		if(c==n) { //���� �ϴ� ������ ������ ���� ������ ���ٸ�
			int min=Integer.MAX_VALUE;
			for(int i=1; i<list.size(); i++) {
				min=Math.min(min, list.get(i)-list.get(i-1));
			}
			System.out.println(min);
			System.exit(0);
		}
		//�ִ��� �ּ�
		//���ϴ°� �� ������ ������ �ִ� �Ÿ�. �� �Ÿ��� �ʹ� ũ�� c���� �� ���´�.
		int l=1;
		int r = 500;
		int mid=0;
		while(l<=r) {
			mid = (l+r)/2;
			if(check(mid)) { //mid���� �־����� �����Ⱑ c���� �۰Լ�ġ�ȴٸ� �Ÿ��� �ٿ�����..
				r=mid-1;
			}
			else { //mid���� �־����� c�� ���� ��ġ�ȴٸ� 
				l=mid+1;
			}
		}
		System.out.println(r);
		
	}
	public static boolean check(int m) {
		//�ִ��� �ּ� ���ϱ� �ϴ� �ִ븦 ���ؾ� �ϹǷ� ù��°���� ������ ����.
		int cnt=1;
		int k = list.get(0);
		//�� ���������� �Ÿ� ���̰� m�̶�� cnt++; k�ٽ� �ε���. m���� �۴ٸ� �� �� �������� ��. m���� ũ�ٸ� break; 
		for(int i=1; i<list.size(); i++) {
			if(list.get(i)-k >=m) {
				cnt++;
				k=list.get(i);
			}
		}
		return cnt<c; // �����⸦ c������ �۰� ��ġ�ϸ� ... //���� ��ġ�Ǹ� 
	}

}
