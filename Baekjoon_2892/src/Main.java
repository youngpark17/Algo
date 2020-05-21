import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//n = Integer.parseInt(br.readLine());
		//key값은 0부터 9 즉. 아스키코드 48 57까지랑 xor연산.
		//메시지의 값은 97부터 122까지..
		
		//48은? 000...32+16... 110000
		//57은?       32+16+8+1 111001
		//97은?  64+32+1  1100001
		//122는? 64+32+16+8+2 1111010
		
		//hashset에 온점과 공백에 대한 xor을 담아보자
		Set<String> set = new HashSet<>();
		for(int i=0; i<10; i++) {
			set.add(Integer.toHexString(((32^(48+i)))));
			set.add(Integer.toHexString((((int)('.')^(48+i)))).toUpperCase());
		}
	
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<n; i++) {
			if(set.contains(st.nextToken())) {
				bw.append(".");
			}
			else {
				bw.append("-");
			}

		}
		bw.flush();
		bw.close();
		
		
		
		
	}

}
