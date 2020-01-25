import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int n;
	static int[] numbers;
	static int[] numbers2;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static List<Integer> op;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		numbers = new int[n];
		numbers2 = new int[n];
		for(int i=0; i<tmp.length; i++) {
			numbers[i] = Integer.parseInt(tmp[i]);
		}
		op = new ArrayList<>();
		int cnt=0;
		tmp = br.readLine().split(" "); //0123 +-*/
		for(int i=0; i<4; i++) {
			int k = Integer.parseInt(tmp[i]);
			for(int j=0; j<k; j++) {
				op.add(i);
			}
		}
		per(0);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void per(int d) {
		if(d==op.size()) {
			for(int i=0; i<numbers.length; i++) {
				numbers2[i] = numbers[i];
			}
			int cnt=1;
			for(int i=0; i<op.size(); i++) {
				switch(op.get(i)) {
				case 0: //+
					numbers2[cnt] = numbers2[cnt-1] + numbers2[cnt];
					cnt++;
					break;
				case 1://--
					numbers2[cnt] = numbers2[cnt-1] - numbers2[cnt];
					cnt++;
					break;
				case 2:
					numbers2[cnt] = numbers2[cnt-1] * numbers2[cnt];
					cnt++;
					break;
				case 3:
					numbers2[cnt] = numbers2[cnt-1] / numbers2[cnt];
					cnt++;
					break;
				
				}
			}
			max = Math.max(max, numbers2[n-1]);
			min = Math.min(min, numbers2[n-1]);
			
		}
		else {
			for(int i=d; i<op.size(); i++) {
				swap(d,i);
				per(d+1);
				swap(i,d);
			}
		}
	}
	
	public static void swap(int i, int j) {
		int tmp = op.get(i);
		op.set(i, op.get(j));
		op.set(j, tmp);
	}

}
