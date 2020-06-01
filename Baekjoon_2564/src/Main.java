import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int r,c;
	static int x,y;
	static long dis;
	static List<Node> list;
	static int n;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dis=0;
		list = new ArrayList<>();
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}

		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		for(Node t : list) {
			dis+=getDistance(t);
		}
		System.out.println(dis);

	}

	public static int getDistance(Node a) {
		if(a.x==x) {
			return  Math.abs(a.y-y);
		}
		if(x==1) {//合
			if(a.x==2) { //巢
				return c+Math.min(a.y+y, 2*r-a.y-y);
			}
			else if(a.x==3) { //辑
				return a.y+y;
			}
			else if(a.x==4) { //悼
				return r-y+a.y;
			}

		}
		else if(x==2) { //巢率
			if(a.x==1) { //合
				return c+Math.min(y+a.y, 2*r-y-a.y);
			}
			else if(a.x==3) {//辑率
				return y+c-a.y;
			}
			else if(a.x==4) {//悼率
				return r-y+c-a.y;
			}
		}
		else if(x==3) { //辑率
			if(a.x==1) { //合
				return y+a.y;
			}
			else if(a.x==2) {//巢
				return c-y+a.y;
			}
			else if(a.x==4) { //悼率
				return r+Math.min(y+a.y, 2*c-a.y-y);
			}
		}
		else { //悼
			if(a.x==1) { //合
				return y+r-a.y;
			}
			else if(a.x==2) {//巢
				return c-y+(r-a.y);
			}
			else if(a.x==3) { //辑
				return r+Math.min(y+a.y, 2*c-a.y-y);
			}
		}
		return -1;
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
