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
		//key���� 0���� 9 ��. �ƽ�Ű�ڵ� 48 57������ xor����.
		//�޽����� ���� 97���� 122����..
		
		//48��? 000...32+16... 110000
		//57��?       32+16+8+1 111001
		//97��?  64+32+1  1100001
		//122��? 64+32+16+8+2 1111010
		
		//hashset�� ������ ���鿡 ���� xor�� ��ƺ���
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
