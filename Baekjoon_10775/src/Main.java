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
		//treeset �̿��ؼ�
		//1���� �ִ���� �� ����.
		//�׸��� ����Ⱑ ������ ��Ŀ�� �� ū ��ȣ�� ����.
		//�ݺ��ϴٰ� ���̻� ������ ��ȣ�� ���ٸ� ����.
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
