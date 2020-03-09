import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static String a;
	static String b;
	static int diff;
	static int[] output;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine();
		b = br.readLine();
		
		diff = b.length()-a.length();
		output = new int[diff];
		sb = new StringBuilder(b);
		check(b.length()-a.length(),sb);
		System.out.println(0);
		
		
		
		
	}
	
	public static void check(int k, StringBuilder sb) {
		if(k==0){
			if(sb.toString().equals(a)) {
				System.out.println(1);
				System.exit(0);
			}
		}
		else {
			if(sb.charAt(0)=='A' &&sb.charAt(sb.length()-1)=='A') {//AA
				sb.deleteCharAt(sb.length()-1); //A昏力
				check(k-1,sb);
				sb.append("A");
				
			}
			if(sb.charAt(0)=='B' &&sb.charAt(sb.length()-1)=='B') {//BB
				sb.reverse();
				sb.deleteCharAt(sb.length()-1);//b昏力
				check(k-1,sb);
				sb.append('B');
				sb.reverse();
			}
			else if(sb.charAt(0)=='B' &&sb.charAt(sb.length()-1)=='A') { //BA
				//A昏力
				sb.deleteCharAt(sb.length()-1); 
				check(k-1,sb);
				sb.append('A');
				
				
				sb.reverse();
				sb.deleteCharAt(sb.length()-1); //B昏力
				check(k-1,sb);
				sb.append('B');
				sb.reverse();
				
			}
			else if(sb.charAt(0)=='A'&& sb.charAt(sb.length()-1)=='B' ){ //AB
				return;
			}
		}
	}
	
	

}
