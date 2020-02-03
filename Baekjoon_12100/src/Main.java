import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static Node[][] map;
	static int[] arr = {1,2,3,4};
	static int answer= Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		//1234중에 5개 뽑는 중복 순열....
		map = new Node[n][n];
		for(int i=0; i<n; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				map[i][j] = new Node(Integer.parseInt(tmp[j]));
			}
		}
		
		for(int i=1; i<5; i++) {
			per(i,1,map);
		}
		System.out.println(answer);
		
	}
	
	public static void per(int ro,int d, Node[][] tmap) {
		if(d==6) {
			int max=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					max = Math.max(max, tmap[i][j].number);
				}
			}
			answer = Math.max(max, answer);
		}
		else {
			Node[][] tempmap = new Node[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					tempmap[i][j] = new Node(tmap[i][j].number);
				}
			}
			if(ro==1) {
				tempmap = up(tempmap);
			}
			else if(ro==2) {
				tempmap = right(tempmap);
			}
			else if(ro==3) {
				tempmap = down(tempmap);
			}
			else{
				tempmap = left(tempmap);
			}
			
			
			for(int i=1; i<5; i++) {
				per(i,d+1,tempmap);
			}
			
		}
	}
	
	public static Node[][] up(Node[][] tmap) {
		Queue<Node> que = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int k = tmap[j][i].number;
				if(k!=0) {
					que.add(tmap[j][i]);
				}
			}
			int cnt=0;
			if(que.size()==0) {
				tmap[cnt++][i] = new Node(0);
			}
			else {
				tmap[cnt++][i] = que.poll();
			}
			while(!que.isEmpty()) {
				Node t = que.poll();
				if(tmap[cnt-1][i].number==t.number && tmap[cnt-1][i].flag) {
					tmap[cnt-1][i].number+=t.number;
					tmap[cnt-1][i].flag=false; //더이상 못합침.
				}
				else {
					tmap[cnt++][i] = new Node(t.number);
				}
			}
			for(int j=cnt; j<n; j++) {
				tmap[j][i] = new Node(0);
			}
			
		}
		
		return tmap;
	}
	
	public static Node[][] right(Node[][] tmap) {
		Queue<Node> que = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0; j--) {
				int k = tmap[i][j].number;
				if(k!=0) {
					que.add(tmap[i][j]);
				}
			}
			int cnt = n-1;
			if(que.size()==0) {
				tmap[i][cnt--] = new Node(0);
			}
			else {
				tmap[i][cnt--] = que.poll();
			}
			while(!que.isEmpty()) {
				Node t = que.poll();
				if(tmap[i][cnt+1].number==t.number && tmap[i][cnt+1].flag) {
					tmap[i][cnt+1].number+=t.number;
					tmap[i][cnt+1].flag=false; //더이상 못합침.
				}
				else {
					tmap[i][cnt--] = t;
				}
			}
			
			for(int j=cnt; j>=0; j--) {
				tmap[i][j] = new Node(0);
			}
			
		}
		
		return tmap;
	}
	public static Node[][] left(Node[][] tmap) {
		Queue<Node> que = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int k = tmap[i][j].number;
				if(k!=0) {
					que.add(tmap[i][j]);
				}
			}
			int cnt = 0;
			if(que.size()==0) {
				tmap[i][cnt++] = new Node(0);
			}
			else {
				tmap[i][cnt++] = que.poll();
			}
			while(!que.isEmpty()) {
				Node t = que.poll();
				if(tmap[i][cnt-1].number==t.number && tmap[i][cnt-1].flag) {
					tmap[i][cnt-1].number+=t.number;
					tmap[i][cnt-1].flag=false; //더이상 못합침.
				}
				else {
					tmap[i][cnt++] = t;
				}
			}

			for(int j=cnt; j<n; j++) {
				tmap[i][j] = new Node(0);
			}
			
		}
		
		return tmap;
	}
	
	public static Node[][] down(Node[][] tmap) {
		Queue<Node> que = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0; j--) {
				int k = tmap[j][i].number;
				if(k!=0) {
					que.add(tmap[j][i]);
				}
			}
			int cnt = n-1;
			if(que.size()==0) {
				tmap[cnt--][i] = new Node(0);
			}
			else {
				tmap[cnt--][i] = que.poll();
			}
			while(!que.isEmpty()) {
				Node t = que.poll();
				if(tmap[cnt+1][i].number==t.number && tmap[cnt+1][i].flag) {
					tmap[cnt+1][i].number+=t.number;
					tmap[cnt+1][i].flag=false; //더이상 못합침.
				}
				else {
					tmap[cnt--][i] = t;
				}
			}
			
			
			for(int j=cnt; j>=0; j--) {
				tmap[j][i] = new Node(0);
			}
		}
		
		return tmap;
	}

}
class Node{
	int number;
	boolean flag;
	
	Node(int number){
		this.number=number;
		this.flag=true;
	}
}
