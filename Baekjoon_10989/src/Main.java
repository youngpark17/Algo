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
				//저장된 갯수만큼 출력해줘야 하기 때문에
				bw.write(Integer.toString(i) + "\n");
				//bw.flush(); 가끔 사용안하면 이클립스 Console에 출력이 안됨
			}
		}
		

		br.close();
		bw.close();
	}




}
