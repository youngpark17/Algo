import java.io.BufferedReader;

import java.io.InputStreamReader;


public class Main {

	public static int[] arr;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int s = Integer.parseInt(tmp[1]);
		arr = new int[n];
		tmp = br.readLine().split(" ");
		for(int i=0; i<tmp.length; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		int p1 = 1;
		int p2 = 0;
		int answer = n+1;
		if(arr[p1]>=s||arr[p2]>=s) {
			System.out.println(1);
			System.exit(0);
		}
		int sum=0;
		sum+=arr[p1]+arr[p2];
		while(!(arr.length-1==p2)) { //p2�� ���� �ִٸ� ����.
			if(sum>=s) { //���� ��ǥ�� ���� ũ�ų� ������
				 //���� ��ǥ���϶�
				int k=p1-p2+1; 
				answer = Math.min(k, answer);
				if(p2<p1) {
					sum-=arr[p2]; //���� ��ǥ������ ũ�ٸ� ���� ������ ���������� �̵�
					p2++;
				}
				else if(p1==p2) { //p1�� p2�� ������
					sum+=arr[++p1];
				}
				if(sum>=s) { //������ �̵������� SUM��
					k = p1-p2+1;
					answer = Math.min(k, answer);
				}
						
			}
			else {
				if(p1<arr.length-1) {
					p1++;
					sum+=arr[p1];
					
				}
				else { //p1�� ���� �ִٸ�... p2�� �ö���� ���̻� �� ���ϴ� �� ����
					break;
					
				}
			}
		}
		if(answer==n+1) {
			answer=0;
		}
		System.out.println(answer);


	}



}
