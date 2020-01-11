import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	static PriorityQueue<Integer> minHeap;
	static PriorityQueue<Integer> maxHeap;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int cnt=0;
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			if(((i+1)&1)==0) { //Â¦¼ö°³ ÀÔ·Â
				minHeap.add(Integer.parseInt(br.readLine()));
				
			}
			else { //È¦¼ö°³ ÀÔ·Â
				maxHeap.add(Integer.parseInt(br.readLine()));
			}
			
			if(check()) {
				swap();
			}
			bw.append(maxHeap.peek()+"\n");
			
			
			
		}
		bw.flush();
		bw.close();
	}
	
	public static boolean check() {
		if(minHeap.isEmpty()) {
			return false;
		}
		return minHeap.peek()<=maxHeap.peek();
	}
	
	public static void swap() {
		int k1 = minHeap.poll();
		maxHeap.add(k1);
		minHeap.add(maxHeap.poll());
	}
	
	

}

