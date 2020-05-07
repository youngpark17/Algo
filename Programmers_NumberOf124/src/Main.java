
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
		//수학.
		//길이가 1일때는 3개 가능
		//길이가 2일때는 9개능(3*3)
		//길이가 3개일때는 27개 가능.
		//n에서 3의 n제곱만큼 뺴면서 포문 나가면 남은 길이중에 n번
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
		
		//길이가 lenght인 것중에 n번째이다.
		//7같은 경우 길이가 1인것중에 4번째.
		//11,12,14,21,22,24,41,42,44
		//길이가 2 중에 첫번쨰 자리가 정해진다는 것은? 
		//3^(l-1)
		
		
		
		return sb.toString();
	}

}
