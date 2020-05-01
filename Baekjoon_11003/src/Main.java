import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int n, l;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		ArrayDeque<Integer> que = new ArrayDeque<>();
		int[] data = new int[n];
		for(int i=0; i<n; i++) { 
			//이미 들어온것중에 새로 들어온것보다 큰 것은 필요가 없다.
			data[i] = Integer.parseInt(st.nextToken());
			while(!que.isEmpty() && data[que.getLast()]>data[i]) {
				que.removeLast();
			}
			que.addLast(i);
			if(que.getFirst()<=i-l) {
				que.removeFirst();
			}
			bw.append(data[que.getFirst()]+" ");
			
		}
		bw.flush();
		bw.close();
		
		
		
		
	}

}
