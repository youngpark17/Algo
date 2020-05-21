import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Node> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Collections.sort(arr, (a,b)->(a.x-b.x));
		int before=arr.get(0).y;
		long total=arr.get(0).y-arr.get(0).x;
		for(int i=1; i<n; i++) {
			if(arr.get(i).x>before) {
				total+=arr.get(i).y-arr.get(i).x;
				before = arr.get(i).y;
			}
			else {
				if(arr.get(i).y>before) {
					total+=arr.get(i).y-before;
					before = arr.get(i).y;
				}
			}
			
		}
		System.out.println(total);
	}

}


class Node{
	int x;
	int y;
	
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
}
