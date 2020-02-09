import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.*;


public class Main {
	static int r;
	static int c;
	static int k;
	static int[][] map;
	static int maxCol;
	static int maxRow;
	static Map<Integer,Integer> mp;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		map = new int[100][100];
		mp = new HashMap<>();
		maxCol=3;
		maxRow=3;
		// list.get(0).get(0) 이게 0행 0열이라고 가정하자.
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = (Integer.parseInt(st.nextToken()));
			}
		}
		for(int t=0; t<=100; t++) {
			if(map[r][c]==k) {
				System.out.println(t);
				break;
			}
			if(maxRow>=maxCol) { //R연산 하자
				for(int i=0; i<maxRow; i++) {
					for(int j=0; j<maxCol; j++) {
						if(mp.containsKey(map[i][j])){
							mp.put(map[i][j], mp.get(map[i][j])+1);
							map[i][j]=0;
						}
						else {
							if(map[i][j]!=0) {
								mp.put(map[i][j], 1);
								map[i][j]=0;
							}
						}
					}
					maxCol = Math.max(maxCol, mp.size()*2);
					maxCol = Math.min(maxCol, 100);
					List<Node> list = new LinkedList<>();
					for(Entry<Integer, Integer> et : mp.entrySet()) {
						list.add(new Node(et.getKey(), et.getValue()));
					}
					Collections.sort(list);
					int cnt=0;
					while(!list.isEmpty() && cnt<99) { //최대 인덱스는 99까지이므로...
						Node a = list.remove(0);
						map[i][cnt] = a.num;
						map[i][cnt+1] = a.d;
						cnt+=2;
					}
					mp.clear();
				}
			}
			else {
				for(int i=0; i<maxCol; i++) {
					for(int j=0; j<maxRow; j++) {
						if(mp.containsKey(map[j][i])){
							mp.put(map[j][i], mp.get(map[j][i])+1);
							map[j][i]=0;
						}
						else {
							if(map[j][i]!=0) {
								mp.put(map[j][i], 1);
								map[j][i]=0;
							}
						}
					}
					maxRow = Math.max(maxRow, mp.size()*2);
					maxRow = Math.min(maxRow, 100);
					List<Node> list = new LinkedList<>();
					for(Entry<Integer, Integer> et : mp.entrySet()) {
						list.add(new Node(et.getKey(), et.getValue()));
					}
					Collections.sort(list);
					int cnt=0;
					while(!list.isEmpty() && cnt<99) { //최대 인덱스는 99까지이므로...
						Node a = list.remove(0);
						map[cnt][i] = a.num;
						map[cnt+1][i] = a.d;
						cnt+=2;
					}
					mp.clear();
				}
			}
			if(t==100) {
				System.out.println(-1);
			}
				
		}
	}

}

class Node implements Comparable<Node>{
	int num;
	int d;
	Node(int number, int d){
		this.num=number;
		this.d=d;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if(this.d==o.d) {
			return this.num-o.num;
		}
		
		return this.d-o.d;
	}
}
