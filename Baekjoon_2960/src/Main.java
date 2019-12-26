import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		int[] arr = new int[n+1];
		boolean[] check = new boolean[n+1];
		
		for(int i=0; i<arr.length; i++) {
			arr[i]=i;
		}
		int count=0;
		
		for(int i=2; i<arr.length; i++) {
			if(!check[i]) {
				check[i]=true;
				count++;
				if(count==m) {
					System.out.println(arr[i]);
				}
				int mul=2;
				while(i*(mul)<arr.length) {
					if(!check[i*(mul)]) {
						count++;
						check[i*(mul++)]=true;
						if(count==m) { // m번째로 지워진 수일경우
							System.out.println(arr[i*(mul-1)]);
						}
					}
					else {
						mul+=1;
					}
				}
			}
		}
		
		
	}

}
