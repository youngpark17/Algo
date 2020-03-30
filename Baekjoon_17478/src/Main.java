import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static int n;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		bw.append("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n");
		StringBuilder sb = new StringBuilder("");
		
		recursive(bw,0,sb);
		bw.flush();
		bw.close();
		
	}
	
	public static void recursive(BufferedWriter bw, int d,StringBuilder sb) throws IOException {
		bw.append(sb.toString()+"\"����Լ��� ������?\"\n");
		if(d==n) {
			bw.append(sb.toString()+"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n");
			bw.append(sb.toString()+"��� �亯�Ͽ���.\n");
			return;
		}
		bw.append(sb.toString()+"\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n" + 
				sb.toString()+"���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n" + 
				sb.toString()+"���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n");
		sb.append("____");
		recursive(bw,d+1,sb);
		sb.delete(sb.length()-4, sb.length());
		bw.append(sb.toString()+"��� �亯�Ͽ���.\n");
		
		
	}

}
