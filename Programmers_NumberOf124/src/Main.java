
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		
		System.out.println(main.solution(10));
		
	}

	public String solution(int n) {
		StringBuilder sb = new StringBuilder();
		//1,2,3,4,5,6,7,8,9,10
		//1,2,4,11,12,14,21,22,24,41,42,44,111,112,114
		//����.
		//���̰� 1�϶��� 3�� ����
		//���̰� 2�϶��� 9����(3*3)
		//���̰� 3���϶��� 27�� ����.
		//n���� 3�� n������ŭ ���鼭 ���� ������ ���� �����߿� n��
		int start = 3;
		int length=1;
		for(int i=1; i<100; i++) {
			int tmp = (int)Math.pow(start, i);
			if(n-tmp>0) {
				n-=tmp;
				length++;
			}
			else {
				break;
			}
		}
		for(int i=1; i<=length; i++) {
			start = (int)Math.pow(3, length-i);
			for(int j=0; j<3; j++) {
				if(n-start>0) {
					n-=start;
				}
				else {
					if(j==0) {
						sb.append(1);
					}
					else if(j==1) {
						sb.append(2);
					}
					else {
						sb.append(4);
					}
					break;
				}
			}
		}
		
		//���̰� lenght�� ���߿� n��°�̴�.
		//7���� ��� ���̰� 1�ΰ��߿� 4��°.
		//11,12,14,21,22,24,41,42,44
		//���̰� 2 �߿� ù���� �ڸ��� �������ٴ� ����? 
		//3^(l-1)
		
		
		
		return sb.toString();
	}

}
