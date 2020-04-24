import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static int[] jw;
	static int[][] map;
	static int[] kh;
	static int[] mh;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n+1];
		jw = new int[20];
		kh = new int[20];
		mh = new int[20];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<20; i++) {
			kh[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<20; i++) {
			mh[i] = Integer.parseInt(st.nextToken());
		}

		//1���� n���� �ߺ��� �����ؼ� ����.
		com(0);
		System.out.println(0);

	}


	public static void play() {
		int tk1 = 0;
		int tk2= 0;
		int tk3 = 0;
		boolean[] visited = new boolean[3];
		visited[0] = true;
		visited[1] = true;
		int khIdx=0;
		int mhIdx=0;
		int jwIdx=0;
		int tmp=2;
		while(tk1<k && tk2<k && tk3<k) {
			
			//tmp�� ��⿡ ���� ���Ѿ� ��ȣ
			if(tmp==0) {//kh,mh����
				int k1 = kh[khIdx++];
				int k2 = mh[mhIdx++];
				if(map[k1][k2]==0) { //kh�� ��. mh��
					//kh�� ������� ������.
					tk3++;
					tmp=1;
				}
				else if(map[k1][k2]==1) { //mh��
					//kh�� ������
					tk3++;
					tmp=1;
				}	
				else if(map[k1][k2]==2) { //kh��
					tk2++;
					tmp=2;
				}
			}
			else if(tmp==1) { //kh�� ����
				int k1 = jw[jwIdx++];
				int k2 = mh[mhIdx++];
				if(map[k1][k2]==0) { // jw vs mh �ߴµ� jw ��.
					//jw�� ������� ������.
					tk3++;
					tmp=0;
				}
				else if(map[k1][k2]==1) { //mh�̱� jw������
					//jw
					tk3++;
					tmp=0;
				}
				else if(map[k1][k2]==2) { //jw�̱� mh������
					tk1++;
					tmp=2;
				}
			}
			else if(tmp==2) {
				int k1 = jw[jwIdx++];
				int k2 = kh[khIdx++];
				if(map[k1][k2]==0) { // jw vs kh �ߴµ� jw ��.
					//jw�� ������� ������.
					tk2++;
					tmp=0;
				}
				else if(map[k1][k2]==1) { //jw vs kh �ߴµ� jw��
					//jw
					tk2++;
					tmp=0;
				}
				else if(map[k1][k2]==2) { //jw�̱� kh
					tk1++;
					tmp=1;
				}
			}
		}
		if(tk1==k) {
			System.out.println(1);
			System.exit(0);
		}
		return;



	}


	public static void com(int c) {
		if(c==n) {
			play();
			return;
		}
		else {
			for(int i=0; i<=n; i++) {
				if(!visited[i]) {
					visited[i] = true;
					jw[c] = i;
					com(c+1);
					visited[i] = false;
				}
			}
		}
	}

}
