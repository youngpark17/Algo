import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int n;
	static char[] oplist;
	static int[] number;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		number = new int[n/2+1];
		visited = new boolean[n/2];
		oplist = new char[n/2];
		char[] tmp = br.readLine().toCharArray();
		int cnt1=0;
		int cnt2=0;
		for(int i=0; i<n; i++) {
			if((i&1)==0) { //i�� ¦���̸�. // 0 2 4...00 10 100
				number[cnt1++] = tmp[i]-'0';
			}
			else {
				oplist[cnt2++] = tmp[i];
			}
		}
		//��ȣ�� ������ �������� ����µ� �����ؼ� ������� ������ ������ ������ �����Ƿ�....
		int k = oplist.length/2+1; //�̸�ŭ���� ������ ���غ���.... �� ���ӵǴ� ���� ���� ����.
		for(int i=0; i<=k; i++) {
			comb(0,0,i); //i�� �̴� ���
		}
		System.out.println(max);
		
		

	}
	
	public static void comb(int c, int d, int r) {
		if(c==r) {
			if(c==0) { //�ƹ��͵� �� �̾��� ��� �׳� ���.
				int[] dp = new int[n/2+1];
				dp[0] = number[0];
				for(int i=0; i<oplist.length; i++) {
					if(oplist[i]=='+') {
						dp[i+1] = dp[i]+number[i+1];
					}
					else if(oplist[i]=='*') {
						dp[i+1] = dp[i]*number[i+1];
					}
					else {
						dp[i+1] = dp[i]-number[i+1];
					}
				}
				max = Math.max(max, dp[dp.length-1]);
			}
			else {
				int[] tnumber = new int[number.length];
				char[] toplist = new char[oplist.length];
				toplist = Arrays.copyOf(oplist, oplist.length);
				tnumber = Arrays.copyOf(number, number.length);
				for(int i=0; i<oplist.length; i++) {
					if(visited[i]) { //���õ� �Ÿ� ���� ����� ����.
						if(toplist[i]=='+') {
							tnumber[i] = tnumber[i] + tnumber[i+1];
						}
						else if(toplist[i]=='*') {
							tnumber[i] = tnumber[i] * tnumber[i+1];
						}
						else { //-
							tnumber[i] = tnumber[i] - tnumber[i+1];
						}
						
						tnumber[i+1] = Integer.MIN_VALUE;
						toplist[i] = '0';
					}
				}
				List<Character> op = new ArrayList<>();
				List<Integer> nu = new ArrayList<>();
				for(int i=0; i<toplist.length; i++) {
					if(toplist[i]!='0') {//���� ����� ���� �����ڶ��
						op.add(toplist[i]);
					}
				}
				for(int i=0; i<number.length; i++) {
					if(tnumber[i]!=Integer.MIN_VALUE) {//���� ����� ���� �����ڶ��
						nu.add(tnumber[i]);
					}
				}
				for(int i=0; i<op.size(); i++) {
					char t = op.get(i);
					if(t=='+') {
						nu.set(i+1, nu.get(i)+nu.get(i+1));
					}
					else if(t=='*') {
						nu.set(i+1, nu.get(i)*nu.get(i+1));
					}
					else if(t=='-') {
						nu.set(i+1, nu.get(i)-nu.get(i+1));
					}
				}
				
				max = Math.max(max, nu.get(nu.size()-1));
			}
		}
		else {
			for(int i=d; i<oplist.length; i++) {
				if(i==0) {
					if(!visited[i]) {
						visited[i] = true;
						comb(c+1,i+1,r);
						visited[i] = false;
					}
				}
				else {
					if(!visited[i] && !visited[i-1]) {
						visited[i] = true;
						comb(c+1,i+1,r);
						visited[i] = false;
					}
				}
				
			}
		}
	}


}
