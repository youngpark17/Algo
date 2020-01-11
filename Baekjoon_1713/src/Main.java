import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int n;
	static int m;
	static int time;
	static int count;
	static Node[] answer_arr;


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		time = 0;
		count=0;
		answer_arr = new Node[m]; //0부터 m-1까지
		String[] tmp=br.readLine().split(" ");
		Set<Integer> st = new HashSet<>();
		int nextNode=0;
		for(int i=0; i<m; i++) {
			answer_arr[i] = new Node(0); // time이 0이면 안올라온거
		}
		for(int i=0; i<m; i++) {
			time++;
			int k =Integer.parseInt(tmp[i])-1; //0부터 m-1까지
			if(count<n) {
				//덜 차있으면
				// 이미 그 번호가 있는데 또 들어옴 - > 추천횟수 증가
				if(st.contains(k)) {
					answer_arr[k].postNumber++;
				}
				else {
					//첨 들어옴
					answer_arr[k].postTime=time;
					answer_arr[k].postNumber++;
					st.add(k);
					count++;
				}
				
			}
			else {
				//꽉 차 있으면
				//있는 번호가 들어옴
				if(st.contains(k)) {
					answer_arr[k].postNumber++;
				}
				else {
					//없는 번호가 들어옴 -> 추천수 가자 적고, 게시된지 오래된거 삭제, 카운트는 그대로.
					Arrays.sort(answer_arr);
					for(int j=0; j<answer_arr.length; j++) {
						if(answer_arr[j].postNumber!=0 && answer_arr[j].postTime!=0) {
							answer_arr[j].postNumber=0;
							answer_arr[j].postTime=0;
							break;
						}
					}
					
					answer_arr[k].postTime=time;
					answer_arr[k].postNumber++;
				}
			}
			
			
		}
		Arrays.sort(answer_arr);
		for(int j=0; j<answer_arr.length; j++) {
			if(answer_arr[j].postNumber!=0 && answer_arr[j].postTime!=0) {
				System.out.print(j+" ");
			}
		}
		
		
		
		
	}

}

class Node implements Comparable<Node>{
	int postNumber;
	int postTime;
	
	Node(int postTime){
		this.postNumber=0;
		this.postTime=postTime;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if(this.postNumber==o.postNumber) {
			return o.postTime-this.postTime;
		}
		else {
			return this.postNumber-o.postNumber;
		}
	}

}
