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
		bw.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		StringBuilder sb = new StringBuilder("");
		
		recursive(bw,0,sb);
		bw.flush();
		bw.close();
		
	}
	
	public static void recursive(BufferedWriter bw, int d,StringBuilder sb) throws IOException {
		bw.append(sb.toString()+"\"재귀함수가 뭔가요?\"\n");
		if(d==n) {
			bw.append(sb.toString()+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			bw.append(sb.toString()+"라고 답변하였지.\n");
			return;
		}
		bw.append(sb.toString()+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" + 
				sb.toString()+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" + 
				sb.toString()+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		sb.append("____");
		recursive(bw,d+1,sb);
		sb.delete(sb.length()-4, sb.length());
		bw.append(sb.toString()+"라고 답변하였지.\n");
		
		
	}

}
