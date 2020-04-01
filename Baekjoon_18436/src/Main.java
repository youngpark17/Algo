import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int[] seg;
	static int m;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//¦���� ��������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		seg = new int[n*4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]%2==0) {
				arr[i]=1;
			}
			else {
				arr[i]=0;
			}
		}
		m = Integer.parseInt(br.readLine());
		init(0,n-1,1);
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==1) { //b-1�� c�� �ٲ���
				b-=1;
				//�̹� ¦���� ¦���� ���԰ų� Ȧ���� Ȧ���� ��� ���ʿ����
				if((arr[b]%2==1 && c%2==0)||(arr[b]%2==0 && c%2==1)) { 
					//Ȧ���϶� 0 ¦���϶� 1
					continue;
				}
				if(c%2==0) {
					arr[b]=1;
				}
				else {
					arr[b]=0;
				}
				if(c%2==0) { //������ ���� +1 //���� Ȧ�����µ� ¦������ +1
					update(0,n-1,1,1,b);
				}
				else { //������ ���� -1
					update(0,n-1,1,-1,b); //���� ¦�����µ� Ȧ�� ���� -1�ϰ�
				}
			}
			else if(a==2) {//¦���� ����
				b-=1;
				c-=1;
				int tmp =get(0,n-1,1,b,c);
				bw.append(tmp+"\n");
			}
			else {
				b-=1;
				c-=1;
				int tmp=(c+1-b)-get(0,n-1,1,b,c); //�� ������ ��ü �� ���� ¦���� ��
				bw.append(tmp+"\n");
				
			}
		
			
		}
		bw.flush();
		bw.close();
	}
	
	public static int get(int left, int right, int node, int start, int end) {
		if(left>end || right<start) {
			return 0;
		}
		if(start<=left && right<=end) {
			return seg[node];
		}
		int mid=(right+left)/2;
		return get(left,mid,node*2,start,end)+get(mid+1,right,node*2+1,start,end);
	}
	public static void update(int left, int right, int node, int diff, int idx) {
		if(idx<left || idx>right ) {
			return;
		}
		if(idx>=left && idx<=right) {
			seg[node]+=diff;
		}
		if(left==right) {
			return;
		}
		
		int mid = (left+right)/2;
		update(left,mid,node*2,diff,idx);
		update(mid+1,right,node*2+1,diff,idx);
		
	}
	
	public static int init(int left, int right, int node) {
		if(left==right) {
			return seg[node]=arr[left];
		}
		
		return seg[node] = init(left,(left+right)/2,node*2)+init((left+right)/2+1,right,node*2+1);
	}
}