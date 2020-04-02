import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		while(n-->0) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		int sum=0;
		while(pq.size()!=1) {
			int a = pq.poll();
			int b = pq.poll();
			sum+=a+b;
			pq.add(a+b);
		}
		bw.append(sum+"");
		bw.flush();
		bw.close();
	}
}
