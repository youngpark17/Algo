import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static Node[] arr;
	static int[] tree;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		//브루트 포스로 한다면 ? 버블솔트처럼 전부 비교 O(n^2)
		//value를 123순으로 압축시키자. 그 후 인덱스 별로 정렬 한 후 
		arr = new Node[n+1];
		for(int i=1; i<n+1; i++) {
			arr[i] = new Node(Integer.parseInt(br.readLine()),i);
		}
		Arrays.parallelSort(arr,1,n+1, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.value-o2.value;
			}
		});
		
		for(int i=1; i<n+1; i++) {
			arr[i].value=i;
		}
		Arrays.parallelSort(arr,1,n+1, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.idx-o2.idx;
			}
		});
		
		tree = new int[n+1]; //tree[x]는 value가 x와 같거나 작은것에 대한 갯수 가지고 있다.
		for(int i=1; i<n+1; i++) {
			Node t = arr[i];
			bw.append(t.idx-query(t.value)+"\n"); //query(t.value)는 자기보다 큰거 다가져옴.
			update(t.value);
		}
		bw.flush();
		bw.close();




	}
	
	public static int query(int x) {
		int ans=0;
		while(x>0) {
			ans+=tree[x];
			x-=(x&-x);
		}
		return ans;
	}
	public static void update(int x) {
		while(x<n+1) {
			tree[x]+=1;
			x+=(x&-x);
		}
	}

}

class Node{
	int value;
	int idx;
	Node(int value, int idx){
		this.value=value;
		this.idx=idx;
	}
}

