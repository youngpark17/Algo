import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static boolean[] arr;
	static int[] prime;
	static int count=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		arr= new boolean[1000001];
		prime = new int[1000001];
		
		//백만 이하의 소수 구하자
		
		for(int i=2; i<arr.length/2; i++) {
			if(!arr[i]) {
				if(!arr[i]) {
					prime[count++]=i;
				}
				
				for(int j=i+i; j<arr.length; j+=i) {
					arr[j]=true; //소수아님
				}
			}
			
		}
		String tmp="";
		
		while(! (tmp=br.readLine()).equals("0") && tmp.length()!=0) {
			n = Integer.parseInt(tmp);
			
			for(int i=0; i<count; i++) {
				
				if(!arr[n-prime[i]] && !arr[prime[i]]){ //소수 prime[i]와 n-prime[i]가 둘다 소수이면 
					
						bw.append(n+" = "+prime[i]+" + "+(n-prime[i])+"\n");
						break;
					
					
				}
				if(i==count-1) {
					bw.append("Goldbach's conjecture is wrong.\n");
				}
			}
			
			
		}
		bw.flush();
		bw.close();
		
		
	}

}
