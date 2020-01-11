import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue que = new PriorityQueue();
		for(int i=0; i<n; i++) {
			int k = Integer.parseInt(br.readLine());
			if(k==0) {
				if(que.isEmpty()) {
					bw.append(0+"\n");
				}
				else {
					bw.append(que.poll()+"\n");	
				}
			}
			else {
				que.add(k);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
