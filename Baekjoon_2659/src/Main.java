import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static boolean[] check;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arr = new int[4];
		Scanner sc = new Scanner(System.in);
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		arr[3] = sc.nextInt();
		int min = (1<<31)-1;
		check = new boolean[10000];
		for(int i=0; i<4; i++) {
			int tmp=0;
			for(int j=0; j<4; j++) {
				tmp+=arr[(j+i)%4]*Math.pow(10, 3-j);
			}
			min = Math.min(min, tmp);
		}
		//min���� ������ ã��
		//min���� ������ �߿� 1111���� 0�� �������� �ʴ� ��������.
		int cnt=0;
		for(int i=1111; i<=min; i++) {
			if(i%10==0) {
				continue;
			}
			if(check(i+"")==i) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static int check(String k) {
		char[] tp = k.toCharArray();
		int[] tmp = new int[4];
		for(int i=0; i<4; i++) {
			tmp[i] = tp[i]-'0';
		}
		int min2 = (1<<31)-1;
		for(int i=0; i<4; i++) {
			int tmp2=0;
			for(int j=0; j<4; j++) {
				tmp2+=tmp[(j+i)%4]*Math.pow(10, 3-j);
			}
			min2 = Math.min(min2, tmp2);
		}
		if(!check[min2]) {
			check[min2] = true;
			return min2;
		}
		return -1;
		
		
	}

}
