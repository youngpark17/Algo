import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[10000001];
		for(int i=1; i<n+1; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		for(int i=1; i<arr.length-1; i++) {
			for (int j = 0; j < arr[i]; j++) {
				//����� ������ŭ �������� �ϱ� ������
				bw.write(Integer.toString(i) + "\n");
				//bw.flush(); ���� �����ϸ� ��Ŭ���� Console�� ����� �ȵ�
			}
		}
		

		br.close();
		bw.close();
	}




}
